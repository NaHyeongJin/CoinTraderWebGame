<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>ID 찾기</title>
</head>
<body>
	<h4 class="mb-3">아이디 찾기</h4>
	(가입시 입력 한 이메일을 입력해주세요.)

	<form class="needs-validation" novalidate>
		<div class="row g-3">
			<div class="col-12">
				<br> <label for="email" class="form-label">이메일</label>
				<div class="input-group">
					<input type="text" class="form-control" id="email"
						placeholder="회원 가입시 등록 한 이메일을 입력하여주세요." required>
				</div>
			</div>
			<div class="col-12 mt-5">
				<button class="btn btn-outline-primary" type="submit">확인</button>
				<a href="index"><button class="btn btn-outline-secondary" type="button">취소</button></a>
			</div>
		</div>
	</form>
</body>
<%@ include file="/include/footer.jsp"%>
</html>