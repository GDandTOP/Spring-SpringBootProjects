<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<head>
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
<center>
<h3>[ 회원정보 ]</h3>
<table border="1">
	<tr>
		<td><label>아이디</label></td>
		<td><label>${member.id }</label></td>
	</tr>
	<tr>
		<td><label>비밀번호</label></td>
		<td><label>${member.password }</label></td>
	</tr>
	<tr>
		<td><label>이름</label></td>
		<td><label>${member.name }</label></td>
	</tr>
	<tr>
		<td><label>성별</label></td>
		<td>
			<label>
			<c:choose>
				<c:when test="${member.sex=='male' }">남</c:when>
				<c:otherwise>여</c:otherwise>
			</c:choose>
			</label>
		</td>
	</tr>
	<tr>
		<td><label>나이</label></td>
		<td><label>${member.age }</label></td>
	</tr>
	<tr>
		<td><label for = "email">이메일주소 : </label></td>
		<td><label>${member.email }</label></td>
	</tr>
</table>
</center>
</body>