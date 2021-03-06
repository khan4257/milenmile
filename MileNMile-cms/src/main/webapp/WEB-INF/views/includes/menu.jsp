<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="taglibs.jsp"%>
<%!
	static final String HOME_MENU_ID = "home";
	static final String HOME_MENU_NAME = "Home";
	static final String HOME_MENU_URL = "/admin/index";

	static final String[][] TOP_MENU = { // 순서 중요
	    {"home", "Home", "/admin/index"},
	    {"users", "회원 정보 관리", "/admin/users"},
	    {"stores", "스토어 상품 관리", "/admin/stores"},
	    {"ads", "광고 관리", "/admin/ads"},
	    {"nfc", "NFC 관리", "/admin/nfc"},
	    {"refunds", "환급 요청 관리", "/admin/refunds"},
	    {"stats", "통계 관리", "/admin/stats"},
	    {"service", "서비스 관리", "/admin/service"},
	    {"stats", "CMS 관리자 설정", "/admin/admin"}
	};

	static final String[][][] SUB_MENU = { // 순서 중요 (TOP_MENU 순서대로)
	    {
		    //{"01", "Submenu01", "/admin/submenu01"},
		    //{"02", "Submenu02", "/admin/submenu02"}
	    },
	    {
		    {"11", "회원 정보 관리", "/admin/users"}
	    },
	    {
		    {"21", "스토어 상품 관리", "/admin/stores"}
		    //{"22", "상용 애플리케이션", "/admin/apps?action=onsaleList"},
		    //{"23", "개발 애플리케이션", "/admin/apps?action=offsaleList"}	        
	    },
	    {
		    {"31", "광고 관리", "/admin/ads"}
		    //,{"32", "Promotion 광고", "/admin/promotionppiads"}	        
	    }, 
	    {
	        {"41", "NFC 관리", "/admin/nfc"}
	    }, 
	    {
	        {"51", "환급 요청 관리", "/admin/refunds"}
	    },
	    {
	        {"61", "통계 관리", "/admin/stats"}
	    },
	    {
	        {"71", "서비스 관리", "/admin/service"}
	    },
	    {
	        {"81", "CMS 관리자 설정", "/admin/admin"}
	    }
	};

	/*
	static java.util.Map TOP_MENU_MAP = new java.util.HashMap();
	
	static java.util.Map SUB_MENU_MAP = new java.util.HashMap();
	
	static synchronized java.util.Map getTopMenuMap() {
	    if (TOP_MENU_MAP == null) {
	        TOP_MENU_MAP = new java.util.HashMap();
	    }
	    if (TOP_MENU_MAP.size() == 0) {
	        for (int i = 0; i < TOP_MENU.length; i++) {
	            TOP_MENU_MAP.put(TOP_MENU[i][0], TOP_MENU[i]);
	        }
	        System.out.println("TOP_MENU_MAP created.");
	    }
	    return TOP_MENU_MAP;        
	}
	
	static synchronized java.util.Map getSubMenuMap() {
	    if (SUB_MENU_MAP == null) {
	        SUB_MENU_MAP = new java.util.HashMap();
	    }
	    if (SUB_MENU_MAP.size() == 0) {
	        for (int i = 0; i < TOP_MENU.length; i++) {
	            SUB_MENU_MAP.put(TOP_MENU[i][0], SUB_MENU[i]);
	        }
	        System.out.println("SUB_MENU_MAP created.");
	    }
	    return SUB_MENU_MAP;        
	}
	*/
%>
<%
	/* left.jsp, indicator.jsp 에서 사용됨 */
	request.setAttribute("HOME_MENU_ID", HOME_MENU_ID);
	request.setAttribute("HOME_MENU_NAME", HOME_MENU_NAME);
	request.setAttribute("HOME_MENU_URL", HOME_MENU_URL);
	request.setAttribute("TOP_MENU", TOP_MENU);
	request.setAttribute("SUB_MENU", SUB_MENU);
	//request.setAttribute("TOP_MENU_MAP", getTopMenuMap());
	//request.setAttribute("SUB_MENU_MAP", getSubMenuMap());
	
	/* indicator.jap 에서 사용됨 */
    String topMenu = (String) request.getAttribute("topMenu");
    String subMenu = (String) request.getAttribute("subMenu");
    int topIdx = 0;
    int subIdx = 0;
    if (TOP_MENU != null && topMenu != null) {
        for (int i = 0; i < TOP_MENU.length; i++) {
            if (topMenu.equals(TOP_MENU[i][0])) {
                topIdx = i;
                break;
            }
        }
        if (SUB_MENU != null && subMenu != null) {
            for (int i = 0; i < SUB_MENU[topIdx].length; i++) {
                if (subMenu.equals(SUB_MENU[topIdx][i][0])) {
                    subIdx = i;
                    break;
                }
            }
        }
    }
    request.setAttribute("topIdx", new Integer(topIdx));
    request.setAttribute("subIdx", new Integer(subIdx));	
%>
<%--
<ul>
	<li><a
		class="<c:if test="${topMenu == 'home'}"><c:out value="current" /></c:if>"
		href="<c:url value='/'/>">Home</a></li>
	<li><a
		class="<c:if test="${topMenu == 'menu1'}"><c:out value="current" /></c:if>"
		href="<c:url value='/menu1'/>">Menu1</a></li>
	<li><a
		class="<c:if test="${topMenu == 'menu2'}"><c:out value="current" /></c:if>"
		href="<c:url value='/menu2'/>">Menu2</a></li>
	<li><a
		class="<c:if test="${topMenu == 'menu3'}"><c:out value="current" /></c:if>"
		href="<c:url value='/menu3'/>">Menu3</a></li>
</ul>
--%>
<c:forEach items="${TOP_MENU}" var="T_MENU" varStatus="status">
	<c:if test="${status.first}"><c:out value='<ul>' escapeXml="false" /></c:if>
	<li><a
		class="<c:if test="${topMenu eq T_MENU[0]}"><c:out value="current" /></c:if>"
		href="<c:url value='${T_MENU[2]}'/>"><c:out value='${T_MENU[1]}' /></a></li>
	<c:if test="${status.last}"><c:out value='</ul>' escapeXml="false" /></c:if>
</c:forEach>
