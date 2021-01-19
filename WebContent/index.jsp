<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>메인 화면입니다.</title>
<script type="text/javascript"> 
var imgArray=new Array(); 
imgArray[0]="gg.png"; 
imgArray[1]="ctg.png"; 

function showImage(){ 
	var imgNum=Math.round(Math.random()*3); 
	var objImg=document.getElementById("introimg"); 
	objImg.src=imgArray[imgNum]; 
	setTimeout(showImage,5000); }
</script>

</head>
<body>



	<a href="index.jsp"><img src="resource/img/indexcoin.jpg" width="180px" height="45px"></a> 
	<br>
	<br>
	
	<MARQUEE behavior="scroll" bgcolor=""> 
	이메일 문의<a href=""> ctg20@korea.com</a> 으로 문의 주세요<br></MARQUEE>
	
  	<img src="resource/img/graph.gif">
  	
  	<div align="left">
  	<div class="modal-body" align="center" style="color: green">
	First <small style="color: black">'초'단위로 바뀌는 시세 예측할 수 없는 게임!</small>
	</div>
	<div class="modal-body" align="center" style="color: blue">
	Second <small style="color: black">돈에 '부담'없는 가상 거래를 통해 자신의 재화를 모아 보세요!</small>
	</div>
	<div class="modal-body" align="center" style="color: orange">
	Third <small style="color: black">자신의 순위를 높여 보세요!</small>
	</div>
	</div>
	<!--   <div align="center">
	<video loop="loop" autoplay="autoplay" muted="muted" width="760" height="480" src="resource/video/simple.mp4" controls ></video> 
	</div>
	-->
	
</body>
<%@ include file="/include/footer.jsp" %>
</html>