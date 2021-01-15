<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>1:1문의등록</title>
</head>
<body>
	<form name="qna" action="qna?cmd=qna_write_pro" method="post">
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<div class="table-responsive project-list">
								<table class="table project-table table-centered table-nowrap">
									<thead>
										<div class="col-12">
											<label for="subject" class="form-label">제목</label>
											<div class="input-group">
												<input type="text" class="form-control" id="subject" name="subject"
													placeholder="제목을 입력해주세요" required>
											</div>
										</div>
										<div class="col-12">
											<label for="contents" class="form-label">내용</label>
											<div class="input-group">
												<textarea class="form-control" rows="8" id="contents" name="contents"
													placeholder="내용을 입력해주세요" required></textarea>
											</div>
										</div>
									</thead>
								</table>
						</div>
						<div class="col-12 mt-5">
							<button class="btn btn-outline-primary" type="submit">등록하기</button>
							<button class="btn btn-outline-secondary" type="button" onClick="history.back()">돌아가기</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<%@ include file="/include/footer.jsp"%>
</html>