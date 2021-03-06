<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 조회</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

	<table>
		<tr> <th>년도</th> <th>학기</th> <th>교과목명</th> <th>교과 구분</th> <th>담당교수</th> <th>학점</th> </tr>
		<c:forEach var="detail" items="${detail}">
			<tr>
			<td><c:out value="${detail.year}"></c:out></td>
			<td><c:out value="${detail.semester}"></c:out></td>
			<td><c:out value="${detail.title}"></c:out></td>
			<td><c:out value="${detail.type}"></c:out></td>
			<td><c:out value="${detail.professor}"></c:out></td>
			<td><c:out value="${detail.credit}"></c:out></td>
			</tr>
		</c:forEach>
	
	</table>

	<p> <a href="${pageContext.request.contextPath}/"> 메인 화면으로 </a></p>

</body>
</html>