<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Successfully deleted</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {

		//擦除效果
		jQuery.extend(jQuery.easing, {
			easeOutBack : function(x, t, b, c, d, s) {
				s = s || 1.3;
				return c * ((t = t / d - 1) * t * ((s + 1) * t + s) + 1) + b;
			}
		});

		//nav初始化选中
		var navCurr = $("#navCurr");
		$("#navSelected").css("left", navCurr[0].offsetLeft);

		//nav里的链接hover效果
		$("#navBd li").hover(
				function() {
					if (!!$("#navSelected").stop(true).animate({
						left : $(this)[0].offsetLeft
					}, 400, "easeOutBack")) {
						$(this).siblings().removeClass("navHover").end()
								.addClass("navHover");
						$(this).find("a").hide().fadeIn(300);
					}

				}, function() {
					$(this).removeClass("navHover");
					$("#navCurr").addClass("navHover");
					//window.setTimeout(function(){$("#navCurr").parent().addClass("navHover")},100);
					$("#navSelected").stop(true).animate({
						left : navCurr[0].offsetLeft
					}, 300, "easeOutBack");
				});

	})
</script>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
	list-style-type: none;
}

a, img {
	border: 0;
	text-decoration: none;
	color: #333;
}

body {
	font: 12px/180% Arial, Helvetica, sans-serif, "新宋体";
	background-image: url("bgp.png");
	background-size: 100%;
	background-attachment: fixed;
	text-align: center;
}

h2 {
	color: white;
}

p {
	font-size: 20px;
	margin-top: 90px;
	font-family: times new roman;
}

.clearfix:after {
	visibility: hidden;
	display: block;
	clear: both;
	height: 0;
	font-size: 0;
	content: ".";
}

.clearfix {
	zoom: 1;
}

.image {
	border: 2px solid darkgrey;
	width: auto;
	height: auto;
	float: left;
	text-align: center;
	padding: 5px;
}

img {
	padding: 5px;
	opacity: 0.8;
	margin-left: 50px;
}

.nav {
	position: relative;
	width: 700px;
	height: 38px;
	overflow: hidden;
	line-height: 38px;
	font-size: 14px;
	margin: 40px auto 0 auto;
}

.nav li {
	float: left;
	display: inline;
	width: 100px;
	height: 39px;
	line-height: 33px;
	text-align: center;
}

.nav a:hover {
	text-decoration: none;
}

#navBd {
	position: relative;
}

.navHover a {
	display: inline-block;
	color: #fff;
}

#navSelected {
	position: absolute;
	top: 0;
	width: 100px;
	height: 39px;
	line-height: 33px;
	background: url(images/header.png) no-repeat 0 0;
}
</style>
</head>
<body>
	<div class="nav">
		<div id="navSelected" class="navSelected"></div>
		<ul id="navBd" class="clearfix">
			<li id="navCurr" class="navHover"><a href="index.html"> Home
					page </a></li>
			<li><a href="searchAuthor.jsp">Search author</a></li>
			<li><a href="booklist"> All books </a></li>
			<li><a href="add.jsp"> Add a book </a></li>
			<li><a href="contact.jsp"> Contact me </a></li>
		</ul>
	</div>
	<h2>The book has been removed from the library.</h2>
	<a href="index.html">Return to home page</a>
</body>
</html>