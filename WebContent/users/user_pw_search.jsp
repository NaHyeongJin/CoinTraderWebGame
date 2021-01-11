<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>비밀번호 찾기</title>
</head>
<body>
	<h4 class="mb-3">비밀번호 찾기</h4>
	<form class="needs-validation" novalidate>

		<div class="col-12">
			<label for="id" class="form-label">이메일과 아이디를 입력해주세요.</label> <br>(가입시
			입력 한 이메일로 임시 비밀번호를 전송하여 드립니다.)<br>
			<br>
			<div class="input-group">
				<input type="text" class="form-control" id="id"
					placeholder="회원 가입시 등록 한 아이디를 입력하여주세요.">
			</div>
			<br>
			<div class="input-group">
				<input type="text" class="form-control" id="email"
					placeholder="회원 가입시 등록 한 이메일을 입력하여주세요.">
			</div>
		</div>

		<div class="col-12 mt-5">
			<button class="btn btn-outline-primary" type="submit">확인</button>
			<a href="index"><button class="btn btn-outline-secondary" type="button">취소</button></a>
		</div>
	</form>
</body>
<%@ include file="/include/footer.jsp"%>
</html>