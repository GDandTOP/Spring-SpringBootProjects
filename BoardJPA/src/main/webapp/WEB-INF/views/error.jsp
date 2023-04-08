<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="/upload/logo.png">
<c:choose>
	<c:when test="${member==null }">
		<a href="/login">로그인</a>&nbsp;
		<a href="/join">회원가입</a>&nbsp;
	</c:when>
	<c:otherwise>
		<span>안녕하세요.${member.name }</span>
		<a href="/logout">로그아웃</a>&nbsp;
		<a href="/mypage">마이페이지</a>
	</c:otherwise>
</c:choose>
<a href="/boardlist">게시판</a><br><br>
<div>
	<h3>오류가 발생했습니다.</h3>
	<img src="/upload/error.jpg"/>
</div>
</body>
</html>