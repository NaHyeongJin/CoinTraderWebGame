<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%@ include file = "/include/header.jsp" %>
<table>
	<tr>
		<td>ID</td>
		<td>${vo.id }</td>
	</tr>
</table>
<table>
	<tr>
		<td>제목</td>
		<td>${vo.subject }</td>
	</tr>
</table>
<table>
	<tr>
		<td>내용</td>
		<td>${vo.contents }</td>
	</tr>
</table>
<table>
	<tr>
		<td>등록날짜</td>
		<td>${vo.regdate }</td>
	</tr>
</table>
<table>
	<tr>
		<td>답변상태</td>
		<td></td>
	</tr>
</table>
</body>
 <%@ include file = "/include/footer.jsp" %>
</html>