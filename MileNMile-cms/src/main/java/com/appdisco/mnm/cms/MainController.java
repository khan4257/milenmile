/**
 * Project		: MileNMile
 * FileName		: MainController.java
 * Package		: com.appdisco.mnm.web
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 28. 오후 6:37:06
 */
package com.appdisco.mnm.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appdisco.mnm.controllers.BaseController;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.web.MainController
 * @file	: MainController.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 28. 오후 6:37:06
 * </PRE>
 */
@Controller
@RequestMapping(value="/*")
public class MainController extends BaseController {
	
	@RequestMapping(value={"/", "index"})
	public String index() {
		return "index";
	}
}
