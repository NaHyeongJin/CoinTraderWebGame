<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test = "${row == 1}">
		<script>
			alert("충전이 완료되었습니다");
			location.href="user?cmd=user_edit";
		</script>
	</c:when>
	<c:when test = "${row != 1}">
		<script>
			alert("충전실패");
			history.back();
		</script>
	</c:when>
</c:choose>