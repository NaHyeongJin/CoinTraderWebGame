<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ include file = "/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
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
										<input type="text" class="form-control" name="subject" id="subject" value="${vo.subject }" readOnly>
									</div>
								</div>
								<div class="col-12">
									<label for="contents" class="form-label">내용</label>
									<div class="input-group">
										<textarea class="form-control" rows="8" name="contents" id="contents" readOnly>${vo.contents }</textarea>
									</div>
								</div>
								<c:if test="${!empty vo.answer }">
									<div class="col-12">
										<label for="answer" class="form-label">운영자 답변</label>
										<div class="input-group">
											<textarea class="form-control" rows="8" name="answer" id="answer" readOnly>${vo.answer }</textarea>
										</div>
									</div>
								</c:if>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-12 mt-5">
		<c:if test="${empty vo.answer }">
		<button class="btn btn-outline-primary" type="button" onClick="location.href='qna?cmd=qna_modify&id=${id }&idx=${vo.idx }'">수정하기</button>
		<a class="btn btn-outline-primary" href="" data-toggle="modal" data-target="#deleteModalForm">삭제하기</a>
		</c:if>
		<button class="btn btn-outline-secondary" type="button" onClick="location.href='qna?cmd=qna_list&page=${currentPage}'">돌아가기</button>
	</div>
	<!-- DeleteModalForm -->
		<div class="modal fade" id="deleteModalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
			<div class="modal-dialog" role="document">
				<!--Content-->
				<div class="modal-content form-elegant">
					<!--Header-->
					<div class="modal-header text-center">
					<h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3" id="myModalLabel"><strong>Warning</strong></h3>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<!--Body-->
					<div class="row">
				        <div class="col-lg-12">
				            <div class="card">
				                <div class="card-body">
				                    <div class="table-responsive project-list">
				                        <table class="table project-table table-centered table-nowrap">
				                            <thead>
				                                <tr>
				                                    <th scope="col">삭제하시겠습니까?</th>
				                                </tr>
				                            </thead>
				                            <tbody>
				                                <tr>
				                                	<td>
					                                    <button type="button" class="btn btn-outline-primary" onClick="location.href='qna?cmd=qna_delete_pro&id=${id}&regdate=${vo.regdate }'">삭제하기</button>
														<button type="button" class="btn btn-outline-primary" data-dismiss="modal">취소하기</button>
													</td>
				                                </tr>
				                            </tbody>
				                        </table>
				                    </div>
				                </div>
				            </div>
				        </div>
				    </div>
				</div>
			<!--/.Content-->
			</div>
		</div>
		<!-- Modal -->
</body>
 <%@ include file = "/include/footer.jsp" %>
</html>