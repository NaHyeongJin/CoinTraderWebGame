<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.js"></script>
<script type="text/javascript">
	var timerId = null;
	var timerRanking = null;
	function RankingStart() {
		if (timerRanking == null) {
			requestGetRanking();
			timerRanking = setInterval(requestGetRanking, 5000);
		}
	}
	function Start() {

		if (timerId == null) {
			requestGetUserMoney();
			timerId = setInterval(requestGetUserMoney, 1000);
		}
	}
	function requestGetUserMoney() {
		$.ajax({
			url : "http://localhost:8089/CoinTraderWebGame/UserGetMoney",
			method : "GET",
			dataType : "JSON",
			success : function(money) {
				$('#prmoney').val(money);
				var stringMoney = String(money);
				let newMoney = "";
				let cnt = 0;
				for (let i = stringMoney.length; i >= 0; i--) {
					newMoney = stringMoney.charAt(i) + newMoney;
					if(cnt % 3 == 0 && cnt != 0 && cnt != stringMoney.length) {
						newMoney = "," + newMoney;
					}
					cnt++;
					
				}
				document.getElementById("money").innerHTML = newMoney;
			}
		})
	}
	function requestGetRanking() {
		$.ajax({
			url : "http://localhost:8089/CoinTraderWebGame/RankingListGet",
			method : "GET",
			dataType : "JSON",
			success : function(data) {
				var row = "";
				var len = (data.length > 10) ? 10 : data.length;
				for (var i = 0; i < len; i++) {
					var id = data[i].id;
					var rank = data[i].rank;
					var money = data[i].money;
					if (i > 0) {
						if (data[i].money == data[i - 1].money) {
							rank = '';
						}
					}
					row += '<tr><th scope="col">' + rank
							+ '</th><th scope="col">' + id
							+ '</th><th scope="col">' + money + '</th></tr>';
				}
				document.getElementById("ranking").innerHTML = row;
			}
		})
	}
	$('#hrefgocoin').click(function() {
		$('#gocoin').val(1);
	});
</script>
<link rel="stylesheet" href="resource/css/bootstrap.css">

</head>
<c:if test="${empty id}">
	<body onload="RankingStart();">
</c:if>
<form method="post" action="user?cmd=login">
	<c:if test="${!empty id}">
		<body onload="Start();RankingStart();">
	</c:if>
	<header class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm sticky-top">
		<p class="h5 my-0 mr-auto fw-normal">
			<a href="index"><img src="resource/img/logo1.png"></a>
		</p>
		<c:if test="${!empty id}">
			<p class="h7 my-0 mr-3 fw-normal">${id}님환영합니다.</p>
			<p class="h7 my-0 fw-normal">현재 남은 자금은&nbsp;</p>
			<p class="h7 my-0 fw-normal" id="money"></p>
			<p class="h7 my-0 mr-auto fw-normal">원입니다.</p>
		</c:if>
		<nav class="my-2 my-md-0 me-md-3">
			<c:if test="${!empty id}">
				<a class="p-2 text-dark" href="coin?cmd=coin_list">Coin</a>
			</c:if>
			<c:if test="${empty id}">
				<a class="p-2 text-dark" href="" data-toggle="modal" data-target="#loginModalForm" id=hrefgocoin>Coin</a>
				<input name='gocoin' id='gocoin' value="0" type="hidden">
			</c:if>

			<a class="p-2 text-dark" href="" data-toggle="modal" data-target="#rankingModalForm">Ranking</a>

			<c:if test="${empty id}">
				<a class="btn btn-outline-primary" href="" data-toggle="modal" data-target="#loginModalForm">Sign in</a>
				<a class="btn btn-outline-primary" href="user?cmd=sign_up">Sign up</a>
			</c:if>
			<c:if test="${!(empty id)}">
				<a class="btn btn-outline-primary" href="user?cmd=logout">Sign out</a>
				<a class="btn btn-outline-primary" href="user?cmd=user_edit">Your profile</a>
				<a class="btn btn-outline-primary" href="qna?cmd=qna_list">Help</a>
			</c:if>
		</nav>

	</header>
	<!-- Modal -->
	<div class="modal fade" id="loginModalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<!--Content-->
			<div class="modal-content form-elegant">
				<!--Header-->
				<div class="modal-header text-center">
					<h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3" id="myModalLabel">
						<strong>Sign in</strong>
					</h3>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<!--Body-->

				<div class="modal-body mx-4">
					<!--Body-->
					<div class="md-form mb-5">
						<input type="text" id="Form-id" name="id" class="form-control validate" required> <label data-error="wrong" data-success="right" for="Form-id">Your id</label>
					</div>

					<div class="md-form pb-3">
						<input type="password" id="Form-pass" name="pw" class="form-control validate" required> <label data-error="wrong" data-success="right" for="Form-pass">Your password</label>
						<p class="font-small blue-text d-flex justify-content-end">
							Forgot <a href="user?cmd=id_search" class="blue-text ml-1"> Id?</a>
							<a href="user?cmd=pw_search" class="blue-text ml-1"> Password?</a>
						</p>
					</div>

					<div class="text-center mb-3">
						<button type="submit" class="btn btn-primary btn-block btn-rounded z-depth-1a">Sign in</button>
					</div>
				</div>
			</div>
			<!--/.Content-->
		</div>
	</div>
	<!-- Modal -->
	<!-- RankingModal -->
	<div class="modal fade" id="rankingModalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<!--Content-->
			<div class="modal-content form-elegant">
				<!--Header-->
				<div class="modal-header text-center">
					<h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3" id="myModalLabel">
						<strong>Ranking</strong>
					</h3>
					<h7 class="modal-title w-100 dark-grey-text font-weight-bold my-3">*랭킹은 상위 10명만 출력됩니다.</h7>
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
												<th scope="col">순위</th>
												<th scope="col">아이디</th>
												<th scope="col">보유 자산</th>
											</tr>
										</thead>
										<tbody id="ranking">
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
	<main class="container">
		<div style="min-height: 400px;" class="px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
</form>
</body>
</html>