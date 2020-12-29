<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${lvo.getRow()==1}">
<script>
alert("로그인 성공");
location.href="index";
</script>
</c:if>
<c:if test="${lvo.getRow()==0}">
<script>
alert("비번이 일치하지 않음");
history.back();
</script>
</c:if>
<c:if test="${lvo.getRow()==-1}">
<script>
alert("아이디가 일치하지 않음");
history.back();
</script>
</c:if>