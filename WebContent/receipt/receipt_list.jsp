<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>구매 내역</title>
</head>
<body>
	<a href="index"><img src="resource/img/indexcoin.jpg" width="180px"
		height="45px"></a>
	<br>
	<br>
	<img src="resource/img/구매내역.png" width="140px" height="50px">
	<br>
	<br>
	<ul class="pagination justify-content-end mb-0">
		<c:choose>
			<c:when test="${currentPage==1 }">
				<li class="page-item disabled"><a class="page-link"
					href="qna?cmd=qna_list&page=${currentPage-1}" tabindex="-1"
					aria-disabled="true">Previous</a></li>
			</c:when>
			<c:when test="${currentPage!=1 }">
				<li class="page-item"><a class="page-link"
					href="qna?cmd=qna_list&page=${currentPage-1}">Previous</a></li>
			</c:when>
		</c:choose>
		<c:forEach var="a" begin="1" end="${totpage }" step="1">
			<li class="page-item"><a class="page-link"
				href="qna?cmd=qna_list&page=${a}">${a}</a></li>
		</c:forEach>
		<c:if test="${currentPage == totpage }">
			<li class="page-item disabled"><a class="page-link"
				href="qna?cmd=qna_list&page=${currentPage+1}">Next</a></li>
		</c:if>
		<c:if test="${currentPage != totpage }">
			<li class="page-item"><a class="page-link"
				href="qna?cmd=qna_list&page=${currentPage+1}">Next</a></li>
		</c:if>
	</ul>

	<div align="left">
	<small style="color: gray">*회색 상자는 판매</small>
	</div>
	<table class="table table-striped">
  <thead>
    <tr>					
		<th scope="col" width="25%">CoinKind</th>
		<th scope="col" width="25%">CoinCount</th>
		<th scope="col" width="25%">RegDate</th>
		<th scope="col" width="25%">Buy/Sell</th>							
    </tr>
  </thead>
		<tbody>
			<tr>
				<c:forEach var="vo" items="${vo}">
					<tr>
						<th>${vo.name}</th>
						<th>${vo.count}</th>
						<th>${vo.regdate}</th>
						<th>${vo.price}</th>
					</tr>
				</c:forEach>
			</tr>
		</tbody>
	</table>

	<div class="modal-body mx-4">
		<div class="md-form pb-3">
			<a href="/CoinTraderWebGame/index">
			<button type="button" style="background-color: skyblue;, border-color: skyblue;"  class="btn btn-secondary" data-dismiss="modal">Main</button>
			</a>
		</div>
	</div>
</body>
<%@ include file="/include/footer.jsp"%>
</html>
