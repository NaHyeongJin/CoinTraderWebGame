<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>상세보기</title>
</head>
<script>
	function send(){
		if(qnam.subject==""){
			alert("제목을 입력하여 주십시오");
			qnam.subject.focus();
			return;
		}
		if(qnam.contents==""){
			alert("내용을 입력하여 주십시오");
			qnam.contents.focus();
			return;
		}
		/* action="qna?cmd=qna_modify_pro&id=${vo.id}"; */
		qnam.submit();
	}
</script>
<body>
	<div class="row">
		<div class="col-lg-12">
			<div class="card">
				<div class="card-body">
					<div class="table-responsive project-list">
						<form name="qnam" action="qna?cmd=qna_modify_pro" method="post">
							<table class="table project-table table-centered table-nowrap">
								<thead>
									<div class="col-12">
										<label for="subject" class="form-label">제목</label>
										<div class="input-group">
											<input type="text" class="form-control" name="subject" id="subject" value="${vo.subject }">
										</div>
									</div>
									<div class="col-12">
										<label for="contents" class="form-label">내용</label>
										<div class="input-group">
											<textarea class="form-control" rows="8" name="contents" id="contents">${vo.contents }</textarea>
										</div>
									</div>
									<div class="col-12">
										<input type="hidden" name="regdate" id="regdate" value="${vo.regdate }">
									</div>
								</thead>
							</table>
						</form>
					</div>
					<!-- end project-list -->

					<div class="col-12 mt-5">
						<button class="btn btn-outline-primary" type="submit" onClick="javascript:send()">수정하기</button>
						<button class="btn btn-outline-secondary" type="button" onClick="history.back()">돌아가기</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="/include/footer.jsp"%>
</html>