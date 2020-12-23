<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
		<c:when test = "${row==1}">
			<script>
				alert("수정되었습니다");
				location.href ="/" ;			
			</script>
		</c:when>
		<c:when test = "${row==0}">
			<script>
				alert("수정실패");
				history.back();
			</script>
		</c:when>
	</c:choose>
</body>
</html>