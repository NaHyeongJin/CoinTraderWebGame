<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Coin 현황</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://code.highcharts.com/stock/highstock.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<script src="coin/coin_support.js"></script>
<link rel="stylesheet" href="resource/css/bootstrap.css">
<link rel="stylesheet" href="resource/css/bootstrap.min.css">
<link rel="stylesheet" href="coin/graph.css">
<style type="text/css">
#coinname {
  width: 100%;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
  background-color: white;
  background-image: url('coin/img/Won-512.png');
  background-size: 23px;
  background-position: 100px 6px; 
  background-repeat: no-repeat;
  
  padding: 12px 20px 12px 40px;
}
.modal-footer {

  display: inherit;

}
</style>
</head>

<body>
<div class="modal fade" id="myModal" tabindex="-1" >
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><b>코인구매<a id="buyCoin" data-toggle="popover">
		<img alt="" src="coin/img/chat-dots.svg">
  		</a></b></h5>
        
        <a id ="closemodalbutton1"><img alt="" src="coin/img/x.svg" width="30" height="30"></a>
      </div>
      
      
    
      <div class="modal-body">
      
  <div id = "rrr"></div> <!-- 구입모달창 자산표시 -->
 <div class="input-group mb-3">
  <div class="btn-group">
    <button class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown" href="#" >코인<span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li id = aprice><a class="dropdown-item" href="#"><B>A코인</B></a></li>
      <li id = bprice><a class="dropdown-item" href="#"><B>B코인</B></a></li>
      <li id = cprice><a class="dropdown-item" href="#"><B>C코인</B></a></li>
      <li id = dprice><a class="dropdown-item" href="#"><B>D코인</B></a></li>
    </ul>
  </div>
 
  <input type="text" style=" text-align:center;" name="coinname"id='coinname' placeholder="코인을 선택해주세요" class="form-control" aria-label="Text input with dropdown button" readonly="readonly">
  <input type="hidden" value="0" name="priceinput" id="priceinput">
  <input type="hidden" value="0" name="sellpriceinput" id="sellpriceinput">
  <input type="hidden" value="0" id="Asellpriceinput">
  <input type="hidden" value="0" id="Bsellpriceinput">
  <input type="hidden" value="0" id="Csellpriceinput">
  <input type="hidden" value="0" id="Dsellpriceinput">
  <input type="hidden" value="0" id="Apriceinput">
  <input type="hidden" value="0" id="Bpriceinput">
  <input type="hidden" value="0" id="Cpriceinput">
  <input type="hidden" value="0" id="Dpriceinput">

</div>
  <div class="row g-3 align-items-center">
  <div class="col-auto">
    <label for="inputPassword6" class="col-form-label">구매수량</label>
  </div>
  <div class="col-auto" align="center">
    <input style="text-align: center;" type="number" id="coincnt" name="coincnt"class="form-control" aria-describedby="passwordHelpInline">
  </div>
</div>
 <div class="col-auto" style="padding-bottom: 15px;" align="center">
    <span id="passwordHelpInline" class="form-text" style="color: red;">
    	
    </span>
  </div>
  

      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" id ="closemodalbutton2">닫기</button>
        <button id="modalbutton2" data-bs-toggle="modal" data-bs-target="#myModal2" type="button" class="btn btn-primary">바로구매<img alt="" src="coin/img/cart-check.svg" width="20" height="25" ></button>
       </div> 
       
      </div>
      
      </div>
    </div>
  </div>
  
<div class="modal fade" data-backdrop="static" data-keyboard="false" id="myModal2" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel2"><b>코인판매<a id="sellCoin" data-toggle="popover">
		<img alt="" src="coin/img/chat-dots.svg">
  		</a></b></h5>
        
      </div>

      <div class="modal-body">
    
   <label for="floatingInputValue"><b>구입한 코인</b></label>
   <input type="hidden" id = "prmoney" value=0>
  	<div id = "rrr2">
  	
	</div>    
  <input type="text" style="text-align: center;" class="form-control" id="floatingInputValue" placeholder="name@example.com" value="" readonly="readonly">
 
  
<label for="floatingInputValue" style="padding-top: 10px;"><b>판매할 코인</b></label>
 <div class="input-group mb-3">
  <div class="row g-3 align-items-center">
  <div class="col-auto">
    <label for="inputPassword6" class="col-form-label">판매수량</label>
  </div>
  <div class="col-auto" style="padding-left: 0px;">
    <input style="text-align: center;" type="text" id="coincnt2" readonly="readonly" class="form-control" aria-describedby="passwordHelpInline">
  </div>
   <div class="btn-group">
    <button class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown" href="#" >시간선택<span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a class="dropdown-item" href="#" id="3sc"><B>3초후</B></a></li>
      <li><a class="dropdown-item" href="#" id="5sc"><B>5초후</B></a></li>
      <li><a class="dropdown-item" href="#" id="7sc"><B>7초후</B></a></li>
      <li><a class="dropdown-item" href="#" id="10sc"><B>10초후</B></a></li>
    </ul>
  </div>
    <input type="hidden" name="selltime" id ="selltime" value="0">
    
</div>
</div>

<div class="col-auto" style="padding-bottom: 15px;">
    <span id="passwordHelpInline" class="form-text">
    	
    </span>
  </div>
       
  

      <div class="modal-footer">
      
        <button id=sellbutton type="button" class="btn btn-primary">바로팔기<img alt="" src="coin/img/cart-check.svg" width="20" height="25" ></button>
        
       </div>
      </div>
      
      </div>
    </div>
  </div>
<div>
<pre><b>A COIN         B COIN         C COIN         D COIN</b></pre>
<pre><span id="asd"></span>         <span id="bsd">          </span>          <span id="csd"></span>         <span id="dsd"></span></pre>
</div>




<div id="myCarousel" class="carousel slide carousel-fade" data-ride='carousel' data-interval='3000' data-pause="hover">
    <ol class="carousel-indicators" >
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
	 	<div class="container">
	 	<div class="carousel-caption">
	 	<figure class="highcharts-figure">
		<a id="aCoin" data-toggle="popover">
		<img alt="" src="coin/img/question-square.svg">
  		</a>
  		<div id="Acontainer"></div>
  		</figure>
		 </div>
        </div>
      </div>
      
      <div class="carousel-item"> 
        <div class="container">
	 	<div class="carousel-caption">
	 	<figure class="highcharts-figure">
		<a id="bCoin" data-toggle="popover">
		<img alt="" src="coin/img/question-square.svg">
  		</a>
  		<div id="Bcontainer"></div>
  		</figure>
		 </div>
        </div>
      </div>
      
      <div class="carousel-item">
        <div class="container">
	 	<div class="carousel-caption">
	 	<figure class="highcharts-figure">
		<a id="cCoin" data-toggle="popover">
		<img alt="" src="coin/img/question-square.svg">
  		</a>
  		<div id="Ccontainer"></div>
  		</figure>
		 </div>
        </div>
      </div>
      
       <div class="carousel-item">
        <div class="container">
          <div class="carousel-caption text-end">
            <figure class="highcharts-figure">
            <a id="dCoin" data-toggle="popover">
			<img alt="" src="coin/img/question-square.svg">
  			</a>
  			<div id="Dcontainer"></div>
  			</figure>
          </div>
        </div>
      </div>
    </div>
   
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden"></span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden"></span>
    </a>
  </div>
	<c:if test="${empty id}">
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#loginModalForm">
  	로그인후 구매
	</button>
	</c:if>
	<c:if test="${!empty id}">
	<button id="modalbutton" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">
  	구매하기
	</button>
	</c:if>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="resource/js/bootstrap.bundle.js"></script>
	<script type="text/javascript" src="resource/js/bootstrap.bundle.min.js"></script>		
	<script type="text/javascript" src="resource/js/popper.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="coin/graph.js"></script>	
</body>
<%@ include file="/include/footer.jsp" %>
</html>