<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${row == 1}">
	<c:if test="${loginCheck && pwCheck}">
		<script>
			location.href="index";
		</script>
	</c:if>
	<c:if test="${!loginCheck}">
		<script>
			alert("가입시 입력한 이메일로 인증번호를 발송했습니다.");
			location.href="user?cmd=login_check";
		</script>
	</c:if>
	<c:if test="${!pwCheck}">
		<script>
			alert("임시비밀번호로 로그인하셨습니다. 비밀번호 변경을 권장드립니다.");
			location.href="user?cmd=user_edit";
		</script>
	</c:if>
</c:if>
<c:if test="${row != 1}">
	<script>
		alert("아이디또는 비밀번호가 다릅니다.");
		history.back();
	</script>
</c:if>