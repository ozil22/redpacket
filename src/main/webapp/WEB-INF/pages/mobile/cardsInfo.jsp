<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${ad.title}</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">

<meta name="description"
	content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/mobile/lib/weui.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/mobile/css/jquery-weui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/mobile/css/base.css">
<script src="${pageContext.request.contextPath}/mobile/js/base.js"></script>
<script
	src="${pageContext.request.contextPath}/mobile/lib/jquery-2.1.4.js"></script>
<script src="${pageContext.request.contextPath}/mobile/lib/fastclick.js"></script>
<script
	src="${pageContext.request.contextPath}/mobile/js/jquery-weui.js"></script>
<script type="text/javascript">
	$(function() {
		var msg = $("#msg").val();
		if(msg){
			alert(msg);
			return;
		}
	})
</script>
</head>
<body ontouchstart>
	<input type="hidden" id="msg" value="${msg}">
	<div class="relative">
		<img src="images/bc.png" style="width: 100%">
		<h1 class="demos-title font">集卡说明</h1>
		<div class="demos-content-padded mtj100">
			<div class="box">
				<div class="top">集卡或现金红包啦</div>
				<div class="mid">${info}</div>
			</div>
		</div>
	</div>

</body>
</html>