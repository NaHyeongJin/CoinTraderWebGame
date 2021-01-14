<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>1:1문의</title>
</head>
<body>
    <div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-body">
                    <div class="table-responsive project-list">
                        <table class="table project-table table-centered table-nowrap">
                            <thead>
                                <tr>
                                    <th scope="col" width="10%">번호</th>
                                    <th scope="col" width="60%">제목</th>
                                    <th scope="col" width="15%">문의 날짜</th>
                                    <th scope="col" width="15%">답변현황</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:if test="${empty list }">
                                <tr>
                                    <td colspan=4>등록된 글이 없습니다.</td>
                                </tr>
                                </c:if>
                                <c:forEach var="vo" items="${list }">
	                                <tr>
	                                    <th scope="row">${vo.idx }</th>
	                                    <c:if test="${id.contains('admin')}">
	                                    	<td><a href="qna?cmd=qna_answer&idx=${vo.idx }&page=${currentPage}">
	                                    </c:if>
	                                    <c:if test="${!id.contains('admin')}">
	                                    	<td><a href="qna?cmd=qna_view&id=${id }&idx=${vo.idx }&page=${currentPage}">
	                                    </c:if>
	                                    <c:choose>
		        							<c:when test="${fn:length(vo.subject) gt 20}">
		        								<c:out value="${fn:substring(vo.subject, 0, 20)}..."></c:out>
		        							</c:when>
		       								<c:otherwise>
		       									<c:out value="${vo.subject}"></c:out>
		       								</c:otherwise>
										</c:choose>
										</a></td>
	                                    <td>${vo.regdate.substring(0,10) }</td>
	                                    <c:if test="${empty vo.answer }">
	                                    <td>답변대기상태</td>
	                                    </c:if>
	                                    <c:if test="${!empty vo.answer }">
	                                    <td>답변완료</td>
	                                    </c:if>
	                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- end project-list -->
                    <div class="pt-3">
                        <ul class="pagination justify-content-end mb-0">
                        	<c:choose>
                        	<c:when test="${currentPage==1 }">
                        	<li class="page-item disabled" >
                                <a class="page-link" href="qna?cmd=qna_list&page=${currentPage-1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                            </c:when>
                            <c:when test="${currentPage!=1 }">
                            <li class="page-item" >
                                <a class="page-link" href="qna?cmd=qna_list&page=${currentPage-1}">Previous</a>
                            </li>
                            </c:when>
                            </c:choose>
                            <c:forEach var="a" begin="1" end="${totpage }" step="1">
            					<li class="page-item"><a class="page-link" href="qna?cmd=qna_list&page=${a}">${a}</a></li>
         					</c:forEach>
                            <c:if test="${currentPage == totpage }">
	                            <li class="page-item disabled">
	                                <a class="page-link" href="qna?cmd=qna_list&page=${currentPage+1}">Next</a>
	                            </li>
                            </c:if>
                            <c:if test="${currentPage != totpage }">
	                            <li class="page-item">
	                                <a class="page-link" href="qna?cmd=qna_list&page=${currentPage+1}">Next</a>
	                            </li>
                            </c:if>
                            <c:if test="${!id.contains('admin') }">
                                <li class="page-item">
                                    <a class="page-link ml-3" href="qna?cmd=qna_write">글쓰기</a>
                                </li>
							</c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<%@ include file="/include/footer.jsp" %>
</html>