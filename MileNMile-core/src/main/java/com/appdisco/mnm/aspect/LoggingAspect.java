/*
 * @(#)LoggingAspect.java
 *
 * Copyright (c) 2009 Moduad, Inc.
 * All rights reserved.
 */
package com.appdisco.mnm.aspect;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import com.appdisco.mnm.common.ApiException;
import com.appdisco.mnm.common.code.ApiCode;

/**
 * 메소드 수행속도 및 예외사항 로깅을 위한 Aspect 클래스
 * 
 * @author Sehwan Noh (sehwan@java2go.net)
 * @version 1.0
 */
@Component
public class LoggingAspect {

    private final Log log = LogFactory.getLog(getClass());

    /**
     * 수행속도 임계값
     */
    private long thresholdInMills = 3000L;

    /**
     * 수행속도 임계값 Setter
     * 
     * @param thresholdInMills 수행속도 임계값 (밀리 세컨드)
     */
    public void setThresholdInMills(long thresholdInMills) {
        this.thresholdInMills = thresholdInMills;
    }

    /**
     * 메소드 수행정보 및 수행시간 로깅하기
     * 
     * @param pjp 조인포인트
     * @return 메소드 처리 결과
     * @throws Throwable 예외
     */
    public Object logProfiling(ProceedingJoinPoint pjp) throws Throwable {
        String targetClassName = pjp.getTarget().getClass().getName();
        String targetMethodName = pjp.getSignature().getName();

        // 메소드 실행 전 로깅
        // log.debug(targetClassName + "." + targetMethodName + "() 시작");
        log.debug(targetClassName + "." + targetMethodName + "() START");
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            log.debug("args[" + i + "] = " + args[i]);
        }

        // 메소드 실행 (프로파일링)
        long before = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        long after = System.currentTimeMillis();

        // 메소드 실행 후 로깅
        long processingTime = after - before;
        log.debug(targetClassName + "." + targetMethodName + "() END (Processing Time = " + processingTime + "ms)");

        // 수행시간이 임계값보다 오래 걸리면 경고 로깅
        if (processingTime > thresholdInMills) {
            log.warn(">>> " + targetClassName + "." + targetMethodName + "() Processing time exceeds "
                    + thresholdInMills / 1000 + " seconds [" + processingTime + "]");
        }

        return retVal;
    }

    /**
     * 메소드 수행 시 발생한 에러 로깅하기
     * 
     * @param ex 발생된 예외
     * @throws Throwable 예외
     */
    public void logException(Throwable ex) throws Throwable {
        if (ex instanceof ApiException && ((ApiException)ex).getCode() == ApiCode.PASSWORD_ERROR) {
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
