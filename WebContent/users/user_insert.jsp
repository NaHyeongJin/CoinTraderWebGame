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

<script>
var userAbleId = false;
var checkPw = /^[0-9a-z~`!@#$%\^&*()-+=]{4,20}$/;

function inputCheckSpecial(){
  var checkId = document.getElementById('checkId');
  userAbleId = false;
  var strobj = document.all.id; 
  re = /[~!@\#$%^&*\()\-=+_']/gi;
   if(strobj.value === ''){
	   checkId.innerHTML = '<span class="badge badge-secondary">아이디를 입력해주세요.</span>';
	   checkId.style.color = "black";
	   return;
   }
  
   if(re.test(strobj.value)){
	   checkId.innerHTML = "아이디에 특수문자는 입력하실수 없습니다.";
       strobj.value=strobj.value.replace(re,"");
	}
   
   var string  = /admin/;
   if(string.test(frm.id.value)){
	   checkId.innerHTML = "admin 아이디는 관리자만 사용이 가능합니다.";
      frm.tel.focus();
      return;

   }
   var params = '?id=' + strobj.value;
   
   var xhttp = new XMLHttpRequest();
   xhttp.onreadystatechange = function() {
     if (this.readyState == 4 && this.status == 200) {
		if(this.responseText === '사용가능한 아이디 입니다'){
			checkId.innerHTML = '<span class="badge badge-success">' + this.responseText + '</span>';
			userAbleId = true;
		}else{
			checkId.innerHTML = '<span class="badge badge-danger">' + this.responseText + '</span>';
		}
     }
   };
   xhttp.open("GET", "./check_dupId.do" + params, true);
   xhttp.send();
}

</script>

<script>

   function checkValue(){
	   
	   var form = document.userInfo;
	   
	   if(!userAbleId){
		 alert('아이디를 다시 입력해주세요.');
         frm.id.focus();
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
      
      var sel = document.getElementById("emailSelect");
      var val = "@" + sel.options[sel.selectedIndex].value;
      
      var params = "?id=" + frm.id.value + "&pw=" + frm.pw.value + "&email=" + frm.email.value + val;
      
       var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
	   		alert(this.responseText);
	   		if(this.responseText === '회원가입 완료'){
				location.href="./login.do";
	   		}
        }
      };
      xhttp.open("POST", "./sign_up.do" + params, true);
      xhttp.send(); 
   }

	function inputIdCheck() {
		document.userInfo.id_check.value ="iduncheck";
	}
	
	function checkPassword(){
		const checkPwTxt = document.querySelector("#checkPwTxt");
		const pw = frm.pw.value.trim();
		const re_pw = frm.re_pw.value.trim();
		checkPwTxt.style.color = "black";
		if(pw === ''){
			checkPwTxt.innerHTML = '<span class="badge badge-secondary">비밀번호를 입력해주세요.</span>';
			return;
		}
		if(re_pw === ''){
			checkPwTxt.innerHTML = '<span class="badge badge-secondary">비밀번호 체크란을 입력해주세요.</span>';
			return;
		}
		if(pw === re_pw){
			checkPwTxt.innerHTML = '<span class="badge badge-success">비밀번호가 서로 일치합니다.</span>';
			checkPwTxt.style.color = "blue";
		}else{
			checkPwTxt.innerHTML = '<span class="badge badge-danger">비밀번호가 서로 일치하지 않습니다.</span>';
			checkPwTxt.style.color = "red";
		}
	}
   </script>

<title>회원가입</title>
</head>
<body>
	<form name="frm" method="post" action="./sign_up.do">
        <h4 class="mb-3">회원가입</h4>
        	(회원가입을 완료하시면 자본금 1만원을 드립니다.)
        	<br><br>
        	
        	
            <div class="col-12">
              <label for="id" class="form-label">아이디</label>
              <div class="input-group">
                <input type="text" class="form-control" onkeyup="inputCheckSpecial()" onclick="inputIdCheck" name="id">
              </div>
              <span id="checkId"><span class="badge badge-secondary">아이디를 입력해주세요.</span></span>
            </div>
           
           
            <div class="col-12">
            <br>
              <label for="pw1" class="form-label">비밀번호</label>
              <div class="input-group">
                <input type="password" class="form-control" id="pw" placeholder="비밀번호 입력" onkeyup="checkPassword()">
              </div>
            </div>
            

            <div class="col-12">
            <br>
              <label for="re_pw" class="form-label">비밀번호 확인</label>
              <div class="input-group">
                <input type="password" class="form-control" id="re_pw" placeholder="비밀번호 확인" onkeyup="checkPassword()">
              </div>
            </div>
            <span id="checkPwTxt"><span class="badge badge-secondary">비밀번호를 입력해주세요.</span></span>
            
            <div class="col-12">
            <br>
              <label for="pw2" class="form-label">이메일</label>
              <div class="input-group">
                <input type="text" class="form-control" id="email" placeholder="이메일을 입력해주세요">
                <span style="margin-left: 5px; margin-right: 5px;">@</span>
				<select class="form-control" id="emailSelect">
			    	<option value="naver.com">naver.com</option>
				    <option value="google.com">google.com</option>
				  </select>
              </div>
            </div>
            
           
            <div class="col-12 mt-5" >
                <button type="button"  class="btn btn-primary btn-block" onClick="checkValue()">확인</button>
                <button type="button"  class="btn btn-secondary btn-block" onClick="location.href='./login.do'">취소</button>
            </div>
            
            
	</form>
</body>
<%@ include file="/include/footer.jsp" %>
</html>