<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${lvo.getRow()==1}">
<script>
location.href="/";
</script>
</c:if>
<c:if test="${lvo.getRow()==0}">
<script>
alert("아이디 또는 비밀번호가 일치하지 않습니다");
history.back();
</script>
</c:if>
