<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KT ds Mall</title>
<link rel="stylesheet" href="<c:url value="/css/shopMain.css"/>">
<script src="<c:url value="/js/jquery-3.3.1.js"/>"></script>
<script src="<c:url value="/js/shopMain.js"/>"></script>
<c:if test="${empty user}">
	<script>
		alert("임직원 전용입니다. 로그인 페이지로 이동합니다.");
		location.href="/shop";
	</script>
</c:if>
</head>
<body>
<header>
	<h1>KT ds Mall에 오신 것을 환영합니다.</h1>
	<div class="menu">
		<a id="logoutBtn">로그아웃</a>
		<a id="myPageBtn">회원정보</a>
		<a id="cartListBtn">장바구니</a>
		<a id="orderListBtn">주문목록</a>		
	</div>	
</header>
<div class="goods">
	<ul class="tabs">
		<li id="top">TOP</li>
		<li id="dress">DRESS</li>
		<li id="outer">OUTER</li>
		<li id="bottom">BOTTOM</li>		
	</ul>
</div>
</body>
</html>