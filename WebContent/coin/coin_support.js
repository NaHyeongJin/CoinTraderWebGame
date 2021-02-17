$(function () {

  $("#aCoin").popover({
    //팝오버
    animation: true,
    placement: "right",
    trigger: "hover focus",
    html: true,
    content: function () {
      return "A COIN - 상승 하락폭이 B 코인에 비해 현저히 낮은 코인";
    },
  });
  $("#sellCoin").popover({
    animation: true,
    placement: "right",
    trigger: "hover focus",
    html: true,
    content: function () {
      return "판매시 시간을 정하여 판매를 눌러주세요 정한시간뒤에 가격으로 판매가 됩니다";
    },
  });
  $("#bCoin").popover({
    animation: true,
    placement: "right",
    trigger: "hover focus",
    html: true,
    content: function () {
      return "B COIN - 상승,하락폭이 큰 코인";
    },
  });
  $("#cCoin").popover({
    animation: true,
    placement: "right",
    trigger: "hover focus",
    html: true,
    content: function () {
      return "C COIN - 상승폭이 작은 대신 상승 확률이 높고 하락시 폭락하는 코인";
    },
  });
  $("#dCoin").popover({
    animation: true,
    placement: "right",
    trigger: "hover focus",
    html: true,
    content: function () {
      return "D COIN - 하락폭이 작지만 하락확률이 높고 상승시 대박을 치는 코인";
    },
  });

  $("#buyCoin").popover({
    animation: true,
    placement: "right",
    trigger: "hover focus",
    html: true,
    content: function () {
      return "코인 구매시 반드시 팔아야 합니다 결정후 구매버튼을 눌러주세요";
    },
  });

  $("#flexCheckDefault").change(function () {
    if ($(this).is(":checked")) {
      $(this).val(1);
      $(".form-text").text("");
    } else {
      $(this).val(0);
    }
  });
  
  $(".dropdown-menu li a").click(function () {
    //모달창 버튼 클릭 쿼리
    $("#coinname").css("background-position", "100px 6px");
    var selText = $(this).html();
    $(this)
      .parents(".btn-group")
      .find(".dropdown-toggle")
      .html(selText + ' <span class="caret"></span>');
  });
  $("#3sc").click(function () {
    $("#selltime").val(3);
  });
  $("#5sc").click(function () {
    $("#selltime").val(5);
  });
  $("#7sc").click(function () {
    $("#selltime").val(7);
  });
  $("#10sc").click(function () {
    $("#selltime").val(10);
  });
});
