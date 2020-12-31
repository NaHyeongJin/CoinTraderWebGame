<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>title 써주세요</title>
</head>
<body>
<c:choose>
		<c:when test = "${row==1}">
			<script>
				alert("삭제완료");
				location.href="qna?cmd=qna_list";
			</script>
		</c:when>
		<c:when test = "${row==0}">
			<script>
				alert("삭제실패");
				history.back();
			</script>
		</c:when>
</c:choose>
</body>
<%@ include file="/include/footer.jsp" %>
</html>