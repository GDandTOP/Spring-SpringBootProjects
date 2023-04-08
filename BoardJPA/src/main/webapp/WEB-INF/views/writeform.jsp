<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
h2 {
	text-align: center;
}
table {
	margin: auto;
	width: 450px;
}
.td_left {
	width: 150px;
	background: orange;
}
.td_right {
	width: 300px;
	background: skyblue;
}
#commandCell {
	text-align: center;
}
</style>
</head>
<body>
	<!-- 게시판 등록 -->
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
	<section id="./writeForm">
		<h2>게시판글등록</h2>
		<form action="./boardwrite" method="post"
			enctype="multipart/form-data" name="boardform">
			<table>
				<tr>
					<td class="td_left"><label for="writer">글쓴이</label></td>
					<td class="td_right"><input type="text" name="writer"
						id="writer" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="subject">제 목</label></td>
					<td class="td_right"><input name="subject" type="text"
						id="subject" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="content">내 용</label></td>
					<td><textarea id="content" name="content"
							cols="40" rows="15" required="required"></textarea></td>
				</tr>
				<tr>
					<td class="td_left"><label for="file"> 이미지 파일 첨부 </label></td>
					<td class="td_right"><input name="file" type="file"
						id="file" accept="image/*"/></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp; <input
					type="reset" value="다시쓰기" />
			</section>
		</form>
	</section>
	<!-- 게시판 등록 -->
</body>
</html>