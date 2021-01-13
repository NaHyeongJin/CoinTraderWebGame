<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>이메일 인증</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	function send() {
		if (id_check.emailCheck.value == "") {
			alert('인증번호를 입력해 주세요');
			return;
		}
		id_check.submit();
	}
	function reSend() {
		$.ajax({
		    url: "http://localhost:8089/CoinTraderWebGame/user?cmd=auth_key_resend",
		    method: "GET",
		    dataType: "JSON",
		    success: function(row) {
		    	if (row == 1) {
					alert("인증번호를 재발송했습니다.");
				} else {
					alert("인증번호 발송에 실패했습니다.");
				}
		   	}
		});
	}
</script>
</head>
<body>
	<h4 class="mb-1">이메일 인증</h4>
	<h6 class="mb-3">(가입시 입력 한 이메일로 발송된 인증번호를 입력해주세요.)</h6>

	<form method="post" class="needs-validation" novalidate action="user?cmd=auth_key_check" name="id_check">
		<div class="row g-3">
			<div class="col-12">
            <br>
              <label for="emailCheck" class="form-label">인증번호</label>
              <div class="input-group">
                <input type="text" class="form-control" id="emailCheck" name="emailCheck" placeholder="인증번호를 입력해주세요">
                <button type="button" class="btn btn-outline-primary ml-3" onClick="reSend();">재발송</button>
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