<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
 <%@ include file = "/include/header.jsp" %>
<table>
	<tr>
		<td>ID : </td>
		<td>${vo.id }</td>
	</tr>
</table>
<table>
	<tr>
		<td>제목 : </td>
		<td>${vo.subject }</td>
	</tr>
</table>
<table>
	<tr>
		<td>내용 : </td>
		<td>${vo.contents }</td>
	</tr>
</table>
<table>
	<tr>
		<td>등록날짜 : </td>
		<td>${vo.regdate.substring(0,16) }</td>
	</tr>
</table>
<table>
	<tr>
		<td>답변상태</td>
		<td></td>
	</tr>
</table>
	<div class="col-12 mt-5">
		<!-- <button class="btn btn-outline-primary" type="button" onClick="window.open('qna?cmd=qna_delete','삭제','width=400, height=300')">삭제하기</button> -->
		<!-- 세션추가되면 댓글추가 버튼 바꿀예정 -->
		<%-- <c:if test="${vo.id.constain('admin') }"></c:if> --%>
		<button class="btn btn-outline-primary" type="button" onClick="location.href='qna?cmd=qna_answer&id=${vo.id }'">답변등록</button>
		<button class="btn btn-outline-primary" type="button" onClick="location.href='qna?cmd=qna_modify&id=${vo.id }'">수정하기</button>
		<a class="btn btn-outline-primary" href="" data-toggle="modal" data-target="#deleteModalForm">삭제하기</a>
		<button class="btn btn-outline-secondary" type="button" onClick="location.href='qna?cmd=qna_list&page=${page}'">돌아가기</button>
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
				                                    <button type="button" class="btn btn-outline-primary" onClick="location.href='qna?cmd=qna_delete_pro'">삭제하기</button>
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