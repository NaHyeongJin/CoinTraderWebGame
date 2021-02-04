<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<br>
	<br>
	<ul class="pagination justify-content-end mb-0">
		<c:choose>
			<c:when test="${currentPage==1 }">
				<li class="page-item disabled"><a class="page-link"
					href="receipt?cmd=receipt_list&page=${currentPage-1}" tabindex="-1"
					aria-disabled="true">Previous</a></li>
			</c:when>
			<c:when test="${currentPage!=1 }">
				<li class="page-item"><a class="page-link"
					href="receipt?cmd=receipt_list&page=${currentPage-1}">Previous</a></li>
			</c:when>
		</c:choose>
		<c:forEach var="a" begin="1" end="${totpage }" step="1">
			<li class="page-item"><a class="page-link" href="receipt?cmd=receipt_list&page=${a}">${a}</a></li>
		</c:forEach>
		<c:if test="${currentPage == totpage }">
			<li class="page-item disabled"><a class="page-link"
				href="receipt?cmd=receipt_list&page=${currentPage+1}">Next</a></li>
		</c:if>
		<c:if test="${currentPage != totpage }">
			<li class="page-item"><a class="page-link"
				href="receipt?cmd=receipt_list&page=${currentPage+1}">Next</a></li>
		</c:if>
	</ul>

	<div align="left">
	<small style="color: gray">*내역은 페이지당 20개씩 보여집니다</small>
	</div>
	<table class="table table-sm">
		<thead>
			<tr>					
				<th scope="col" width="15%">CoinKind</th>
				<th scope="col" width="15%">CoinSell</th>
				<th scope="col" width="15%">CoinBuy</th>
				<th scope="col" width="15%">RegDate</th>
				<th scope="col" width="15%">Buy/Sell</th>
				<th scope="col" width="15%">총재산</th>							
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${vo}">
				<tr>
					<th>${vo.name.substring(0,1)}코인</th>
					<c:choose>
					<c:when test="${vo.count < 0}">
						<th>${vo.count}개</th>
						<th></th>
					</c:when>
					<c:otherwise>
						<th></th>
						<th>+${vo.count}개</th>
					</c:otherwise>
					</c:choose>
					<th>${vo.regdate.substring(2,4)}/${vo.regdate.substring(5,7)}/${vo.regdate.substring(8,10)}
					${vo.regdate.substring(11,13)}:${vo.regdate.substring(14,19)}</th>
					<th><fmt:formatNumber value="${vo.price}" pattern="#,###,###,###"/>원</th>
					<th><fmt:formatNumber value="${vo.money}" pattern="#,###,###,###"/>원</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>

		<div class="md-form pb-3" align="right">
			<a class="btn btn-outline-primary" href="#" onClick="javascript:window.scrollTo(0,0)">맨 위로</a>
		</div>
		<a href="index">
			<button type="button" style="background-color: skyblue;, border-color: skyblue;"  class="btn btn-secondary" data-dismiss="modal">Main</button>
		</a>
</body>
<%@ include file="/include/footer.jsp"%>
</html>