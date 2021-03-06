<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://code.highcharts.com/stock/highstock.js"></script>
<script src="https://code.highcharts.com/stock/modules/data.js"></script>
<script src="https://code.highcharts.com/stock/modules/exporting.js"></script>
<script src="https://code.highcharts.com/stock/modules/export-data.js"></script>
<title>개인정보 수정</title>

<script>
	//정규화 구분(제이쿼리에서 value에서는 val)
	var pw = /^[A-Za-z0-9~!@#$%^&*()_+|<>?:{}]{4,20}$/;
	var pwCheck = false;
	$(function() {
		$("#pw1").blur(function() {
			if (pw.test($("#pw1").val())) {
				$("#pw1_check").text("*사용가능한 비밀번호입니다");
				$("#pw1_check").css("color", "green");
				pwCheck = true;
			} else {
				$("#pw1_check").text('*숫자,영문,특수문자로 4~20자리 입력');
				$("#pw1_check").css('color', 'red');
				pwCheck = false;
			}
			if ($('#pw1').val() != $('#pw2').val()) {
				$('#pw2_check').text('비밀번호를 확인해주세요');
				$('#pw2_check').css('color', 'red');
			} else {
				$('#pw2_check').text('비밀번호가 확인되었습니다');
				$('#pw2_check').css('color', 'green');
			}
		});
		$('#pw2').blur(function() {
			if ($('#pw1').val() != $(this).val() || $(this).val() == "") {
				$('#pw2_check').text('비밀번호를 확인해주세요');
				$('#pw2_check').css('color', 'red');
			} else {
				$('#pw2_check').text('비밀번호가 확인되었습니다');
				$('#pw2_check').css('color', 'green');
			}
		});
		$('#modalclose').click(function() {
			$('#MoneyModal').modal('hide');
		});
		$('#modalclose2').click(function() {
			$('#MoneyModal').modal('hide');
		});

		$('#moneybutton').on('click', function() {
			$.ajax({
				url : "http://localhost:8089/CoinTraderWebGame/UsersCoinMoney",
				method : "GET",
				dataType : "JSON",
				success : function(data) {
					$('#MoneyModal').modal('show');
					Highcharts.stockChart('container', {
						rangeSelector : {
							buttons : [ {
								count : 5,
								type : 'day',
								text : '5일'
							}, {
								count : 10,
								type : 'day',
								text : '10일'
							}, {
								count : 1,
								type : 'month',
								text : '30일'
							}, {
								type : 'all',
								text : 'All'
							} ],
							selected : 0,
							inputEnabled : false
						},

						title : {
							text : '내 자산 그래프'
						},

						scrollbar : {
							barBackgroundColor : 'gray',
							barBorderRadius : 7,
							barBorderWidth : 0,
							buttonBackgroundColor : 'gray',
							buttonBorderWidth : 0,
							buttonBorderRadius : 7,
							trackBackgroundColor : 'none',
							trackBorderWidth : 1,
							trackBorderRadius : 8,
							trackBorderColor : '#CCC'
						},

						series : [ {
							name : '내 자산',
							data: (function () {
					            let list = [];
					            for (let i = 0; i < data.length; i++) {
					            	list.push([Date.parse(data[i].regdate), data[i].money]);
					            }
					            return list;
					          })(),
							tooltip : {
								valueDecimals : 0
							}
						} ]
					});
				}
			})
		});
	})
	function modify() {
		if (coin.pw1.value == "") {
			alert("비밀번호를 입력해 주세요")
			coin.pw1.focus();
			return false;
		}
		if (coin.pw2.value == "") {
			alert("비밀번호를 확인해 주세요")
			coin.pw2.focus();
			return false;
		}
		if (coin.pw1.value != coin.pw2.value) {
			alert("비밀번호가 다릅니다")
			coin.pw2.focus();
			return false;
		}
		if (!pwCheck) {
			alert("비밀번호를 확인해 주세요")
			coin.pw1.focus();
			return false;
		}
		coin.submit();
	}
	function Charge(money) {
		charge.charge_money.value = money;
	}
	function MoneyCheck() {
		(charge.charge_money.value == 0) ? alert("금액을 입력해주세요") : charge.submit();
	}
</script>
</head>
<body>
	<a href="index"><img src="resource/img/indexcoin.jpg" width="180px" height="45px"></a><br>
	<img class="mt-3 mb-3" src="resource/img/정보수정.png" width="140px" height="50px">

	<div class="row">
		<div class="col-lg-12">
			<div class="card">
				<div class="card-body">


					<form method="post" class="needs-validation" novalidate name="coin" action="user?cmd=user_edit_pro">
						<div class="row g-3">
							<div class="col-12">
								<label for="user_id" class="form-label">아이디</label>
								<div class="input-group">
									<input type="text" class="form-control" id="user_id" name="user_id" value="${vo.id}" readonly>
								</div>
							</div>

							<div class="col-12">
								<label for="user_id" class="form-label"><button type="button" class="btn btn-link" id=moneybutton>보유자산</button></label>
								<div class="input-group">
									<input type="text" class="form-control" id="money" name="money" value="${vo.money} " readonly>
									<button type="button" class="btn btn-outline-primary ml-3" data-toggle="modal" data-target="#chargeModal">충전</button>
								</div>
							</div>

							<div class="col-12">
								<label for="pw1" class="form-label">비밀번호 수정</label>
								<div class="input-group">
									<input type="password" id="pw1" name="pw1" class="form-control" placeholder="비밀번호 수정" maxlength="20">
								</div>

							</div>
							<div class="coin" id="pw1_check"></div>

							<div class="col-12">
								<label for="pw2" class="form-label">비밀번호 확인</label>
								<div class="input-group">
									<input type="password" id="pw2" name="pw2" class="form-control" id="pw2" placeholder="비밀번호 수정 확인" maxlength="20">
								</div>
								<div class="coin" id="pw2_check"></div>

							</div>
							<div class="col-sm-6">
								<label for="email1" class="form-label">이메일</label>
								<div class="input-group">
									<input type="text" name="email1" class="form-control" id="email1" value="${vo.email1}" readonly>
								</div>
							</div>

							<div class="col-sm-6">
								<label for="email2" class="form-label">도메인</label>
								<div class="input-group">
									<span class="input-group-text">@</span> <input type="text" name="email2" class="form-control" id="email2" value="${vo.email2}" readonly>
								</div>
							</div>

						</div>
					</form>
					<div class="col-12 mt-5">
						<button class="btn btn-outline-primary" onclick="return modify()">완료</button>
						<a href="index"><button class="btn btn-outline-secondary" type="button">뒤로</button></a>
						<button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#WithdrawalForm">회원탈퇴</button>
					</div>

					<div class="modal" tabindex="-1" id="MoneyModal">
						<div class="modal-dialog modal-xl">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title">${id}님의자산그래프</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" id='modalclose'></button>
								</div>
								<div class="modal-body">
									<div id="container" style="height: 400px; min-width: 310px"></div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id='modalclose2'>Close</button>
								</div>
							</div>
						</div>
					</div>

					<!-- WithdrawalForm -->
					<div class="modal fade" id="WithdrawalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<!--Content-->
							<div class="modal-content form-elegant">
								<!--Header-->
								<div class="modal-header text-center">
									<h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3" id="myModalLabel">
										<strong>Withdrawal</strong>
									</h3>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<!--Body-->
								<form method="post" action="user?cmd=user_withdrawal">
									<div class="modal-body mx-4">
										<!--Body-->
										<div class="md-form pb-3">
											<label>회원탈퇴를 위해 비밀번호를 입력해주세요</label>
										</div>
										<div class="md-form pb-3">
											<input type="password" id="withdrawal_pw" name="withdrawal_pw" class="form-control validate" placeholder="비밀번호 입력" required><br>
											<h6 style="color: red;">※회원 탈퇴 시 복구는 불가합니다</h6>
										</div>

										<div class="text-center mb-3">
											<button type="submit" class="btn btn-primary">탈퇴하기</button>
										</div>
									</div>
								</form>
							</div>
							<!--/.Content-->
						</div>
					</div>
					<!-- ChargeModal -->
					<div class="modal fade" id="chargeModal" tabindex="-1" role="dialog" aria-labelledby="chargeModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3" id="myModalLabel">
										<strong>Charge</strong>
									</h3>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<form name="charge" method="post" action="user?cmd=user_chargemoney">
									<div class="md-form pb-3">
										<label>충전할 금액을 선택해주세요</label>
									</div>
									<div class="modal-body">
										<button type="button" class="btn btn-primary" onClick="Charge(1000)">1000</button>
										<button type="button" class="btn btn-primary" onClick="Charge(2000)">2000</button>
										<button type="button" class="btn btn-primary" onClick="Charge(5000)">5000</button>
										<br> <br>
										<button type="button" class="btn btn-primary" onClick="Charge(10000)">10000</button>
										<button type="button" class="btn btn-primary" onClick="Charge(50000)">50000</button>
										<button type="button" class="btn btn-primary" onClick="reset()">reset</button>
									</div>
									<div class="modal-body mx-4">
										<div class="md-form pb-3">
											<input type="text" id="charge_money" name="charge_money" class="form-control" value="0" readOnly><br>
											<button type="button" class="btn btn-primary" onClick="MoneyCheck()">충전하기</button>
											<button type="button" class="btn btn-secondary" data-dismiss="modal">뒤로가기</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="/include/footer.jsp"%>
</html>
