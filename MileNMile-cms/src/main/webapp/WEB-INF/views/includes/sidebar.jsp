<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="taglibs.jsp"%>
<%--
<c:choose>
	<c:when test="${topMenu == 'home'}">
		<ul>
			<li><a class="" href="<c:url value='/submenu01.htm'/>">Submenu01</a></li>
			<li><a class="" href="<c:url value='/submenu02.htm'/>">Submenu02</a></li>
		</ul>
	</c:when>
	<c:when test="${topMenu == 'menu1'}">
		<ul>
			<li><a class="<c:if test="${subMenu == '11'}"><c:out value="current" /></c:if>"
				href="<c:url value='/submenu11.htm'/>">Submenu11</a></li>
			<li><a class="<c:if test="${subMenu == '12'}"><c:out value="current" /></c:if>"
				href="<c:url value='/submenu12.htm'/>">Submenu12</a></li>
			<li><a class="<c:if test="${subMenu == '13'}"><c:out value="current" /></c:if>"
				href="<c:url value='/submenu13.htm'/>">Submenu13</a></li>
			<li><a class="<c:if test="${subMenu == '14'}"><c:out value="current" /></c:if>"
				href="<c:url value='/submenu14.htm'/>">Submenu14</a></li>
			<li><a class="<c:if test="${subMenu == '15'}"><c:out value="current" /></c:if>"
				href="<c:url value='/submenu15.htm'/>">Submenu15</a></li>
		</ul>
	</c:when>
	<c:when test="${topMenu == 'menu2'}">
		<ul>
			<li><a class="" href="<c:url value='/'/>">Submenu21</a></li>
			<li><a class="" href="<c:url value='/'/>">Submenu22</a></li>
			<li><a class="" href="<c:url value='/'/>">Submenu23</a></li>
			<li><a class="" href="<c:url value='/'/>">Submenu24</a></li>
			<li><a class="" href="<c:url value='/'/>">Submenu25</a></li>
		</ul>
	</c:when>
	<c:when test="${topMenu == 'menu3'}">
		<ul>
			<li><a class="" href="<c:url value='/'/>">Submenu31</a></li>
			<li><a class="" href="<c:url value='/'/>">Submenu32</a></li>
			<li><a class="" href="<c:url value='/'/>">Submenu33</a></li>
			<li><a class="" href="<c:url value='/'/>">Submenu34</a></li>
			<li><a class="" href="<c:url value='/'/>">Submenu35</a></li>
		</ul>
	</c:when>
	<c:otherwise>
		<!-- no submenu -->
	</c:otherwise>
</c:choose>
--%>
<c:forEach items="${TOP_MENU}" var="T_MENU" varStatus="topStatus">
	<c:if test="${topMenu eq T_MENU[0]}">
		<c:forEach items="${SUB_MENU[topStatus.index]}" var="S_MENU" varStatus="status">
			<c:if test="${status.first}"><c:out value='<ul>' escapeXml="false" /></c:if>
			<li><a
				class="<c:if test="${subMenu eq S_MENU[0]}"><c:out value="current" /></c:if>"
				href="<c:url value='${S_MENU[2]}'/>"><c:out value='${S_MENU[1]}' /></a></li>
			<c:if test="${status.last}"><c:out value='</ul>' escapeXml="false" /></c:if>
		</c:forEach>
	</c:if>
</c:forEach>
<%--
<c:forEach items="${SUB_MENU_MAP[topMenu]}" var="S_MENU" varStatus="status">
	<c:if test="${status.first}"><c:out value='<ul>' escapeXml="false" /></c:if>
	<li><a
		class="<c:if test="${subMenu == S_MENU[0]}"><c:out value="current" /></c:if>"
		href="<c:url value='${S_MENU[2]}'/>"><c:out value='${S_MENU[1]}' /></a></li>
	<c:if test="${status.last}"><c:out value='</ul>' escapeXml="false" /></c:if>
</c:forEach>
--%>