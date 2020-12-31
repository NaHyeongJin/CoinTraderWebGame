<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>메인 화면입니다.</title>

<script type="text/javascript" src="resource/js/bootstrap.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>

<link rel="stylesheet" href="resource/css/bootstrap.css">
<link rel="stylesheet" href="coin/graph.css">
</head>
<body>

	<figure class="highcharts-figure">
  		<div id="Acontainer"></div>
  		<p class="highcharts-description">A COIN </p>
  		<div align="right"><button id="gg" value="10초">10초</button>
  		<button id="qq" value="30초">30초</button>
  		</div>  
		</figure>
		
	<script type="text/javascript" src="resource/js/bootstrap.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="coin/graph.js"></script>	

</head>
<body>
	<h1 class="display-4">메인 화면입니다</h1>
	<p class="lead">사이트에 대한 설명을 여기에 적으면 될 듯</p>

</body>
<%@ include file="/include/footer.jsp" %>
</html>