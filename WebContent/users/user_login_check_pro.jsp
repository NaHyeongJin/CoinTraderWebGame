<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${row==1}">
	<script>
		alert("이메일 인증이 완료되었습니다.");
		location.href = "index";
	</script>
</c:if>

<c:if test="${row==0}">
	<script>
		alert("인증번호를 다시 확인해주시기 바랍니다.");
		history.back();
	</script>
</c:if>