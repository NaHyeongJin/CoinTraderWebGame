<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

$(function(){
	$("#pw").blur(function(){
		if(pw.test($("#pw").val())){
			console.log('true');
			$("#pw1").text("*사용가능한 비밀번호입니다");
			$("#pw1").css("color","green");
		}else{
			console.log('false');
			$("#pw1").text('*숫자,영문,특수문자로 4~20자리 입력');
			$("#pw1").css('color', 'red');
		}
	});
	$('#pwr').blur(function(){
		if($('#pw1').val()!=$(this).val()||$(this).val()==""){
			console.log('true');
			$('#pwr').text('비밀번호를 확인해주세요');
			$('#pwr').css('color', 'red');
		}else{
			console.log('false');
			$('#pwr').text('비밀번호가 확인되었습니다');
			$('#pwr').css('color', 'green');
		}
	});
	$('#modalclose').click(function(){
		$('#MoneyModal').modal('hide');
	});
	$('#modalclose2').click(function(){
		$('#MoneyModal').modal('hide');
	});
	
	$('#moneybutton').on('click',function(){
			$.ajax({
			    url: "http://localhost:8089/CoinTraderWebGame/UsersCoinMoney",
			    method: "GET",
			    dataType: "JSON",
			    success: function(data) {
			    	$('#MoneyModal').modal('show');
			    	console.log(data);
			    	
			    	Highcharts.stockChart('container', {

					    rangeSelector: {
					    	 buttons: [{
							      count: 3,
							      type: 'day',
							      text: '3일'
							    }, {
							      count: 7,
							      type: 'day',
							      text: '7일'
							    }, 
							    {
								 count: 1,
								  type: 'month',
								  text: '30일'
								    },{
							      type: 'all',
							      text: 'All'
							    }],
					      selected: 0,
					      inputEnabled: false
					    },

					    title: {
					      text: '내 자산 그래프'
					    },

					    scrollbar: {
					      barBackgroundColor: 'gray',
					      barBorderRadius: 7,
					      barBorderWidth: 0,
					      buttonBackgroundColor: 'gray',
					      buttonBorderWidth: 0,
					      buttonBorderRadius: 7,
					      trackBackgroundColor: 'none',
					      trackBorderWidth: 1,
					      trackBorderRadius: 8,
					      trackBorderColor: '#CCC'
					    },

					    series: [{
					      name: '내 자산',
					      
					      data: data,
					      tooltip: {
					        valueDecimals: 0
					      }
					    }]
					  });
			   	}
			})
		
	});
})

function modify(){
	if (coin.pw1.value=="") {
		alert("비밀번호를 입력해 주세요")
		coin.pw1.focus();
		return false;	
	}
	if (coin.pw2.value=="") {
		alert("비밀번호를 확인해 주세요")
		coin.pw2.focus();
		return false;	
	}
	if(coin.pw1.value != coin.pw2.value ){
		alert("비밀번호가 다릅니다")
		coin.pw2.focus();
		return false;
	}
	coin.submit();
}
</script>
</head>
<body>
	<h4 class="mb-3">개인정보 수정</h4>
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
					
				
					
					<button type="button" class="btn btn-outline-primary" style="margin-left: 2%" >충전</button>
					
				</div>
			</div>
					
			<div class="col-12">
				<label for="pw1" class="form-label">비밀번호 수정</label>
			<div class="input-group">
					<input type="password" id="pw1" name="pw1" class="form-control" placeholder="비밀번호 수정" maxlength="20">
			</div>
			
			</div>
			<div class="coin" id="pw1"></div>
			
			<div class="col-12">
				<label for="pw2" class="form-label">비밀번호 확인</label>
				<div class="input-group">
					<input type="password" id="pw2" name="pw2" class="form-control" id="pw2"
						placeholder="비밀번호 수정 확인" maxlength="20">
			</div>
			<div class="coin" id="pwr"></div>
			
			</div>


			<div class="col-sm-6">
				<label for="email1" class="form-label">이메일</label>
				<div class="input-group">
					<input type="text" name="email1" class="form-control" id="email1"
						value="${vo.email1}" readonly>
						
				</div>
			</div>
			
			<div class="col-sm-6">
				<label for="email2" class="form-label">도메인</label>
				<div class="input-group">
					<span class="input-group-text">@</span> 
					<input type="text" name="email2" class="form-control" id="email2" value="${vo.email2}" readonly>
				</div>
			</div>
			
			<div class="col-12 mt-5">
				<button class="btn btn-outline-primary" onclick="return modify()" type="submit">완료</button>
				<a href="index"><button class="btn btn-outline-secondary" type="button">뒤로</button></a>
			</div>
			</div>
	</form>
	
	<div class="modal" tabindex="-1" id="MoneyModal">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">${id}님의 자산 그래프</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" id = 'modalclose'></button>
      </div>
      <div class="modal-body">
       <div id="container" style="height: 400px; min-width: 310px"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id = 'modalclose2'>Close</button>
      </div>
    </div>
  </div>
</div>

</body>
<%@ include file="/include/footer.jsp"%>
</html>
