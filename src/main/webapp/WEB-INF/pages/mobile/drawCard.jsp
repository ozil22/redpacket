<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html lang="zh-cn">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/mobile/css/base.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/mobile/css/main.css">
  <title>抽奖记录</title>
</head>
<body>
<div class="header">
  <a href="#" onclick="history.back();">
    <img src="${pageContext.request.contextPath}/mobile/img/back.png" width="24">
  </a>
  <h1 class="title">抽奖结果</h1>
</div>
<div class="body">
  <div class="top">
    <div class="row">
      <div class="col start">
        <img class="img record" src="${pageContext.request.contextPath}/mobile/img/icon_z.png">
      </div>
      <div class="col end">
        <img class="img logo" src="${pageContext.request.contextPath}/mobile/img/logo.png">
      </div>
    </div>
  </div>
  <div class="word-box">
    <div class="word-wrap">
      <img src="${pageContext.request.contextPath}/mobile/img/small_bg.png">
      <span>${drawLog.cardName}</span>
    </div>
  </div>
  <div class="btn-wrap">
    <div class="btn-box">
        <a href="${pageContext.request.contextPath}/mobile/userInfo">
            <img src="${pageContext.request.contextPath}/mobile/img/btn_center_bg.png" width="100%">
            <span>领取</span>
        </a>
    </div>
  </div>
</div>
<script rel="script" type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
  $(function () {
  })
</script>
</body>
</html>