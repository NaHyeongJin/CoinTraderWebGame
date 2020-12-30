$(function () {
	
	var chart1 = new Highcharts.stockChart('Acontainer', {
		  chart: {
			    events: {
			      load: function () {

			        // set up the updating of the chart each second
			        var series = this.series[0];
			        setInterval(function () {
			          var x = (new Date()).getTime(), // current time
			            y = Math.round(Math.random() * 100);
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
			    name: 'Random data',
			    data: (function () {
			      // generate an array of random data
			      var data = [],
			        time = (new Date()).getTime(),
			        i;

			      for (i = -60; i <= 0; i += 1) {
			        data.push([
			          time + i * 1000,
			          Math.round(Math.random() * 100)
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
			            y = Math.round(Math.random() * 100);
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

			      for (i = -999; i <= 0; i += 1) {
			        data.push([
			          time + i * 1000,
			          Math.round(Math.random() * 100)
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
			            y = Math.round(Math.random() * 100);
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
			    name: 'Random data',
			    data: (function () {
			      // generate an array of random data
			      var data = [],
			        time = (new Date()).getTime(),
			        i;

			      for (i = -999; i <= 0; i += 1) {
			        data.push([
			          time + i * 1000,
			          Math.round(Math.random() * 100)
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
			            y = Math.round(Math.random() * 100);
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
			    name: 'Random data',
			    data: (function () {
			      // generate an array of random data
			      var data = [],
			        time = (new Date()).getTime(),
			        i;

			      for (i = -999; i <= 0; i += 1) {
			        data.push([
			          time + i * 1000,
			          Math.round(Math.random() * 100)
			        ]);
			      }
			      return data;
			    }())
			  }]
			});
});