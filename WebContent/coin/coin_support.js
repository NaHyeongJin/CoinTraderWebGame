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
      if (totcoincnt == "") {
        return $(".form-text").text("수량을 확인해주세요");
      }
      if (money < reprice) {
        return $(".form-text").text("자산을 초과하였습니다.");
      }

      $("#rrr2").text("구입시 고객님의 남은 자산 :" + chk + "원");
      $("#rrr2").css("color", "red");
      $("#myModal").modal("hide");
      $("#myModal2").modal("show");
      $(".form-text").text("");
      $("#floatingInputValue").val(totprice + "  코인개수:" + totcoincnt);
      $("#coincnt2").val(totcoincnt);
      return "판매시 시간을 정하여 판매를 눌러주세요 정한시간뒤에 가격으로 판매가 됩니다";
    },
  });
});

$("#sellbutton").on("click", function () {
  var coinname = $("#coinname").val();
  timer = $("#selltime").val();

  var asellprice = $("#Asellpriceinput").val();
  var bsellprice = $("#Bsellpriceinput").val();
  var csellprice = $("#Csellpriceinput").val();
  var dsellprice = $("#Dsellpriceinput").val();

  if (timer == 0) {
    $(".form-text").css("color", "red");
    return $(".form-text").text("판매할시간을 선택해주세요");
  }

  if (coinname.indexOf("A") !== -1) {
    cnt = 1;
    $("#sellpriceinput").val(asellprice);
    sellprice = $("#sellpriceinput").val();
  } else if (coinname.indexOf("B") !== -1) {
    cnt = 2;
    $("#sellpriceinput").val(bsellprice);
    sellprice = $("#sellpriceinput").val();
  } else if (coinname.indexOf("C") !== -1) {
    cnt = 3;
    $("#sellpriceinput").val(csellprice);
    sellprice = $("#sellpriceinput").val();
  } else if (coinname.indexOf("D") !== -1) {
    cnt = 4;
    $("#sellpriceinput").val(dsellprice);
    sellprice = $("#sellpriceinput").val();
  }

  $("#myModal2").modal("hide");
  CoinBuy();
  CoinSell();
  $("#rrr2").text("");
  $("#coincnt").val("");
  $(".form-text").text("");
  $("#coinname").css("background-position", "100px 6px");
  $("#coinname").val("코인을 선택해주세요");
  $(".dropdown-toggle").text("코인");
  $("#floatingInputValue").val("");
  $("#coincnt2").val("");
});

function cntkey(price) {
  $("#coincnt").on("keyup", function (e) {
    //코인개수 구입시 경고문삭제
    var money = $("#prmoney").val();
    var totcoincnt = $("#coincnt").val();

    var totprice = price * totcoincnt;
    var my = money - totprice;

    $("#rrr").text("내 자산 :" + my);

    if (money < totprice) {
      return $(".form-text").text("자산을 초과하였습니다.");
    }
    if (totcoincnt == "") {
      $("#rrr").text("내 자산 :" + money);
    }
  });

  $("#modalbutton").on("click", function () {
    //구입버튼 모달
    $("#myModal").modal("show");
    var money = $("#prmoney").val();
    $("#rrr").text("내 자산 :" + money);
  });

  function pricechk(price) {
    $("#modalbutton2").on("click", function () {
      //판매버튼 모달
      $("#priceinput").val(priceinput);
      var totprice = $("#coinname").val();
      var totcoincnt = $("#coincnt").val();
      var money = $("#prmoney").val();

      var reprice = price * totcoincnt;
      var chk = money - reprice;
      if (totprice == "") {
        return $(".form-text").text("코인을 선택해주세요");
      }
      if (totcoincnt == "") {
        return $(".form-text").text("수량을 확인해주세요");
      }
      if (money < reprice) {
        return $(".form-text").text("자산을 초과하였습니다.");
      }
      $("#rrr2").text("구입시 고객님의 남은 자산 :" + chk + "원");
      $("#rrr2").css("color", "red");
      $("#myModal").modal("hide");
      $("#myModal2").modal("show");
      $(".form-text").text("");
      $("#floatingInputValue").val(totprice + "  코인개수:" + totcoincnt);
      $("#coincnt2").val(totcoincnt);
    });
  }

  function cntkey(price) {
    $("#coincnt").on("keyup", function (e) {
      //코인개수 구입시 경고문삭제
      var money = $("#prmoney").val();
      var totcoincnt = $("#coincnt").val();

      var totprice = price * totcoincnt;
      var my = money - totprice;

      $("#rrr").text("내 자산 :" + my);

      if (money < totprice) {
        return $(".form-text").text("자산을 초과하였습니다.");
      }
      if (totcoincnt == "") {
        $("#rrr").text("내 자산 :" + money);
      }
      $(".form-text").text("");
    });
  }
  $("#closemodalbutton1,#closemodalbutton2").on("click", function () {
    //구입모달 x/닫기버튼
    $("#myModal").modal("hide");
    $("#coinname").css("background-position", "100px 6px");
    $("#coinname").val("코인을 선택해주세요");
    $(".dropdown-toggle").text("코인");
    $("#coincnt").val("");
    $(".form-text").text("");
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
  $("#aprice").click(function () {
    $(".form-text").text("");
    var money = $("#prmoney").val();
    $("#rrr").text("내 자산 :" + money);
    $("#coincnt").val("");
    var apr = $("#Apriceinput").val();
    $("#coinname").css("background-position", "125px 5px");
    $("#coinname").val("A코인:" + $("#Apriceinput").val() + "원");
    cntkey(apr);
    pricechk(apr);
  });
  $("#3sc").click(function () {
    $("#selltime").val(3);
  });
  $("#bprice").click(function () {
    $(".form-text").text("");
    var money = $("#prmoney").val();
    $("#rrr").text("내 자산 :" + money);
    $("#coincnt").val("");
    var bpr = $("#Bpriceinput").val();
    $("#coinname").css("background-position", "125px 6px");
    $("#coinname").val("B코인:" + $("#Bpriceinput").val() + "원");
    cntkey(bpr);
    pricechk(bpr);
  });
  $("#5sc").click(function () {
    $("#selltime").val(5);
  });
  $("#cprice").click(function () {
    $(".form-text").text("");
    var money = $("#prmoney").val();
    $("#rrr").text("내 자산 :" + money);
    $("#coincnt").val("");
    var cpr = $("#Cpriceinput").val();
    $("#coinname").css("background-position", "125px 6px");
    $("#coinname").val("C코인:" + $("#Cpriceinput").val() + "원");
    cntkey(cpr);
    pricechk(cpr);
  });
  $("#7sc").click(function () {
    $("#selltime").val(7);
  });
  $("#dprice").click(function () {
    $(".form-text").text("");
    var money = $("#prmoney").val();
    $("#rrr").text("내 자산 :" + money);
    $("#coincnt").val("");
    var dpr = $("#Dpriceinput").val();
    $("#coinname").css("background-position", "125px 6px");
    $("#coinname").val("D코인:" + $("#Dpriceinput").val() + "원");
    cntkey(dpr);
    pricechk(dpr);
  });
  $("#10sc").click(function () {
    $("#selltime").val(10);
  });
}
