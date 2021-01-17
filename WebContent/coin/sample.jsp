<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
var timerId = null;
function Start() {
	if(timerId == null) {
		requestGetPrice();
    	timerId = setInterval(requestGetPrice, 60000);
	}
}
function Stop() {
	if(timerId != null) {
        clearInterval(timerId);
    }
}
function requestGetPrice() {
	$.ajax({
	    url: "http://localhost:8089/CurrentPrice",
	    method: "GET",
	    dataType: "JSON",
	    success: function(data) {
	    	// data.coin1
	    	console.log(data.coin1);
	    
	    	// data.coin2
	    	console.log(data.coin2);
	    	// data.coin3
	    	console.log(data.coin3);
	    	// data.coin4
	    	console.log(data.coin4);
	    	// 각각 70개 배열이고
	    	// data.lastUpdateDate - "2020-12-28 15:10:46" String임
	    	// 이 데이터로 그래프 출력시켜주시면 됩니다
	   	}
	})
}
$(window).bind('hashchange', function() {
    Stop();
});
</script>
<head>
<title>이 페이지 로딩 시 데이터 가져오고 벗어나면 interval 중지</title>
</head>
<body onload="Start();">
</body>
<%@ include file="/include/footer.jsp" %>
</html>