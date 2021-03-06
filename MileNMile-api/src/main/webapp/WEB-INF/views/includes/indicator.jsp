<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="taglibs.jsp"%>
<%
    /*
    String[][] TOP_MENU = (String[][]) request.getAttribute("TOP_MENU");
    String[][][] SUB_MENU = (String[][][]) request.getAttribute("SUB_MENU");
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
    */
%>
<!--
[<c:out value="${topMenu}" />|<c:out value="${subMenu}" />
|<c:out value="${topIdx}" />|<c:out value="${subIdx}" />]
[<c:out value="${HOME_MENU_ID}" />|<c:out value="${HOME_MENU_NAME}" />
|<c:out value="${HOME_MENU_URL}" />]
-->
<c:choose>
	<c:when test="${topMenu == HOME_MENU_ID}">
		<c:choose>
			<c:when test="${empty subMenu}">
				<a class="current" href="<c:url value='${HOME_MENU_URL}'/>"><c:out
					value='${HOME_MENU_NAME}' /></a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='${HOME_MENU_URL}'/>"><c:out
					value='${HOME_MENU_NAME}' /></a>
				&gt; <a class="current"
					href="<c:url value='${SUB_MENU[topIdx][subIdx][2]}'/>"><c:out
					value='${SUB_MENU[topIdx][subIdx][1]}' /></a>
			</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
		<a href="<c:url value='${HOME_MENU_URL}'/>"><c:out
			value='${HOME_MENU_NAME}' /></a>
		<c:if test="${not empty topMenu}">
			<c:choose>
				<c:when test="${empty subMenu}">
				&gt; <a class="current"
						href="<c:url value='${TOP_MENU[topIdx][2]}'/>"><c:out
						value='${TOP_MENU[topIdx][1]}' /></a>
				</c:when>
				<c:otherwise>
				&gt; <a href="<c:url value='${TOP_MENU[topIdx][2]}'/>"><c:out
						value='${TOP_MENU[topIdx][1]}' /></a>
				&gt; <a class="current"
						href="<c:url value='${SUB_MENU[topIdx][subIdx][2]}'/>"><c:out
						value='${SUB_MENU[topIdx][subIdx][1]}' /></a>
				</c:otherwise>
			</c:choose>
		</c:if>
	</c:otherwise>
</c:choose>
