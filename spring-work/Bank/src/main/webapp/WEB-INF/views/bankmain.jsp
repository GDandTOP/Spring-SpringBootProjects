<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {margin: 0 auto;}
        th {
            background-color: lightcyan;
        }
        #title {
            height: 60px;
            background-color:navajowhite;
        }

    </style>
</head>
<body>
    <table style="width:800px;height: 400px;">
        <thead>
            <tr><th colspan="2" id="title">KT bank</th></tr>
            <tr><td colspan="2" id="title" style="height: 20px; text-align: right;">
            	<c:choose>
            		<c:when test="${session.id!= null} ">
            			<span>{session.id}님 반갑습니다.</span>
            			<a href="./logout" target="content">로그아웃</a>
            		</c:when>
	            	<c:otehrwise>
	            	    <a href="./login" target="content">로그인</a>
	            	</c:otehrwise>
            	</c:choose>
            

            	<a href="./join" target="content">회원가입</a>
            </td></tr>
        </thead>
        <tbody>
            <tr>
                <th><a href="./makeAccount" target="content">계좌개설</a><br><br>
                    <a href="./deposit" target="content">입금</a><br><br>
                    <a href="./withdraw" target="content">출금</a><br><br>
                    <a href="./accountInfo" target="content">계좌조회</a><br><br>
                    <a href="./allAccountInfo" target="content">전체 계좌 조회</a>
                </th>
                <td  style="width:70%;"><iframe style="width:100%;height:100%;align-content: center;" name="content"></iframe></td>
            </tr>
        </tbody>
    </table>
</body>
</html>