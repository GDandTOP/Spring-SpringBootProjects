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
<center>
<h3>[ 계좌 조회 ]</h3>
<table border="1">
	<tbody>
		<tr><td>계좌번호</td><td>${acc.id }</td>
		<tr><td>이름</td><td>${acc.name }</td>
		<tr><td>잔액</td><td>${acc.balance }</td>
		<tr><td>계좌구분</td><td>${acc.type }</td>
		<c:if test="{acc.type=='special'">
			<tr><td>등급</td><td>${acc.grade }</td>
		</c:if>			
	</tbody>
</table>
</center>
</body>
</html>