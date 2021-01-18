<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>이메일과 일치하는 회원입니다.</title>
</head>
<body>
<c:if test="${row == 1}">
	<h4 class="mb-3">${email}로 회원가입하신 아이디는 ${idCheck}입니다.</h4>
</c:if>
<c:if test="${row != 1}">
	<script>
		alert("입력하신 이메일 주소와 일치하는 회원이 없습니다.");
		history.back();
	</script>
</c:if>
</body>
<%@ include file="/include/footer.jsp"%>
</html>