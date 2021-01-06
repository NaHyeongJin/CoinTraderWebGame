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

        <h4 class="mb-3">인증 번호 입력</h4>
        (가입시 입력 한 이메일로 보낸 인증번호를 입력해주세요.) 
        
        <form class="needs-validation" novalidate>
            <div class="col-12">
            <br>
              <label for="pw1" class="form-label">인증번호</label>
              <div class="input-group">
                <input type="password" class="form-control" id="authKey" placeholder="인증번호를 입력해주세요.">
              </div>
            </div>

            <div class="col-12 mt-5" >
                <button class="btn btn-outline-primary btn-block" type="button" onclick="checkAuthKey()">확 인</button>
                <button class="btn btn-outline-secondary btn-block" type="button" onclick="location.href='./login.do'">취 소</button>
            </div>
        </form>
</body>
<%@ include file="/include/footer.jsp" %>
<script>
	function checkAuthKey(){
		const id = '<%=request.getAttribute("id")%>';
		const authKey = document.getElementById('authKey').value.trim();
		
	    var params = '?id=' + id + "&authKey=" + authKey;
		   
	   var xhttp = new XMLHttpRequest();
	   xhttp.onreadystatechange = function() {
	     if (this.readyState == 4 && this.status == 200) {
			alert(this.responseText);
			if(this.responseText === '인증이 완료되었습니다.'){
				location.href="./index.do";
			}
	     }
	   };
	   xhttp.open("POST", "./check_authKey.do" + params, true);
	   xhttp.send();
	}
</script>
</html>