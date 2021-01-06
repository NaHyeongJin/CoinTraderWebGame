<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>

<style>

input::-webkit-input-placeholder {text-align: center;}
input::-moz-placeholder {text-align: center;}
input:-ms-input-placeholder {text-align: center;}
input:-moz-placeholder {text-align: center;}
input::placeholder {text-align: center;}


</style>

<title>아이디 찾기</title>
</head>
<body>
</body>
<%@ include file="/include/footer.jsp" %>
<script>
	function findId(){
		location.href="./find_id.do";
	}

	function findPw(){
		location.href="./find_pw.do";
	}

	function signup(){
		location.href="./user_insert.do";
	}
</script>
</html>