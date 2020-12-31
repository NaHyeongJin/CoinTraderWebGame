<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>삭제확인</title>
<meta charset="UTF-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
<table>
	<tr>
		<h3 align=center>정말로 삭제하시겠습니까?</h3><br>
	</tr>
	<tr>
		<td>
		<button type="button" class="btn btn-outline-primary" onClick="location.href='qna?cmd=qna_delete_pro'">삭제하기</button>
		<button type="button" class="btn btn-outline-primary" onClick="history.back()">취소하기</button>
		</td>
	</tr>
</table>
</body>
</html>