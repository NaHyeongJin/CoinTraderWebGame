<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>1:1문의등록</title>
</head>
<body>
<div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-body">
                    <div class="table-responsive project-list">
                    <form name="qna" action="qna?cmd=write_pro" method="post">
                        <table class="table project-table table-centered table-nowrap">
                            <thead>
                                <div class="col-12">
              					 <label for="subject" class="form-label">제목</label>
              					  <div class="input-group">
                				   <input type="password" class="form-control" id="subject" placeholder="제목을 입력해주세요">
             					  </div>
            					 </div>
                                <div class="col-12">
              					 <label for="contents" class="form-label">내용</label>
              					  <div class="input-group">
                				   <input type="password" class="form-control" id="contents" placeholder="내용을 입력해주세요">
             					  </div>
            					 </div>
                            </thead>
                        </table>
                    </form>
                    </div>
                    <!-- end project-list -->

                    <div class="col-12 mt-5" >
                		<button class="btn btn-outline-primary" type="submit">정보 수정</button>
                		<button class="btn btn-outline-secondary" type="button">돌아가기</button>
            		</div>
                </div>
            </div>
        </div>
    </div>
</body>
<%@ include file="/include/footer.jsp" %>
</html>