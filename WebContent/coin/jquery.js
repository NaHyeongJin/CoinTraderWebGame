
$(function () {
$('#aCoin').popover({ //팝오버
		// fade 효과 사용 여부
		animation: true,
		// 지연 설정
		//delay: {show:500, hide:100},
		// 템필릿
		//html: false,
		// html false 경우 지정할 요소 selector
		//selector: false,
		// html true일 경우 사용되는 popover 템플릿
		//template: '<div class="popover" role="tooltip"><div class="arrow"></div><h3 class="popover-title"></h3><div class="popover-content"></div></div>',
		// 방향 (설정하면 요소의 data-placement 설정의 무효된다.)
		//viewport: { selector: 'body', padding: 0 },
		// 팝오버을 나타낼 특정 요소
		//container: false,
		 placement : 'right',
	     trigger : 'hover focus',
	     html: true,
	     content: function () {
				return 'aaa';
       }
		//placement: 'bottom',
		// 제목 (설정하면 요소의 title 설정의 무효된다.)
		//title: '',
		// 컨텐츠 값 (설정하면 요소의 data-content값은 무효된다.)
		// content: '',
		//sanitize: true,
		//sanitizeFn: null,
		//whiteList: ''    	 
	});
	$('#sellCoin').popover({
		animation: true,
		placement : 'right',
	     trigger : 'hover focus',
	     html: true,
	     content: function () {
				return '판매시 시간을 정해주세요';
      }
	});
	$('#bCoin').popover({
		animation: true,
		placement : 'right',
	     trigger : 'hover focus',
	     html: true,
	     content: function () {
				return 'bbbbb';
      }
	});
	$('#cCoin').popover({
		animation: true,
		placement : 'right',
	     trigger : 'hover focus',
	     html: true,
	     content: function () {
				return 'bbbbb';
      }
	});
	$('#dCoin').popover({
		animation: true,
		placement : 'right',
	     trigger : 'hover focus',
	     html: true,
	     content: function () {
				return 'bbbbb';
      }
	});
	$('#buyCoin').popover({
		
		animation: true,
		placement : 'right',
	     trigger : 'hover focus',
	     html: true,
	     content: function () {
				return '코인 구매시 팔아야함';
      }
	});
	
		$('#modalbutton').on('click', function(){//구입버튼 모달
			$('#myModal').modal('show');
			});
		$('#modalbutton2').on('click', function(){//판매버튼 모달
			var totprice = $('#priceinput').val();
			var totcoincnt = $('#coincnt').val();
			if(totprice==""){
				return $('.form-text').text('코인을 선택해주세요');
			}
			if(totcoincnt==""){
				return $('.form-text').text('수량을 확인해주세요');
			}
			$('#myModal').modal('hide');
			$('#myModal2').modal('show');
			$('.form-text').text('');
			$('#floatingInputValue').val(totprice+'  코인개수:'+totcoincnt);
			});
		
		$('#coincnt').on('keyup',function(e){//코인개수 구입시 경고문삭제
			$('.form-text').text('');
		});
		
		$('#closemodalbutton1,#closemodalbutton2').on('click', function(){//구입모달 x/닫기버튼
			$('#myModal').modal('hide');
			$('#priceinput').css('background-position','100px 6px');
			$('#priceinput').val('코인을 선택해주세요');
			$('.dropdown-toggle').text('코인');
			$('#coincnt').val('');
			$('.form-text').text('');
			});
		$('#closemodalbutton3,#closemodalbutton4').on('click', function(){//판매모달 x/닫기 삭제 예정
			$('#myModal2').modal('hide');
			$('#coincnt2').val('');
			$('#priceinput').val('');
			});
    

	
	
	$(".dropdown-menu li a").click(function(){//모달창 버튼 클릭 쿼리
		$('#priceinput').css('background-position','100px 6px');
		  var selText = $(this).html();
		  $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+' <span class="caret"></span>');
		});
	$('#aprice').click(function(){
		$('#priceinput').css('background-position','125px 6px');
		$('#priceinput').val('A코인:aaa원');
	});
	$('#bprice').click(function(){
		$('#priceinput').css('background-position','125px 6px');
		$('#priceinput').val('B코인:bbb원');
	});
	$('#cprice').click(function(){
		$('#priceinput').css('background-position','125px 6px');
		$('#priceinput').val('C코인:ccc원');
	});
	$('#dprice').click(function(){
		$('#priceinput').css('background-position','125px 6px');
		$('#priceinput').val('D코인:ddd원');
	});
});	