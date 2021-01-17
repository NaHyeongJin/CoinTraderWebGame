<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>비밀번호 찾기</title>
<script>
	function send() {
		if (pw_search.id.value == "") {
			alert('아이디를 입력해 주세요');
			pw_search.id.focus();
			return;
		}

		if (pw_search.email.value == "") {
			alert('이메일을 입력해 주세요');
			pw_search.email.focus();
			return;
		}

		pw_search.submit();
	}
</script>
</head>
<body>
	<h4 class="mb-1">비밀번호 찾기</h4>
	<h6 class="mb-3">(가입시 입력 한 이메일과 아이디를 입력해주세요.)</h6>

	<form method="post" class="needs-validation" novalidate action="user?cmd=pw_search_pro" name="pw_search">
		<div class="row g-3">
			<div class="col-12">
				<label for="id" class="form-label">아이디</label>
				<div class="input-group">
					<input type="text" class="form-control" name="id" id="id">
				</div>
			</div>
			<div class="col-12">
				<br> <label for="pw2" class="form-label">이메일</label>
				<div class="input-group">
					<input type="text" class="form-control col-5" onkeyup="inputCheckSpecial()" id="email" name="email" placeholder="이메일을 입력해주세요" required> <span style="margin-left: 5px; margin-right: 5px;">@</span> <input type="text" class="form-control col-5" id="emailSelect" name="emailSelect"> <select class="form-control col-2 ml-2" id="emailSelect2" name="emailSelect2" onchange="emailCheck();inputCheckSpecial();">
						<option value="">직접입력</option>
						<option value="naver.com">네이버</option>
						<option value="nate.com">네이트</option>
						<option value="hanmail.net">한메일</option>
						<option value="gmail.com">Gmail</option>
					</select>
				</div>
			</div>
			<div class="col-12 mt-5">
				<button class="btn btn-outline-primary" type="button" onClick="send();">확인</button>
				<a href="index"><button class="btn btn-outline-secondary" type="button">취소</button></a>
			</div>
		</div>
	</form>
</body>
<%@ include file="/include/footer.jsp"%>
</html>