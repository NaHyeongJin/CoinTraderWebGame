<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="../resource/js/bootstrap.js"></script>
<link rel="stylesheet" href="../resource/css/bootstrap.css">

<style>

input::-webkit-input-placeholder {text-align: center;}
input::-moz-placeholder {text-align: center;}
input:-ms-input-placeholder {text-align: center;}
input:-moz-placeholder {text-align: center;}
input::placeholder {text-align: center;}


</style>

<title>아이디 중복확인</title>

<script type="text/javascript">
    
        var httpRequest = null;
        
        // httpRequest 객체 생성를 생성
        function getXMLHttpRequest(){
            var httpRequest = null;
        
            if(window.ActiveXObject){
                try{
                    httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
                } catch(e) {
                    try{
                        httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e2) { httpRequest = null; }
                }
            }
            else if(window.XMLHttpRequest){
                httpRequest = new window.XMLHttpRequest();
            }
            return httpRequest;    
        }
        
        
        // 회원가입창의 아이디 입력란의 값을 가져온다.
        function pValue(){
            document.getElementById("userId").value = opener.document.userInfo.id.value;
        }
        
        // 아이디 중복체크
        
        function idCheck(){
 
            var id = document.getElementById("userId").value;
 
            if (!id) {
                alert("아이디를 입력하지 않았습니다.");
                return false;
            } 
            else if((id < "0" || id > "9") && (id < "A" || id > "Z") && (id < "a" || id > "z")){ 
                alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
                return false;
            }
            else
            {
                var param="id="+id
                httpRequest = getXMLHttpRequest();
                httpRequest.onreadystatechange = callback;
                httpRequest.open("POST", "MemberIdCheckAction.do", true);    
                httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 
                httpRequest.send(param);
            }
        }
        
        function callback(){
            if(httpRequest.readyState == 4){
                // 결과값을 가져온다.
                var resultText = httpRequest.responseText;
                if(resultText == 0){
                    alert("사용할수없는 아이디입니다.");
                    document.getElementById("cancelBtn").style.visibility='visible';
                    document.getElementById("useBtn").style.visibility='hidden';
                    document.getElementById("msg").innerHTML ="";
                } 
                else if(resultText == 1){ 
                    document.getElementById("cancelBtn").style.visibility='hidden';
                    document.getElementById("useBtn").style.visibility='visible';
                    document.getElementById("msg").innerHTML = "사용 가능한 아이디입니다.";
                }
            }
        }
        
        // 사용하기 클릭 시 부모창으로 값 전달 
        function sendCheckValue(){
            // 중복체크 결과인 idCheck 값을 전달한다.
            opener.document.userInfo.idDuplication.value ="idCheck";
            // 회원가입 화면의 ID입력란에 값을 전달
            opener.document.userInfo.id.value = document.getElementById("userId").value;
            
            if (opener != null) {
                opener.chkForm = null;
                self.close();
            }    
        }    
   </script>
   
</head>
<body>

<main class="container">
		<div style="min-height: 400px;"
		class="px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">

<header class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm sticky-top">
		
	</header>
		
        <h4 class="mb-3">아이디 중복 확인</h4>
        <form class="needs-validation" novalidate>
        
            <div class="col-12">
              <label for="id" class="form-label">아이디 중복확인을 완료해주세요.</label>
              <div class="input-group">
                <input type="text" class="form-control" id="userId">
                <button class="btn btn-outline-primary" type="button" onclick="idCheck()">중복확인</button>
              </div>
            </div>
           
            <div class="col-12 mt-5" >
                
                <input class="btn btn-outline-primary" id="cancelBtn" type="button" value="취소" onclick="window.close()">
       			<input class="btn btn-outline-secondary" id="useBtn" type="button" value="사용하기" onclick="sendCheckValue()">
        
            </div>
        </form>
</body>
</html>