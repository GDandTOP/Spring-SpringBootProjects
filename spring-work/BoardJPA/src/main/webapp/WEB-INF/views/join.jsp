<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
    
<!DOCTYPE html>
<head>
   <script src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script>
   $(function() {
	  $("#doubleid").click(function() {
      	let id = $("#id").val();
    	if(id=='') {
    		alert("아이디를 입력하세요.")
    		return;
    	}
    	
    	$.ajax({
    		type:"post",
    		async:false,
    		url:"/doubleid",
    		data:{id:id},
    		success:function(data,textStatus) {
    			console.log(data);
    			if(data==true) {
    				$("#msg").text("사용 불가능 합니다.");
    			} else {
    				$("#msg").text("사용 가능 합니다.");
    			}
    		}        		
    	});
	  })	  
   });
   </script>
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
<h3>[ 회원정보 입력 ]</h3>
<form action="/join" method="post">
<table border="1">
	<tr>
		<td rowspan="2"><label for = "id">아이디 : </label></td>
		<td><input type="text" name="id" id = "id"></td>
	</tr>
	<tr>
		<td><input type="button" id="doubleid" value="중복확인"/><label id="msg"></label></td>
	</tr>	
	<tr>
		<td><label for = "pass">비밀번호 : </label></td>
		<td><input type="password" name="password" id = "password"></td>
	</tr>
	<tr>
		<td><label for = "name">이름 : </label></td>
		<td><input type="text" name="name" id = "name"></td>
	</tr>
	<tr>
		<td><label for = "sex">성별 : </label></td>
		<td>
			<input type="radio" name="sex" value="male" id = "sex" checked>남
			<input type="radio" name="sex" value="female">여
		</td>
	</tr>
	<tr>
		<td><label for = "age">나이 : </label></td>
		<td><input type="text" name="age" id = "age"></td>
	</tr>
	<tr>
		<td><label for = "email">이메일주소 : </label></td>
		<td><input type="text" name="email" id = "email"></td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input type="submit" value="가입">
			<input type="reset" value="다시 작성">
		</td>
	</tr>
</table>
</form>
</center>
</body>