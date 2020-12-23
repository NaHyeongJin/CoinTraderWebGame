
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
	
	
		$('#modalbutton').on('click', function(){
			$('#myModal').modal('show');
			});
		$('#modalbutton2').on('click', function(){
			$('#myModal').modal('hide');
			$('#myModal2').modal('show');
			var totprice = $('#priceinput').val();
			var totcoincnt = $('#coincnt').val();
			$('#floatingInputValue').val(totprice+'  개수:'+totcoincnt);
			});

		
		$('#closemodalbutton1,#closemodalbutton2').on('click', function(){
			$('#myModal').modal('hide');
			$('#priceinput').val('코인을 선택해주세요');
			$('.dropdown-toggle').text('코인');
			$('#coincnt').val('');
			});
		$('#closemodalbutton3,#closemodalbutton4').on('click', function(){
			$('#myModal2').modal('hide');
			$('#coincnt2').val('');
			});
    

	$('#myCarousel').carousel({
		 
		 interval: 2000,
		 pause: "hover",
		 wrap: true,
	});
	
	$(".dropdown-menu li a").click(function(){
		  var selText = $(this).html();
		  $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+' <span class="caret"></span>');
		});
	$('#aprice').click(function(){
		$('#priceinput').val('가격:aaa');
	});
	$('#bprice').click(function(){
		$('#priceinput').val('가격:bbb');
	});
	$('#cprice').click(function(){
		$('#priceinput').val('가격:ccc');
	});
	$('#dprice').click(function(){
		$('#priceinput').val('가격:ddd');
	});

Highcharts.setOptions({
});

var chart1 = new Highcharts.chart('Acontainer', {
	  chart: {
	    type: 'spline',
	    animation: Highcharts.svg, // don't animate in old IE
	    marginRight: 10,
	    events: {
	      load: function () {

	        // set up the updating of the chart each second
	        var series = this.series[0];
	        setInterval(function () {
	          var x = (new Date()).getTime(), // current time
	            y = Math.floor( ( Math.random() * 10 ) );
	          series.addPoint([x, y], true, true);
	        }, 5000);
	      }
	    }
	  },
	  
	  time: {
	    useUTC: false
	  },
	  
	  title: {
	    text: 'A COIN'
	  },
	  
	  accessibility: {
	    announceNewData: {
	      enabled: true,
	      minAnnounceInterval: 15000,
	      announcementFormatter: function (allSeries, newSeries, newPoint) {
	        if (newPoint) {
	          return 'New point added. Value: ' + newPoint.y;
	        }
	        return false;
	      }
	    }
	  },
	  
	  xAxis: {
	    type: 'datetime',
	    tickPixelInterval: 150
	  },
	  
	  yAxis: {
	    title: {
	      text: 'Value'
	    },
	    plotLines: [{
	      value: 0,
	      width: 1,
	      color: '#808080'
	    }]
	  },

	  tooltip: {
	    headerFormat: '<b>{series.name}</b><br/>',
	    pointFormat: '{point.x:%Y-%m-%d %H:%M:%S}<br/>{point.y:.2f}'
	  },

	  legend: {
	    enabled: false
	  },

	  exporting: {
	    enabled: false
	  },

	  series: [{
	    name: 'Random data',
	    data: (function () {
	      // generate an array of random data
	      var data = [],
	        time = (new Date()).getTime(),
	        i;
	      
	      for (i = -9; i <= 0; i += 1) {
	        data.push({
	          x: time + i * 1000,
	          y: Math.floor( ( Math.random() * 10 ) )
	        });
	        
	      }
	      return data;
	    }())
	  }]
	});

var chart2 = new Highcharts.chart('Bcontainer', {
	  chart: {
	    type: 'spline',
	    animation: Highcharts.svg, // don't animate in old IE
	    marginRight: 10,
	    events: {
	      load: function () {

	        // set up the updating of the chart each second
	        var series = this.series[0];
	        setInterval(function () {
	          var x = (new Date()).getTime(), // current time
	            y = Math.random();
	          series.addPoint([x, y], true, true);
	        }, 5000);
	      }
	    }
	  },

	  time: {
	    useUTC: false
	  },

	  title: {
	    text: 'B COIN'
	  },

	  accessibility: {
	    announceNewData: {
	      enabled: true,
	      minAnnounceInterval: 15000,
	      announcementFormatter: function (allSeries, newSeries, newPoint) {
	        if (newPoint) {
	          return 'New point added. Value: ' + newPoint.y;
	        }
	        return false;
	      }
	    }
	  },

	  xAxis: {
	    type: 'datetime',
	    tickPixelInterval: 150
	  },

	  yAxis: {
	    title: {
	      text: 'Value'
	    },
	    plotLines: [{
	      value: 0,
	      width: 1,
	      color: '#808080'
	    }]
	  },

	  tooltip: {
	    headerFormat: '<b>{series.name}</b><br/>',
	    pointFormat: '{point.x:%Y-%m-%d %H:%M:%S}<br/>{point.y:.2f}'
	  },

	  legend: {
	    enabled: false
	  },

	  exporting: {
	    enabled: false
	  },

	  series: [{
	    name: 'Random data',
	    data: (function () {
	      // generate an array of random data
	      var data = [],
	        time = (new Date()).getTime(),
	        i;

	      for (i = -19; i <= 0; i += 1) {
	        data.push({
	          x: time + i * 100,
	          y: Math.random()
	        });
	      }
	      return data;
	    }())
	  }]
	});

var chart3 = new Highcharts.chart('Ccontainer', {
	  chart: {
	    type: 'spline',
	    animation: Highcharts.svg, // don't animate in old IE
	    marginRight: 10,
	    events: {
	      load: function () {

	        // set up the updating of the chart each second
	        var series = this.series[0];
	        setInterval(function () {
	          var x = (new Date()).getTime(), // current time
	            y = Math.random();
	          series.addPoint([x, y], true, true);
	        }, 5000);
	      }
	    }
	  },

	  time: {
	    useUTC: false
	  },

	  title: {
	    text: 'C COIN'
	  },

	  accessibility: {
	    announceNewData: {
	      enabled: true,
	      minAnnounceInterval: 15000,
	      announcementFormatter: function (allSeries, newSeries, newPoint) {
	        if (newPoint) {
	          return 'New point added. Value: ' + newPoint.y;
	        }
	        return false;
	      }
	    }
	  },

	  xAxis: {
	    type: 'datetime',
	    tickPixelInterval: 150
	  },

	  yAxis: {
	    title: {
	      text: 'Value'
	    },
	    plotLines: [{
	      value: 0,
	      width: 1,
	      color: '#808080'
	    }]
	  },

	  tooltip: {
	    headerFormat: '<b>{series.name}</b><br/>',
	    pointFormat: '{point.x:%Y-%m-%d %H:%M:%S}<br/>{point.y:.2f}'
	  },

	  legend: {
	    enabled: false
	  },

	  exporting: {
	    enabled: false
	  },

	  series: [{
	    name: 'Random data',
	    data: (function () {
	      // generate an array of random data
	      var data = [],
	        time = (new Date()).getTime(),
	        i;

	      for (i = -19; i <= 0; i += 1) {
	        data.push({
	          x: time + i * 100,
	          y: Math.random()
	        });
	      }
	      return data;
	    }())
	  }]
	});

var chart4 = new Highcharts.chart('Dcontainer', {
	  chart: {
	    type: 'spline',
	    animation: Highcharts.svg, // don't animate in old IE
	    marginRight: 10,
	    events: {
	      load: function () {

	        // set up the updating of the chart each second
	        var series = this.series[0];
	        setInterval(function () {
	          var x = (new Date()).getTime(), // current time
	            y = Math.random();
	          series.addPoint([x, y], true, true);
	        }, 5000);
	      }
	    }
	  },

	  time: {
	    useUTC: false
	  },

	  title: {
	    text: 'D COIN'
	  },

	  accessibility: {
	    announceNewData: {
	      enabled: true,
	      minAnnounceInterval: 15000,
	      announcementFormatter: function (allSeries, newSeries, newPoint) {
	        if (newPoint) {
	          return 'New point added. Value: ' + newPoint.y;
	        }
	        return false;
	      }
	    }
	  },

	  xAxis: {
	    type: 'datetime',
	    tickPixelInterval: 150
	  },

	  yAxis: {
	    title: {
	      text: 'Value'
	    },
	    plotLines: [{
	      value: 0,
	      width: 1,
	      color: '#808080'
	    }]
	  },

	  tooltip: {
	    headerFormat: '<b>{series.name}</b><br/>',
	    pointFormat: '{point.x:%Y-%m-%d %H:%M:%S}<br/>{point.y:.2f}'
	  },

	  legend: {
	    enabled: false
	  },

	  exporting: {
	    enabled: false
	  },

	  series: [{
	    name: 'Random data',
	    data: (function () {
	      // generate an array of random data
	      var data = [],
	        time = (new Date()).getTime(),
	        i;

	      for (i = -19; i <= 0; i += 1) {
	        data.push({
	          x: time + i * 100,
	          y: Math.random()
	        });
	      }
	      return data;
	    }())
	  }]
	});


});