<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<p>
		<a href="${pageContext.request.contextPath}/show"> 학기별 이수 학점 조회 </a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/register"> 수강 신청하기 </a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/check"> 수강 신청 조회 </a>
	</p>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>

	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>


</body>
</html>
