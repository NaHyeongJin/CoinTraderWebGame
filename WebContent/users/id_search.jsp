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

        <h4 class="mb-3">아이디 찾기</h4>
        (가입시 입력 한 이메일을 입력해주세요.) 
        
        <form class="needs-validation" novalidate>
            <div class="col-12">
            <br>
              <label for="id" class="form-label">이메일</label>
              <div class="input-group">
                <input type="text" class="form-control" id="email" placeholder="회원 가입시 등록 한 이메일을 입력하여주세요.">
              </div>
            </div>
            <br>
            <span id="findTxt"></span>
			<div class="col-12" id="findIdArea">
			</div>
            <div class="col-12 mt-5" >
                <button class="btn btn-outline-primary btn-block" type="button" onclick="findId()">확인</button>
                <button class="btn btn-outline-secondary btn-block" type="button" onclick="location.href='./login.do'">취소</button>
            </div>
        </form>
</body>
<%@ include file="/include/footer.jsp" %>
<script>
	function findId(){
	   const email = document.getElementById('email').value.trim();
		var params = '?email=' + email;
		
	   var xhttp = new XMLHttpRequest();
	   xhttp.onreadystatechange = function() {
	     if (this.readyState == 4 && this.status == 200) {
	    	 document.getElementById('findIdArea').innerHTML = '';
			var html = "";
	    	const result = JSON.parse(this.responseText);
	    	if(result.length === 0){
				document.getElementById('findTxt').innerHTML = "해당 이메일로 가입한 아이디가 존재하지 않습니다.";
	    		return;
	    	}
	    	
			result.map(user=>{
				html += '<br><div class="card"><div class="card-body">';
				html += user['id'];
				html += '</div></div>';
			});
			document.getElementById('findTxt').innerHTML = "해당 이메일로 가입한 아이디 목록입니다.";
			document.getElementById('findIdArea').innerHTML = html;
	     }
	   };
	   
	   xhttp.open("POST", "./find_id_handle.do" + params, true);
	   xhttp.send();
	}
</script>
</html>