/**
 * Project		: MileNMile
 * FileName		: VersionCheckAspect.java
 * Package		: com.appdisco.mnm.aspect
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 15. 오후 6:31:53
 */
package com.appdisco.mnm.aspect;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.appdisco.mnm.common.ApiException;
import com.appdisco.mnm.common.code.ApiCode;
import com.appdisco.mnm.common.utils.StringUtil;
import com.appdisco.mnm.dao.EndUserAccessDao;
import com.appdisco.mnm.model.EndUserAccess;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.aspect.VersionCheckAspect
 * @file	: VersionCheckAspect.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 15. 오후 6:31:53
 * </PRE>
 */
@Component
public class VersionCheckAspect {

	@Autowired
	private EndUserAccessDao endUserAccessDao;

	@Value(value="${version.server}")
	private String server_version;

    private final Log log = LogFactory.getLog(getClass());

    public Object versionCheck(ProceedingJoinPoint pjp) throws Throwable {
        String targetClassName = pjp.getTarget().getClass().getName();
        String targetMethodName = pjp.getSignature().getName();
        
        // 메소드 실행 전 로깅
        log.debug(targetClassName + "." + targetMethodName + "() START");
        
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            log.info("args[" + i + "] = " + args[i]);
        }
        
        if (!(targetMethodName.startsWith("handle") || targetMethodName.startsWith("getMessage"))) {

//            log.warn("Server version : " + server_version);
        	// 서버 버전 체크
        	int server_version_int = Integer.parseInt(server_version);
        	int version = (Integer)args[0];
        	if (version > server_version_int || version < 1)
        		throw new ApiException(ApiCode.INVALID_VERSION_ERROR);
        	
        	// 로그인 체크 => Access key를 가져와 비교한다. login 메서드와 회원가입 메서드는 제외한다. 
        	if (!(targetMethodName.equals("ping") || targetMethodName.equals("login") || targetMethodName.equals("createAccount"))) {
        		String access_id = (String)args[1];
        		
        		if (StringUtil.isNull(access_id))
        			throw new ApiException(ApiCode.NOT_EXISTS_USER_ERROR);
        		
        		EndUserAccess access = endUserAccessDao.get(access_id);
        		if (access == null) 
        			throw new ApiException(ApiCode.NOT_EXISTS_USER_ERROR);
        		
        		
        	}
        }
        
        // 메소드 실행 (프로파일링)
        long before = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        long after = System.currentTimeMillis();

        // 메소드 실행 후 로깅
        long processingTime = after - before;
        log.debug(targetClassName + "." + targetMethodName + "() END (Processing Time = " + processingTime + "ms)");

        return retVal;
    }

    /**
     * 메소드 수행 시 발생한 에러 로깅하기
     * 
     * @param ex 발생된 예외
     * @throws Throwable 예외
     */
    public void logException(Throwable ex) throws Throwable {
        if (ex instanceof ApiException && ((ApiException)ex).getCode() == ApiCode.PASSWORD_ERROR || ((ApiException)ex).getCode() == ApiCode.INVALID_VERSION_ERROR) {
            log.warn(ex.getMessage()); // 로그인 에러 제외
        } else {
            log.error("----------------------error----------------------");
            log.error(ExceptionUtils.getFullStackTrace(ex));
            // ex.printStackTrace();
            // log.error(ex);
        }
        throw ex;
    }
}
