<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>구매 내역</title>
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
<script> 
$(function () { 
   $('#datetimepicker1').datetimepicker({ 
	  format: 'L',
	  format: 'YYYY-MM-DD'
	  });
   $('#datetimepicker2').datetimepicker({ 
	  format: 'L', 
	  format: 'YYYY-MM-DD',
      useCurrent: false 
      }); 
   $("#datetimepicker1").on("change.datetimepicker", function (e) {
      $('#datetimepicker2').datetimepicker('minDate', e.date); 
      });
   $("#datetimepicker2").on("change.datetimepicker", function (e) {
      $('#datetimepicker1').datetimepicker('maxDate', e.date); 
      });
   });
</script>
<script type="text/javascript">
function getInputValue(){
	var day1 = $('input[name=startday]').val();
	var day2 = $('input[name=endday]').val();
	var startday = day1.substring(0,4)+day1.substring(5,7)+day1.substring(8,10);
	var endday = day2.substring(0,4)+day2.substring(5,7)+day2.substring(8,10);
	location.href="receipt?cmd=receipt_search&startday="+startday+"&endday="+endday;
	submit();
}
</script>
</head>
<body>
   <a href="index"><img src="resource/img/indexcoin.jpg" width="180px"
      height="45px"></a><br>
     <img class="mt-3 mb-3" src="resource/img/구매내역.png" width="140px" height="50px">
   <form name="search" action="" method="post">
   <nav class="d-flex p-2 bd-highlight">
      <div class='col-md-2 col-xs-4'>
         <div class="form-group" >
            <div class="input-group date" id="datetimepicker1"
               data-target-input="nearest">
               <input name="startday" type="text" class="form-control datetimepicker-input"
                  data-target="#datetimepicker1" value="${startday }">
               <div class="input-group-append" data-target="#datetimepicker1"
                  data-toggle="datetimepicker">
                  <div class="input-group-text">
                     <i class="fa fa-calendar"></i>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <h3>~</h3>
      <div class='col-md-2 col-xs-4'>
         <div class="form-group">
            <div class="input-group date" id="datetimepicker2"
               data-target-input="nearest">
               <input name="endday" type="text" class="form-control datetimepicker-input"
                  data-target="#datetimepicker2" value="${endday }">
               <div class="input-group-append" data-target="#datetimepicker2"
                  data-toggle="datetimepicker">
                  <div class="input-group-text">
                     <i class="fa fa-calendar"></i>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <div class="form-group">
      <button type="button" class="col-xs-4 btn btn-outline-primary" style="display: inline-table;" onClick="getInputValue();">검색</button>
      </div>
   </nav>
   </form>
   <div align="left">
   <small style="color: gray">*내역은 페이지당 20개씩 보여집니다</small>
   </div>
   <table class="table table-sm">
      <thead>
         <tr>               
            <th scope="col" width="15%">CoinKinds</th>
            <th scope="col" width="15%">Sell</th>
            <th scope="col" width="15%">Buy</th>
            <th scope="col" width="15%">Date</th>
            <th scope="col" width="15%">Price</th>
            <th scope="col" width="15%">총재산</th>                     
         </tr>
      </thead>
      <tbody>
         <c:forEach var="vo" items="${vo}">
            <tr>
               <th>${vo.name.substring(0,1)}코인</th>
               <c:choose>
               <c:when test="${vo.count < 0}">
                  <th>${vo.count}개</th>
                  <th></th>
               </c:when>
               <c:otherwise>
                  <th></th>
                  <th>+${vo.count}개</th>
               </c:otherwise>
               </c:choose>
               <th>${vo.regdate.substring(2,4)}/${vo.regdate.substring(5,7)}/${vo.regdate.substring(8,10)}
               ${vo.regdate.substring(11,13)}:${vo.regdate.substring(14,19)}</th>
               <th><fmt:formatNumber value="${vo.price}" pattern="#,###,###,###"/>원</th>
               <th><fmt:formatNumber value="${vo.money}" pattern="#,###,###,###"/>원</th>
            </tr>
         </c:forEach>
         <c:if test="${empty vo}">
         	<tr>
            	<th colspan=6>내역이 없습니다</th>
            </tr>
         </c:if>
      </tbody>
   </table>

      <ul class="pagination justify-content-end mb-0">
      <c:choose>
         <c:when test="${currentPage==1 }">
            <li class="page-item disabled"><a class="page-link"
               href="receipt?cmd=receipt_list&page=${currentPage-1}" tabindex="-1"
               aria-disabled="true">Previous</a></li>
         </c:when>
         <c:when test="${currentPage!=1 }">
            <li class="page-item"><a class="page-link"
               href="receipt?cmd=receipt_list&page=${currentPage-1}">Previous</a></li>
         </c:when>
      </c:choose>
      <c:forEach var="a" begin="1" end="${totpage }" step="1">
         <li class="page-item"><a class="page-link" href="receipt?cmd=receipt_list&page=${a}">${a}</a></li>
      </c:forEach>
      <c:if test="${currentPage == totpage }">
         <li class="page-item disabled"><a class="page-link"
            href="receipt?cmd=receipt_list&page=${currentPage+1}">Next</a></li>
      </c:if>
      <c:if test="${currentPage != totpage }">
         <li class="page-item"><a class="page-link"
            href="receipt?cmd=receipt_list&page=${currentPage+1}">Next</a></li>
      </c:if>
   </ul>
      <br>
      <div class="md-form pb-3" align="center">
         <a class="btn btn-outline-primary" href="#" onClick="javascript:window.scrollTo(0,0)">맨 위로</a>
      </div>
</body>
<%@ include file="/include/footer.jsp"%>
</html>