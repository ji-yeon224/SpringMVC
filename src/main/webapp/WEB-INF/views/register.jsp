<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 신청</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/doRegister"
		modelAttribute="lecture">

		<table>
			<tr>
				<th>신청 과목명</th>
				<td><sf:input type="text" path="title" /><br/>
				<sf:errors path="title" class="error"/>
				</td>
			</tr>
			<tr>
				<th>교과 구분</th>
				<td><sf:input type="text" path="type" /><br/>
				<sf:errors path="type" class="error"/></td>
			</tr>
			<tr>
				<th>담당 교수</th>
				<td><sf:input type="text" path="professor" /><br/>
				<sf:errors path="professor" class="error"/></td>
			</tr>
			<tr>
				<th>학점</th>
				<td><sf:input type="number" path="credit" min="1" max="5" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="신청" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>