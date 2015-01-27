var drawLineChart = function (info) {
	info = JSON.parse(info);
	
    $('#container').highcharts({
        title: {
            text: 'CI\'s line chart',
            x: -20 //center
        },
        xAxis: {
            categories: info["categories"]
        },
        yAxis: {
            title: {
                text: 'CI  =  PCCI / PCCO * SD  '
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'CI ',
            data: info["data"]
        }]
    });
}