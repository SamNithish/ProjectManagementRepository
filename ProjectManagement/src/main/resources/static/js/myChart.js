var niceChartData = decodeHtml(chartData);
var chartJsonArray = JSON.parse(niceChartData);

var arrayLength = chartJsonArray.length;

var numericData = [];
var labelData = [];

for (var i = 0; i < arrayLength; i++) {
	numericData[i]=chartJsonArray[i].count;
	labelData[i]=chartJsonArray[i].stage;
}

new Chart(document.getElementById("myPieChart"),{
	type: 'pie',
	data: {
      labels: labelData,
      datasets: [{
        data: numericData,
        borderWidth: 1
      }]
    }
});

// "[{"count":1,"stage":"NOTSTARTED"},{"count":2,"stage":"INPROGRESS"},{"count":1,"stage":"COMPLETED"}]"
function decodeHtml(html) {
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}