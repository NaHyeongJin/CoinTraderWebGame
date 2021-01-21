<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>구매 내역</title>
</head>
<body>
	<c:forEach var="vo" items="${vo}">
		<tr>
			<th>${vo.name}</th>
			<th>${vo.count}</th>
			<th>${vo.regdate}</th>
			<th>${vo.price}</th>
		</tr>
		<br>
	</c:forEach>
</body>
<%@ include file="/include/footer.jsp"%>
</html>
