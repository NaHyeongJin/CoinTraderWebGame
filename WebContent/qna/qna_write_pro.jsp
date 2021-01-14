<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
		<c:when test = "${row==1}">
			<script>
				alert("등록되었습니다");
				location.href="qna?cmd=qna_list";
			</script>
		</c:when>
		<c:when test = "${row==0}">
			<script>
				alert("등록실패");
				history.back();
			</script>
		</c:when>
</c:choose>
