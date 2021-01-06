<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${row == 1}">
<script>
location.href="index";
</script>
</c:if>
<c:if test="${row != 1}">
<script>
alert("아이디또는 비밀번호가 다릅니다.");
history.back();
</script>
</c:if>