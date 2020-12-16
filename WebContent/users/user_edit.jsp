<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>개인정보 수정</title>
</head>
<body>
        <h4 class="mb-3">개인정보 수정</h4>
        <form class="needs-validation" novalidate>
          <div class="row g-3">
            <div class="col-12">
              <label for="id" class="form-label">아이디</label>
              <div class="input-group">
                <input type="text" class="form-control" id="id" value="id 가져와서 넣으시오" readonly>
              </div>
            </div>

            <div class="col-12">
              <label for="pw1" class="form-label">비밀번호 수정</label>
              <div class="input-group">
                <input type="password" class="form-control" id="pw1" placeholder="비밀번호 수정">
              </div>
            </div>

            <div class="col-12">
              <label for="pw2" class="form-label">비밀번호 확인</label>
              <div class="input-group">
                <input type="password" class="form-control" id="pw2" placeholder="비밀번호 수정 확인">
              </div>
            </div>


            <div class="col-sm-6">
              <label for="email1" class="form-label">이메일</label>
              <div class="input-group">
                <input type="text" class="form-control" id="email1" placeholder="이메일 앞 부분">
              </div>
            </div>
            <div class="col-sm-6">
            <label for="email2" class="form-label">도메인</label>
              <div class="input-group">
                <span class="input-group-text">@</span>
                <input type="text" class="form-control" id="email2" placeholder="이메일 뒷 부분">
              </div>
            </div>
            <div class="col-12 mt-5" >
                <button class="btn btn-outline-primary" type="submit">정보 수정</button>
                <button class="btn btn-outline-secondary" type="button">돌아가기</button>
            </div>
        </form>
</body>
<%@ include file="/include/footer.jsp" %>
</html>