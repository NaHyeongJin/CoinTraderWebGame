<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>아이디 찾기</title>
<script>
	function send() {
		if (id_search.email.value == "") {
			alert('이메일을 입력해 주세요');
			return;
		}
		id_search.submit();
	}
</script>
</head>
<body>
	<h4 class="mb-1">아이디 찾기</h4>
	<h6 class="mb-3">(가입시 입력 한 이메일을 입력해주세요.)</h6>

	<form method="post" class="needs-validation" novalidate action="user?cmd=id_search_pro" name="id_search">
		<div class="row g-3">
			<div class="col-12">
            <br>
              <label for="pw2" class="form-label">이메일</label>
              <div class="input-group">
                <input type="text" class="form-control" id="email" name="email" placeholder="회원가입시 입력한 이메일을 입력해주세요">
                <span style="margin-left: 5px; margin-right: 5px;">@</span>
				<select class="form-control" id="emailSelect" name="emailSelect">
			    	<option value="naver.com">naver.com</option>
				    <option value="gmail.com">google.com</option>
				    <option value="hanmail.com">hanmail.com</option>
				</select>
              </div>
            </div>
			<div class="col-12 mt-5">
				<button class="btn btn-outline-primary" onClick="send();" type="button">확인</button>
				<a href="index"><button class="btn btn-outline-secondary" type="button">취소</button></a>
			</div>
		</div>
	</form>
</body>
<%@ include file="/include/footer.jsp"%>
</html>