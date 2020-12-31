<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>1:1문의등록</title>
</head>
<script>
	function send(){
		if(qna.subject==null){
			alert("제목을 입력하여 주십시오");
			qna.subject.focus();
			return;
		}
		if(qna.contents==null){
			alert("내용을 입력하여 주십시오");
			qna.contents.focus();
			return;
		}
		qna.submit();
	}
	function del(){
		alert("등록한 내용을 삭제합니다");
		qna.reset();
	}
</script>
<body>
	<div class="row">
		<div class="col-lg-12">
			<div class="card">
				<div class="card-body">
					<div class="table-responsive project-list">
						<form name="qna" action="qna?cmd=qna_write_pro" method="post">
							<table class="table project-table table-centered table-nowrap">
								<thead>
									<div class="col-12">
										<label for="subject" class="form-label">ID</label>
										<div class="input-group">
											<input type="text" class="form-control" id="subject" name="id"
												placeholder="ID 입력">
										</div>
									</div>
									<div class="col-12">
										<label for="subject" class="form-label">제목</label>
										<div class="input-group">
											<input type="text" class="form-control" id="subject" name="subject"
												placeholder="제목을 입력해주세요">
										</div>
									</div>
									<div class="col-12">
										<label for="contents" class="form-label">내용</label>
										<div class="input-group">
											<textarea class="form-control" rows="8" id="contents" name="contents"
												placeholder="내용을 입력해주세요"></textarea>
										</div>
									</div>
								</thead>
							</table>
						</form>
					</div>
					<!-- end project-list -->

					<div class="col-12 mt-5">
						<button class="btn btn-outline-primary" type="submit" onClick="javascript:send()">등록하기</button>
						<button class="btn btn-outline-primary" type="submit" onClick="javascript:del()">다시쓰기</button>
						<button class="btn btn-outline-secondary" type="button" onClick="history.back()">돌아가기</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="/include/footer.jsp"%>
</html>