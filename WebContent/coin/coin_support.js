$(function () {
	let price;
$('#aCoin').popover({ //팝오버
		animation: true,
		 placement : 'right',
	     trigger : 'hover focus',
	     html: true,
	     content: function () {
				return 'A COIN - 상승 하락폭이 B 코인에 비해 현저히 낮은 코인';
       }   	 
	});
	$('#sellCoin').popover({
		animation: true,
		placement : 'right',
	     trigger : 'hover focus',
	     html: true,
	     content: function () {
				return '판매시 시간을 정하여 판매를 눌러주세요 정한시간뒤에 가격으로 판매가 됩니다';
      }
	});
	$('#bCoin').popover({
		animation: true,
		placement : 'right',
	     trigger : 'hover focus',
	     html: true,
	     content: function () {
				return 'B COIN - 상승,하락폭이 큰 코인';
      }
	});
	$('#cCoin').popover({
		animation: true,
		placement : 'right',
	     trigger : 'hover focus',
	     html: true,
	     content: function () {
				return 'C COIN - 상승폭이 작은 대신 상승 확률이 높고 하락시 폭락하는 코인';
      }
	});
	$('#dCoin').popover({
		animation: true,
		placement : 'right',
	     trigger : 'hover focus',
	     html: true,
	     content: function () {
				return 'D COIN - 하락폭이 작지만 하락확률이 높고 상승시 대박을 치는 코인';
      }
	});
	
	$('#buyCoin').popover({		
		animation: true,
		placement : 'right',
	     trigger : 'hover focus',
	     html: true,
	     content: function () {
				return '코인 구매시 반드시 팔아야 합니다 결정후 구매버튼을 눌러주세요';
      }
	});	  	
	  	
		$('#modalbutton2').on('click', function(){//판매모달버튼이벤트
			$("#priceinput").val(price);
			var totprice = $('#coinname').val();
			var totcoincnt = $('#coincnt').val();
			var money = $("#prmoney").val();			
			var reprice = price*totcoincnt;
			var chk = money-reprice;
			if(totprice==""||totprice=="코인을 선택해주세요"){
				return $('.form-text').text('코인을 선택해주세요');
			}
			if(totcoincnt==""){
				return $('.form-text').text('수량을 확인해주세요');
			}
			if(money<reprice){
				return $('.form-text').text('자산을 초과하였습니다.');
			}
			if($("#flexCheckDefault").val()==0){
				return $('.form-text').text('구매확정체크를 확인해주세요.');
			}
			$('#rrr2').text('구입시 고객님의 남은 자산 :'+chk+"원");
			$("#rrr2").css( "color", "red" );
			$('#myModal').modal('hide');
			$('#myModal2').modal('show');
			$('.form-text').text('');
			$('#floatingInputValue').val(totprice+'  코인개수:'+totcoincnt);
			$('#coincnt2').val(totcoincnt);
			});
	    $("#flexCheckDefault").change(function(){
		if($(this).is(":checked")){
			$(this).val(1);
			$('.form-text').text('');
		}else{
			$(this).val(0);
		}
	    });
		$('#coincnt').on('keyup',function(e){//코인개수 구입시 경고문삭제
			var money = $("#prmoney").val();
			var totcoincnt = $('#coincnt').val();
			var cn = $('#coinname').val();
			var totprice = price*totcoincnt;
			var my = money-totprice;
						
			if(money<totprice){
				$('#rrr').text('내 자산 : 0');
				return $('.form-text').text('자산을 초과하였습니다.');
			}
			if(totcoincnt==""){
				$('#rrr').text('내 자산 :'+money);
			}
			if(cn==""){
				return $('.form-text').text('코인을 선택해주세요.');
			}
			$('#rrr').text('내 자산 :'+my);
			$('.form-text').text('');
		});
	
		$('#closemodalbutton1,#closemodalbutton2').on('click', function(){//구입모달 x/닫기버튼
			$('#myModal').modal('hide');
			$('#coinname').css('background-position','100px 6px');
			$('#coinname').val('코인을 선택해주세요');
			$('.dropdown-toggle').text('코인');
			$('#coincnt').val('');
			$('.form-text').text('');
			});
		
	$(".dropdown-menu li a").click(function(){//모달창 버튼 클릭 쿼리
		$('#coinname').css('background-position','100px 6px');
		  var selText = $(this).html();
		  $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+' <span class="caret"></span>');
		});
	$('#aprice').click(function(){
		$('.form-text').text('');
		var money = $("#prmoney").val();
		$('#rrr').text('내 자산 :'+money);
		$('#coincnt').val("");
		var apr = $("#Apriceinput").val();
		$('#coinname').css('background-position','125px 5px');
		$('#coinname').val('A코인:'+$("#Apriceinput").val()+"원");
		price = apr;
	});
	$('#3sc').click(function(){
		$('#selltime').val(3);
	});
	$('#bprice').click(function(){
		$('.form-text').text('');
		var money = $("#prmoney").val();
		$('#rrr').text('내 자산 :'+money);
		$('#coincnt').val("");
		var bpr = $("#Bpriceinput").val();
		$('#coinname').css('background-position','125px 6px');
		$('#coinname').val('B코인:'+$("#Bpriceinput").val()+"원");
		price = bpr;
	});
	$('#5sc').click(function(){
		$('#selltime').val(5);
	});
	$('#cprice').click(function(){
		$('.form-text').text('');
		var money = $("#prmoney").val();
		$('#rrr').text('내 자산 :'+money);
		$('#coincnt').val("");
		var cpr = $("#Cpriceinput").val();
		$('#coinname').css('background-position','125px 6px');
		$('#coinname').val('C코인:'+$("#Cpriceinput").val()+'원');
		price = cpr;
	});
	$('#7sc').click(function(){
		$('#selltime').val(7);
	});
	$('#dprice').click(function(){
		$('.form-text').text('');
		var money = $("#prmoney").val();
		$('#rrr').text('내 자산 :'+money);
		$('#coincnt').val("");
		var dpr = $("#Dpriceinput").val();
		$('#coinname').css('background-position','125px 6px');
		$('#coinname').val('D코인:'+$("#Dpriceinput").val()+"원");
		price = dpr;
	});
	$('#10sc').click(function(){
		$('#selltime').val(10);
		
	});
});	