$(function () {
	var Aarray = new Array;
	var Barray = new Array;
	var Carray = new Array;
	var Darray = new Array;
	
	var timerId = null;
	if(timerId == null) {
			requestGetPrice();
	    	timerId = setInterval(requestGetPrice, 60000);
		}
	function requestGetPrice() {
		$.ajax({
		    url: "http://localhost:8089/CurrentPrice",
		    method: "GET",
		    dataType: "JSON",
		    success: function(data) {
		    	// data.coin1
		    	acoin(data.coin1);
		    	// data.coin2
		    	bcoin(data.coin2);
		    	// data.coin3
		    	ccoin(data.coin3);
		    	// data.coin4
		    	dcoin(data.coin4);
		    	// 각각 70개 배열이고
		    	// data.lastUpdateDate - "2020-12-28 15:10:46" String임
		    	// 이 데이터로 그래프 출력시켜주시면 됩니다
		   	}
		})
	}
	$(window).bind('hashchange', function() {
		if(timerId != null) {
	        clearInterval(timerId);
	    }
	});
	
	function acoin(aprice){
	var c = 0;
	var x = 0;

	var it = setInterval(function(){
		  if(x <= 60){
			  $("#asd").text("현재가격:"+aprice[x++]);
			  $('#modalbutton').click(function(){
				  $('#Apriceinput').val(aprice[x]);
			  });
		  }else{
			clearInterval(it);
			i=0;
		  }
		}, 1000);
	
	var chart1 = new Highcharts.stockChart('Acontainer', {
		  chart: {
			    events: {
			      load: function () {

			        // set up the updating of the chart each second
			        var series = this.series[0];
			        setInterval(function () {
			          var x = (new Date()).getTime(), // current time
			            y = aprice[c++];
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
			    name: 'A COIN',
			    data: (function () {
			      // generate an array of random data
			      var data = [],
			        time = (new Date()).getTime(),
			        i;

			      for (i = -59; i <= 0; i += 1) {
			        data.push([
			          time + i * 1000,
			          aprice[i]
			        ]);
			      }
			      return data;
			    }())
			  }]
			});
	};
	function bcoin(bprice){
		var c = 0;
		var x = 0;

		var it = setInterval(function(){
			  if(x <= 60){
				  $("#bsd").text("현재가격:"+bprice[x++]);
				  $('#modalbutton').click(function(){
					  $('#Bpriceinput').val(bprice[x]);
				  });
			  }else{
				clearInterval(it);
				i=0;
			  }
			}, 1000);
	var chart2 = new Highcharts.stockChart('Bcontainer', {
		  chart: {
			    events: {
			      load: function () {

			        // set up the updating of the chart each second
			        var series = this.series[0];
			        setInterval(function () {
			          var x = (new Date()).getTime(), // current time
			            y = bprice[c++];
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
			    name: 'Random data',
			    data: (function () {
			      // generate an array of random data
			      var data = [],
			        time = (new Date()).getTime(),
			        i;

			      for (i = -59; i <= 0; i += 1) {
			        data.push([
			          time + i * 1000,
			          bprice[i]
			        ]);
			      }
			      return data;
			    }())
			  }]
			});
	};
	function ccoin(cprice){
		var c = 0;
		var x = 0;

		var it = setInterval(function(){
			  if(x <= 60){
				  $("#csd").text("현재가격:"+cprice[x++]);
				  $('#modalbutton').click(function(){
					  $('#Cpriceinput').val(cprice[x]);
				  });
			  }else{
				clearInterval(it);
				i=0;
			  }
			}, 1000);
	var chart3 = new Highcharts.stockChart('Ccontainer', {
		  chart: {
			    events: {
			      load: function () {

			        // set up the updating of the chart each second
			        var series = this.series[0];
			        setInterval(function () {
			          var x = (new Date()).getTime(), // current time
			            y = cprice[c++];
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
			    name: 'C COIN',
			    data: (function () {
			      // generate an array of random data
			      var data = [],
			        time = (new Date()).getTime(),
			        i;

			      for (i = -59; i <= 0; i += 1) {
			        data.push([
			          time + i * 1000,
			          cprice[i]
			        ]);
			      }
			      return data;
			    }())
			  }]
			});
	};
	function dcoin(dprice){
		var c = 0;
		var x = 0;

		var it = setInterval(function(){
			  if(x <= 60){
				  $("#dsd").text("현재가격:"+dprice[x++]);
				  $('#modalbutton').click(function(){
					  $('#Dpriceinput').val(dprice[x]);
				  });
			  }else{
				clearInterval(it);
				i=0;
			  }
			}, 1000);
	var chart4 = new Highcharts.stockChart('Dcontainer', {
		  chart: {
			    events: {
			      load: function () {

			        // set up the updating of the chart each second
			        var series = this.series[0];
			        setInterval(function () {
			          var x = (new Date()).getTime(), // current time
			            y = dprice[c++];
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
			    name: 'D COIN',
			    data: (function () {
			      // generate an array of random data
			      var data = [],
			        time = (new Date()).getTime(),
			        i;

			      for (i = -59; i <= 0; i += 1) {
			        data.push([
			          time + i * 1000,
			          dprice[i]
			        ]);
			      }
			      return data;
			    }())
			  }]
			});

};
});