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
		<%
			if(request.getParameter("error") != null){
				%>
				<script>
					alert('아이디 혹은 비밀번호가 일치하지 않습니다.');
				</script>
				<%
			}
		%>
        <h4 class="mb-3">로그인</h4>
        <form class="needs-validation" method="POST" action="./loginCheck.do">
            <div class="col-12">
            <br>
              <label for="id" class="form-label">아이디</label>
              <div class="input-group">
                <input type="text" class="form-control" name="id" placeholder="아이디를 입력해주세요" required="required">
              </div>
            </div>


            <div class="col-12">
            <br>
              <label for="pw1" class="form-label">비밀번호</label>
              <div class="input-group">
                <input type="password" class="form-control" name="pw" placeholder="비밀번호를 입력해주세요" required="required">
              </div>
            </div>
            <div class="col-12 mt-5" >
                <button class="btn btn-outline-primary btn-block" type="submit">로그인</button>
                <button class="btn btn-outline-secondary btn-block" type="button" onclick="signup()">회원가입</button>
                <button class="btn btn-outline-warning btn-block" type="button" onclick="findId()">아이디 찾기</button>
                <button class="btn btn-outline-warning btn-block" type="button" onclick="findPw()">비밀번호 찾기</button>
            </div>
        </form>
</body>
<%@ include file="/include/footer.jsp" %>
<script>
	function findId(){
		location.href="./find_id.do";
	}

	function findPw(){
		location.href="./find_pw.do";
	}

	function signup(){
		location.href="./user_insert.do";
	}
</script>
</html>