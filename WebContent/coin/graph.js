$(function () {
	var priceinput;
	var coincnt;
	var amount;
	var sellprice;
	var timer;
	var Aarray = [];
	var Barray = [];
	var Carray = [];
	var Darray = [];
	var cnt = 0;
	
	let update = null;
	let timerId = null;
	const firstTime = (new Date()).getTime();

	if(timerId == null) {
			getPriceInit();
	    	timerId = setInterval(function(){
	    		requestGetPrice();
	    		},60000);
		}
	  function getPriceInit() {
		  
		    $.ajax({
		      url: "http://localhost:8089/CoinTraderWebGame/CurrentPrice",
		      method: "GET",
		      dataType: "JSON",
		      success: function (data) {
		    	let cntplus = setInterval(function(){
					cnt = Math.round(((new Date()).getTime() - firstTime) / 1000);
				}, 1000);
		        update = data.lastUpdateDate;
		        Aarray = data.coin1;
		        Barray = data.coin2;
		        Carray = data.coin3;
		        Darray = data.coin4;
		        coin();
		       
		      },
		    });
		  }

	function requestGetPrice() {
		$.ajax({
		    url: "http://localhost:8089/CoinTraderWebGame/CurrentPrice",
		    method: "GET",
		    async:false,
		    dataType: "JSON",
		    success: function(data) {
		    		var dif = (Date.parse(data.lastUpdateDate) - Date.parse(update)) / 1000;
		    		update = data.lastUpdateDate;
		    		Aarray = Aarray.concat(data.coin1.splice(0, dif));
		    		Barray = Barray.concat(data.coin2.splice(0, dif));
		    		Carray = Carray.concat(data.coin3.splice(0, dif));
		    		Darray = Darray.concat(data.coin4.splice(0, dif));		
		   	}
		})
	}
	$(window).bind('hashchange', function() {
		if(timerId != null) {
	        clearInterval(timerId);
	    }
	});
	function CoinBuy() {
		var code = "http://localhost:8089/CoinTraderWebGame/coin?cmd=coin_buy&cnt="+coincnt+"&amount="+amount+"&price="+priceinput+"";
		var url = encodeURI(code);
		$.ajax({
		    url: url,
		    method: "GET",
		    dataType: "JSON",
		    success: function(data) {
		   	}
		})
	}
	function CoinSell() {
		var code = "http://localhost:8089/CoinTraderWebGame/coin?cmd=coin_sell&cnt="+coincnt+"&amount="+amount+"&sellprice="+sellprice+"&timer="+timer+"";
		var url = encodeURI(code);
		$.ajax({
		    url: url,
		    method: "GET",
		    dataType: "JSON",
		    success: function(data) {
		   	}
		})
	}
	
	
function coin(){
	$('#sellbutton').click(function(){
		  let coinname = $('#coinname').val();
		  let y=$('#selltime').val();
		  let buyalert;
		  let sellalert;
		  timer = y;
		  amount = $('#coincnt').val();
		  priceinput=$("#priceinput").val();
		  y = Number(y);
		  cnt = Number(cnt);
		  var aput = Aarray[cnt+y];
		  var bput = Barray[cnt+y];
		  var cput = Carray[cnt+y];
		  var dput = Darray[cnt+y];
	  		if(coinname.indexOf('A')!==-1){
	  			coincnt=1;
	  			sellprice = aput;
	  			buyalert="A코인 "+amount+"개를 총 "+amount*priceinput+"원에 구매되었습니다.";
	  			sellalert="A코인 "+amount+"개가 총 "+amount*sellprice+"원에 판매되었습니다.";
	  		}else if(coinname.indexOf('B')!==-1){
	  			coincnt=2;
	  			sellprice = bput;
	  			buyalert="B코인 "+amount+"개를 총 "+amount*priceinput+"원에 구매하셨습니다.";
	  			sellalert="B코인 "+amount+"개가 총 "+amount*sellprice+"원에 판매되었습니다.";
	  		}else if(coinname.indexOf('C')!==-1){
	  			coincnt=3;
	  			sellprice = cput;
	  			buyalert="C코인 "+amount+"개를 총 "+amount*priceinput+"원에 구매하셨습니다.";
	  			sellalert="C코인 "+amount+"개가 총 "+amount*sellprice+"원에 판매되었습니다.";
	  		}else if(coinname.indexOf('D')!==-1){
	  			coincnt=4;
	  			sellprice = dput;
	  			buyalert="D코인 "+amount+"개를 총 "+amount*priceinput+"원에 구매하셨습니다.";
	  			sellalert="D코인 "+amount+"개가 총 "+amount*sellprice+"원에 판매되었습니다.";
	  		}
	  		if(y==0){
	  			$('.form-text').css('color','red');
				return $('.form-text').text('판매할시간을 선택해주세요');
			}
			$('#myModal2').modal('hide');
			CoinBuy();
			alert(buyalert);
			CoinSell();
			$('#rrr2').text('');
			$('#coincnt').val('');
			$('.form-text').text('');
			$('#coinname').css('background-position','100px 6px');
			$('#coinname').val('코인을 선택해주세요');
			$('.dropdown-toggle').text('코인');
			$('#floatingInputValue').val('');
			$('#coincnt2').val('');
			setTimeout(function() {
				  alert(sellalert);
				}, y*1000);	
			});
	var it = setInterval(function(){
			var aput = Aarray[cnt];
			var bput = Barray[cnt];
			var cput = Carray[cnt];
			var dput = Darray[cnt];
			if(aput>Aarray[cnt-1]){
				$("#asd").css("color","blue");
				$("#asd").text(aput+"▲");
			}else if(aput==Aarray[cnt-1]){
				$("#asd").css("color","black");
				$("#asd").text(aput+"=");
			}else if(aput<Aarray[cnt-1]){
				$("#asd").css("color","red");
				$("#asd").text(aput+"▼");
			}else{
				$("#asd").text(aput);
			}
			
			if(bput>Barray[cnt-1]){
				$("#bsd").css("color","blue");
				$("#bsd").text(bput+"▲");
			}else if(bput==Barray[cnt-1]){
				$("#bsd").css("color","black");
				$("#bsd").text(bput+"=");
			}else if(bput<Barray[cnt-1]){
				$("#bsd").css("color","red");
				$("#bsd").text(bput+"▼");
			}else{
				$("#bsd").text(bput);
			}
			
			if(cput>Carray[cnt-1]){
				$("#csd").css("color","blue");
				$("#csd").text(cput+"▲");
			}else if(cput==Carray[cnt-1]){
				$("#csd").css("color","black");
				$("#csd").text(cput+"=");
			}else if(cput<Carray[cnt-1]){
				$("#csd").css("color","red");
				$("#csd").text(cput+"▼");
			}else{
				$("#csd").text(cput);
			}
			
			if(dput>Darray[cnt-1]){
				$("#dsd").css("color","blue");
				$("#dsd").text(dput+"▲");
			}else if(dput==Darray[cnt-1]){
				$("#dsd").css("color","black");
				$("#dsd").text(dput+"=");
			}else if(dput<Darray[cnt-1]){
				$("#dsd").css("color","red");
				$("#dsd").text(dput+"▼");
			}else{
				$("#dsd").text(dput);
			}	
		}, 1000);
	
	  $('#modalbutton').click(function(){//구입모달버튼이벤트
		  $('#myModal').modal('show');
		  var money = $("#prmoney").val();
		  $('#rrr').text('내 자산 :'+money);
		  $('#Apriceinput').val(Aarray[cnt]);
		  $('#Bpriceinput').val(Barray[cnt]);
		  $('#Cpriceinput').val(Carray[cnt]);
		  $('#Dpriceinput').val(Darray[cnt]);
	  });
	
	var chart1 = new Highcharts.stockChart('Acontainer', {
		
			chart: {
				events: {
					load: function () {

				// set up the updating of the chart each second
		        var series = this.series[0];
		        setInterval(function () {
		          var x = (new Date()).getTime(), // current time
		            y = Aarray[cnt];
		          series.addPoint([x, y], true, true);
		        }, 1000);
		      }
		    }
		  },

			  time: {
			    useUTC: false
			  },

			  rangeSelector: {
			    buttons: [{
			      count: 10,
			      type: 'second',
			      text: '10초'
			    }, {
			      count: 30,
			      type: 'second',
			      text: '30초'
			    }, {
			      type: 'all',
			      text: 'All'
			    }],
			    inputEnabled: false,
			    selected: 0
			  },

			  title: {
			    text: 'ACOIN'
			  },

			  exporting: {
			    enabled: false
			  },

			  series: [{
				    name: 'A coin',
				    data: (function () {
				      // generate an array of random data
				      var data = [],
				        time = (new Date()).getTime(),
				        i;

				      for (i = -59; i <= 0; i += 1) {
				        data.push([
				          time + i * 1000,
				          Aarray[i]
				        ]);
				      }
				      return data;
				    }())
				  }]
			});
	var chart2 = new Highcharts.stockChart('Bcontainer', {
		
		chart: {
			events: {
				load: function () {

			// set up the updating of the chart each second
	        var series = this.series[0];
	        setInterval(function () {
	          var x = (new Date()).getTime(), // current time
	            y = Barray[cnt];
	          series.addPoint([x, y], true, true);
	        }, 1000);
	      }
	    }
	  },

		  time: {
		    useUTC: false
		  },

		  rangeSelector: {
		    buttons: [{
		      count: 10,
		      type: 'second',
		      text: '10초'
		    }, {
		      count: 30,
		      type: 'second',
		      text: '30초'
		    }, {
		      type: 'all',
		      text: 'All'
		    }],
		    inputEnabled: false,
		    selected: 0
		  },

		  title: {
		    text: 'BCOIN'
		  },

		  exporting: {
		    enabled: false
		  },

		  series: [{
			    name: 'B COIN',
			    data: (function () {
			      // generate an array of random data
			      var data = [],
			        time = (new Date()).getTime(),
			        i;

			      for (i = -59; i <= 0; i += 1) {
			        data.push([
			          time + i * 1000,
			          Barray[i]
			        ]);
			      }
			      return data;
			    }())
			  }]
		});
	var chart3 = new Highcharts.stockChart('Ccontainer', {
		
		chart: {
			events: {
				load: function () {

			// set up the updating of the chart each second
	        var series = this.series[0];
	        setInterval(function () {
	          var x = (new Date()).getTime(), // current time
	            y = Carray[cnt];
	          series.addPoint([x, y], true, true);
	        }, 1000);
	      }
	    }
	  },

		  time: {
		    useUTC: false
		  },

		  rangeSelector: {
		    buttons: [{
		      count: 10,
		      type: 'second',
		      text: '10초'
		    }, {
		      count: 30,
		      type: 'second',
		      text: '30초'
		    }, {
		      type: 'all',
		      text: 'All'
		    }],
		    inputEnabled: false,
		    selected: 0
		  },

		  title: {
		    text: 'CCOIN'
		  },

		  exporting: {
		    enabled: false
		  },

		  series: [{
			    name: 'C coin',
			    data: (function () {
			      // generate an array of random data
			      var data = [],
			        time = (new Date()).getTime(),
			        i;

			      for (i = -59; i <= 0; i += 1) {
			        data.push([
			          time + i * 1000,
			          Carray[i]
			        ]);
			      }
			      return data;
			    }())
			  }]
		});
	var chart4 = new Highcharts.stockChart('Dcontainer', {
		
		chart: {
			events: {
				load: function () {

			// set up the updating of the chart each second
	        var series = this.series[0];
	        setInterval(function () {
	          var x = (new Date()).getTime(), // current time
	            y = Darray[cnt];
	          series.addPoint([x, y], true, true);
	        }, 1000);
	      }
	    }
	  },

		  time: {
		    useUTC: false
		  },

		  rangeSelector: {
		    buttons: [{
		      count: 10,
		      type: 'second',
		      text: '10초'
		    }, {
		      count: 30,
		      type: 'second',
		      text: '30초'
		    }, {
		      type: 'all',
		      text: 'All'
		    }],
		    inputEnabled: false,
		    selected: 0
		  },

		  title: {
		    text: 'DCOIN'
		  },

		  exporting: {
		    enabled: false
		  },

		  series: [{
			    name: 'D coin',
			    data: (function () {
			      // generate an array of random data
			      var data = [],
			        time = (new Date()).getTime(),
			        i;

			      for (i = -59; i <= 0; i += 1) {
			        data.push([
			          time + i * 1000,
			          Darray[i]
			        ]);
			      }
			      return data;
			    }())
			  }]
		});
};
});