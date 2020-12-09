<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학기별 이수 학점 조회</title>
<link rel = "stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

<table>
<tr><th>년도</th><th>학기</th><th>취득 학점</th><th>상세 보기</th></tr>
	<c:forEach var="credit" items="${credit}">
		
		<tr>
		<td><c:out value="${credit.year}"></c:out></td>
		<td><c:out value="${credit.semester}"></c:out></td>
		<td><c:out value="${credit.credit }"></c:out></td>
		<td>
			<c:url value="/detail" var="url">
			  <c:param name="year" value="${credit.year}" />			
			  <c:param name="semester" value="${credit.semester}" />
			</c:url>
			<a href="${url}">링크</a>

		</td>
		</tr>
		
	</c:forEach>
	<tfoot><tr><td>총계</td><td></td><td>${all}</td><td></td></tr></tfoot>

</table>
<p> <a href="${pageContext.request.contextPath}/"> 메인 화면으로 </a></p>
</body>
</html>