<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      
      let dataAry= [['sido','Cnt per sido']];//,['서울',33],[]...[]]
      fetch('../getSidoInfo.do')
      .then(resolve =>resolve.json())
      .then(result => {
    	  console.log(result);
    	  result.forEach(item =>{
    		  console.log(item);
    		  dataAry.push([item.sido,item.cnt]);
    	  })
    	  google.charts.load('current', {'packages':['corechart']});
          google.charts.setOnLoadCallback(drawChart);  
      })
         console.log(dataAry);
      function drawChart() {

        var data = google.visualization.arrayToDataTable(dataAry);

        var options = {
          title: '일과 구성표'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
