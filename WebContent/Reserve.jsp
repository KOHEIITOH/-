<%@ page import="java.util.Date" %>

<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ようこそ！</title>
    <style>
    p{font-family: 'Hiragino Kaku Gothic Pro','ヒラギノ角ゴ Pro W3','メイリオ',Meiryo,'ＭＳ Ｐゴシック',sans-serif; vertical-align: middle;}
      .img {width:300px; height:300px; float:left;}
      .hotel_info {float: right;}
      .header{ height: 25px; text-align: center;}
	  .glovalNavigation{height: 70px;text-align: center;}
	   main{ display: flex; min-height: 100vh; margin: 10px 0 10px 0;}
	  .content{flex: 1;background-color: #eee;text-align: center;margin-right: 10px;}
	  .localNavigation{margin-left:10px;text-align: center;width: 200px;}
	  .box17{ margin:2em 0; position: relative; padding: 0.5em 1.5em;border-top: solid 2px black;border-bottom: solid 2px black;}
	  .box17:before, .box17:after{content: ''; position: absolute;top: -10px; width: 2px; height: -webkit-calc(100% + 20px);height: calc(100% + 20px);background-color: black;}
	  .box17:before {left: 10px;}
	  .box17:after {right: 10px;}
	  .box17 p {margin: 0;padding: 0;}
	  .dot {border: none;background-color: #fff;border-width: 1px 0 0 0;border-top: dotted;border-color: #D2B48C;}
      .box25{position: relative;background: #fff0cd; box-shadow: 0px 0px 0px 5px #fff0cd; border: dashed 2px white; padding: 0.2em 0.5em; color: #454545;}
	  .box25:after{ position: absolute;content: ''; right: -7px; top: -7px;border-width: 0 15px 15px 0;border-style: solid;border-color: #ffdb88 #fff #ffdb88; box-shadow: -1px 1px 1px rgba(0, 0, 0, 0.15);}
	  .box25 p {margin: 10px; padding: 0;}
     </style>


</head>
<body>
   <header class="header content box17">
       	<p>UserID：${itemsa}</p>
    </header>

    <div class="glovalNavigation">
		<p>${itemsw} 宿の予約</p>
		<hr class="dot" noshade>
    </div>

    <main>

        <div>
		    <img src="${itemi}" class="img">
		</div>
          <div class="hotel_info box25">
<p>
          情報:${itemin}<br>
          住所:${itema}<br>
          値段:${itemp}<br>
          電話:${itemt}<br>
          meil:${iteme}<br>
</p>

        </div>

		<!--ローカルナビゲーション-->
        <div class="localNavigation">

	<form action="/Reserve/ReserveTopServlet" method="post">
宿予約ID：<input type="text" name="hotel_reserve_id" size="5"><br><br>
		  <input type="hidden" name="hotel_id" value="${items}"size="5">

Check In：<select name="checkin_date">
				<option value="9">9時
				<option value="10">10時
				<option value="11">11時
				<option value="12">12時
				<option value="13">13時
				<option value="14">14時
				<option value="15">15時
				<option value="16">16時
				<option value="17">17時
				<option value="18">18時
				<option value="19">19時
				<option value="20">20時
				<option value="21">21時
				<option value="22">22時
				<option value="23">23時
				<option value="24">24時
				<option value="1">1時
				<option value="2">2時
				<option value="3">3時
				<option value="4">4時
				<option value="5">5時
				<option value="6">6時
				<option value="7">7時
				<option value="8">8時
			</select><br><br>

		Check Out：	<select name="checkout_date">
				<option value="9">9時
				<option value="10">10時
				<option value="11">11時
				<option value="12">12時
				<option value="13">13時
				<option value="14">14時
				<option value="15">15時
				<option value="16">16時
				<option value="17">17時
				<option value="18">18時
				<option value="19">19時
				<option value="20">20時
				<option value="21">21時
				<option value="22">22時
				<option value="23">23時
				<option value="24">24時
				<option value="1">1時
				<option value="2">2時
				<option value="3">3時
				<option value="4">4時
				<option value="5">5時
				<option value="6">6時
				<option value="7">7時
				<option value="8">8時
			</select><br><br>


			<input type="hidden" name="user_id" value="${itemsa}"size="5">
		<input type="hidden" name="action" value="reserve_travel">
		<input type="submit" value="予約完了">
	</form>


</div>

    </main>

</body>
</html>