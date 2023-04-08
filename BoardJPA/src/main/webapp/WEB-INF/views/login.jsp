<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
    
<!DOCTYPE html>
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
<form action="/login" method="post" id="login">
	<h3>[ 로그인 ]</h3>
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" id="login_id" /></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" id="login_pass" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="로그인" /></td>
		</tr>
	</table>
</form>
</center>