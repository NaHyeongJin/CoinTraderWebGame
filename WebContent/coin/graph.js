$(function () {

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
		    		
		    		console.log(Aarray);
		   	}
		})
	}
	
	
	
	$(window).bind('hashchange', function() {
		if(timerId != null) {
	        clearInterval(timerId);
	    }
	});

	
	
function coin(){
	 $('#sellbutton').click(function(){
		  let y=$('#selltime').val();
		  $('#Asellpriceinput').val(Aarray[cnt+y]);
		  $('#Bsellpriceinput').val(Barray[cnt+y]);
		  $('#Csellpriceinput').val(Carray[cnt+y]);
		  $('#Dsellpriceinput').val(Darray[cnt+y]);
	  });
	var it = setInterval(function(){
			  var aput = Aarray[cnt];
			  var bput = Barray[cnt];
			  var cput = Carray[cnt];
			  var dput = Darray[cnt];
			  
			  $("#asd").text("현재가격:"+aput);
			  $("#bsd").text("현재가격:"+bput);
			  $("#csd").text("현재가격:"+cput);
			  $("#dsd").text("현재가격:"+dput);
			  
			  $('#Asellpriceinput').val(aput);
			  $('#Bsellpriceinput').val(bput);
			  $('#Csellpriceinput').val(cput);
			  $('#Dsellpriceinput').val(dput);	
		}, 1000);
	
	  $('#modalbutton').click(function(){
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