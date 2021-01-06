<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>비밀번호 수정</title>
</head>
<body>
	<h4 class="mb-3">비밀번호 수정</h4>
	<form name="frm" class="needs-validation" novalidate>
		<div class="row g-3">
			<div class="col-12">
				<label for="pw1" class="form-label">비밀번호 수정</label>
				<div class="input-group">
					<input type="password" class="form-control" id="pw"
						placeholder="비밀번호 수정">
				</div>
			</div>

			<div class="col-12">
				<label for="pw2" class="form-label">비밀번호 확인</label>
				<div class="input-group">
					<input type="password" class="form-control" id="re_pw"
						placeholder="비밀번호 수정 확인">
				</div>
			</div>
			<div class="col-12 mt-5">
				<button class="btn btn-outline-primary" type="button"
					onclick="updateProfile()">정보 수정</button>
				<button class="btn btn-outline-secondary" type="button"
					onclick="location.href='./index.do'">돌아가기</button>
			</div>
		</div>
	</form>
	<script>
		var checkPw = /^[0-9a-z~`!@#$%\^&*()-+=]{4,20}$/;
		function updateProfile() {
			if (!checkPw.test(frm.pw.value.trim())) {
				alert('비밀번호는 한글을 제외한 숫자, 특수문자 4~20자 사이로 입력해주세요.');
				frm.pw.focus();
				return;
			}

			if (frm.pw.value == "") {
				alert("비밀번호를 입력해주세요");
				frm.pw.focus();
				return;
			}

			if (frm.re_pw.value == "") {
				alert("비밀번호를 확인해주세요");
				frm.re_pw.focus();
				return;
			}

			if (frm.re_pw.value != frm.pw.value) {
				alert("비밀번호가 일치하지 않습니다.");
				frm.re_pw.focus();
				return;
			}

			var params = "?pw=" + frm.pw.value;

			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					alert(this.responseText);
					if (this.responseText === '비밀번호 변경 완료') {
						location.href = "./index.do";
					}
				}
			};
			xhttp.open("POST", "./update_handle.do" + params, true);
			xhttp.send();
		}
	</script>
</body>
<%@ include file="/include/footer.jsp"%>
</html>