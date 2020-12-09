<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 신청 완료</title>
<link rel = "stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

<h2>수강 신청 완료</h2>
<table>
	<tr> <th>년도</th> <td> ${lecture.year } </td> </tr>	
	<tr> <th>학기</th> <td> ${lecture.semester } </td> </tr>
	<tr> <th>신청 과목</th> <td> ${lecture.title } </td> </tr>
	<tr> <th>교과 구분</th> <td> ${lecture.type } </td>  </tr>
	<tr> <th>담당 교수</th> <td> ${lecture.professor } </td>  </tr>
	<tr> <th>학점</th> <td> ${lecture.credit } </td>  </tr>
</table>

<p> <a href="${pageContext.request.contextPath}/"> 메인 화면으로 </a></p>
<p> <a href="${pageContext.request.contextPath}/check"> 신청 확인하기 </a></p>
</body>
</html>