<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
var userAbleId = false;
var userAbleEmail = false;
var checkPw = /^[0-9a-z~`!@#$%\^&*()-+=]{4,20}$/;

function inputCheckSpecial(){
  var checkId = document.getElementById('checkId');
  userAbleId = false;
  var strobj = document.all.id; 
   if(strobj.value === ''){
	   checkId.innerHTML = '<span class="badge badge-secondary">아이디를 입력해주세요.</span>';
	   checkId.style.color = "black";
	   return;
   }
   
   var string  = /admin/;
   if(string.test(frm.id.value)){
	  checkId.innerHTML = '<span class="badge badge-danger">admin 아이디는 관리자만 사용이 가능합니다.</span>';
      frm.tel.focus();
      return;
   }
   
   if(frm.id.value != "") {
		$.ajax({
		    url: "http://localhost:8089/CoinTraderWebGame/UserIdCheck?id=" + frm.id.value,
		    method: "GET",
		    dataType: "JSON",
		    success: function(data) {
		    	if(data) {
		    		checkId.innerHTML = '<span class="badge badge-success">사용가능한 아이디입니다.</span>';
					userAbleId = true;
		    	} else {
		    		checkId.innerHTML = '<span class="badge badge-danger">중복된 아이디입니다.</span>';
		    		userAbleId = false;
		    	}
		   	}
		})
   }
   else {
	    checkId.innerHTML = '<span class="badge badge-secondary">아이디를 입력해주세요.</span>';
		userAbleId = false;
   }
	if(frm.email.value != "") {
		$.ajax({
		    url: "http://localhost:8089/CoinTraderWebGame/UserEmailCheck?email=" + frm.email.value + "&emailSelect=" + frm.emailSelect.value,
		    method: "GET",
		    dataType: "JSON",
		    success: function(data) {
		    	if(data) {
		    		checkEmail.innerHTML = '<span class="badge badge-success">사용가능한 이메일입니다.</span>';
					userAbleEmail = true;
		    	} else {
		    		checkEmail.innerHTML = '<span class="badge badge-danger">중복된 이메일입니다.</span>';
		    		userAbleEmail = false;
		    	}
		   	}
		})
	} else {
		checkEmail.innerHTML = '<span class="badge badge-secondary">이메일을 입력해주세요.</span>';
		userAbleEmail = false;
	}
}
   function checkValue(){
	   if(!userAbleId){
		 alert('아이디를 다시 입력해주세요.');
         frm.id.focus();
         return;
	   }
	   
	   if(!userAbleEmail){
			 alert('이메일을 다시 입력해주세요.');
	         frm.email.focus();
	         return;
	  }
	   
	   
      if(frm.id.value==""){
         alert("회원아이디를 입력해주세요");
         frm.id.focus();
         return;
      }
      
      if(!checkPw.test(frm.pw.value.trim())){
    	  alert('비밀번호는 한글을 제외한 숫자, 특수문자 4~20자 사이로 입력해주세요.');
          frm.pw.focus();
    	  return;
      }
      
      if(frm.pw.value==""){
         alert("비밀번호를 입력해주세요");
         frm.pw.focus();
         return;
      }
      
      if(frm.re_pw.value==""){
          alert("비밀번호를 확인해주세요");
          frm.re_pw.focus();
          return;
       }
      
      
      if(frm.re_pw.value != frm.pw.value ){
          alert("비밀번호가 일치하지 않습니다.");
          frm.re_pw.focus();
          return;
       }
      
      if(frm.email.value==""){
         alert("이메일을 입력해주세요");
         frm.email.focus();
         return;
      }

      frm.submit();
   }
	
	function checkPassword(){
		const checkPwTxt1 = document.querySelector("#checkPwTxt1");
		const checkPwTxt2 = document.querySelector("#checkPwTxt2");
		const pw = frm.pw.value.trim();
		const re_pw = frm.re_pw.value.trim();
		checkPwTxt2.style.color = "black";
		if(pw === ''){
			checkPwTxt1.innerHTML = '<span class="badge badge-secondary">비밀번호를 입력해주세요.</span>';
		} else {
			checkPwTxt1.innerHTML = '<span class="badge badge-secondary"></span>';
		}
		if(re_pw === ''){
			checkPwTxt2.innerHTML = '<span class="badge badge-secondary">비밀번호 체크란을 입력해주세요.</span>';
		} else {
			checkPwTxt1.innerHTML = '<span class="badge badge-secondary"></span>';
		}
		if(pw === '' && re_pw === '') {
			return;
		}
		if(pw === re_pw){
			checkPwTxt2.innerHTML = '<span class="badge badge-success">비밀번호가 서로 일치합니다.</span>';
			checkPwTxt2.style.color = "blue";
		}else{
			checkPwTxt2.innerHTML = '<span class="badge badge-danger">비밀번호가 서로 일치하지 않습니다.</span>';
			checkPwTxt2.style.color = "red";
		}
	}
	
	function emailCheck() {
		let emailSelect = document.getElementById('emailSelect');
		let emailSelect2 = document.getElementById('emailSelect2');
		if(emailSelect2.value == '') {
			// email2 readonly 해제하고 입력가능하게 변경
			emailSelect.value = '';
			emailSelect.readOnly = false;
		} else {
			emailSelect.value = emailSelect2.value;
			emailSelect.readOnly = true;
		}
	}
</script>
<title>회원가입</title>
</head>
<body>
    <h4 class="mb-3">회원가입</h4>
    (회원가입을 완료하시면 자본금 1만원을 드립니다.)
    <br><br>
	<form name="frm" method="post" action="user?cmd=sign_up_pro">
        <div class="row g-3">
            <div class="col-12">
              <label for="id" class="form-label">아이디</label>
              <div class="input-group">
                <input type="text" class="form-control" onkeyup="inputCheckSpecial()" name="id" id="id" required>
              </div>
              <span id="checkId"><span class="badge badge-secondary">아이디를 입력해주세요.</span></span>
            </div>
           
           
            <div class="col-12">
            <br>
              <label for="pw1" class="form-label">비밀번호</label>
              <div class="input-group">
                <input type="password" class="form-control" name="pw" id="pw" placeholder="비밀번호 입력" onkeyup="checkPassword()" required>
              </div>
            </div>
			<span id="checkPwTxt1"><span class="badge badge-secondary">비밀번호를 입력해주세요.</span></span>

            <div class="col-12">
            <br>
              <label for="re_pw" class="form-label">비밀번호 확인</label>
              <div class="input-group">
                <input type="password" class="form-control" id="re_pw" placeholder="비밀번호 확인" onkeyup="checkPassword()" required>
              </div>
            </div>
            <span id="checkPwTxt2"><span class="badge badge-secondary">비밀번호 체크란을 입력해주세요.</span></span>
            
            <div class="col-12">
            <br>
              <label for="pw2" class="form-label">이메일</label>
              <div class="input-group">
                <input type="text" class="form-control col-5" onkeyup="inputCheckSpecial()" id="email" name="email" placeholder="이메일을 입력해주세요" required>
                <span style="margin-left: 5px; margin-right: 5px;">@</span>
                <input type="text" class="form-control col-5" id="emailSelect" name="emailSelect">
				<select class="form-control col-2 ml-2" id="emailSelect2" name="emailSelect2" onchange="emailCheck();inputCheckSpecial();">
			    	<option value="">직접입력</option> 
					<option value="naver.com">네이버</option> 
					<option value="nate.com">네이트</option> 
					<option value="hanmail.net">한메일</option>
					<option value="gmail.com">Gmail</option>
				</select>
              </div>
              <span id="checkEmail"><span class="badge badge-secondary">이메일을 입력해주세요.</span></span>
            </div>
            
            <div class="col-12 mt-5">
				<button class="btn btn-outline-primary" onclick="checkValue()" type="button">완료</button>
				<a href="index"><button class="btn btn-outline-secondary" type="button">뒤로</button></a>
			</div>
        </div>
	</form>
</body>
<%@ include file="/include/footer.jsp" %>
</html>