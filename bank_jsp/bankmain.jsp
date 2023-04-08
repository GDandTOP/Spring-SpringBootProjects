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
            <tr><th colspan="2" id="title">멀캠은행</th></tr>
        </thead>
        <tbody>
            <tr>
                <th><a href="makeAccount.html" target="content">계좌개설</a><br><br>
                    <a href="deposit.html" target="content">입금</a><br><br>
                    <a href="withdraw.html" target="content">출금</a><br><br>
                    <a href="accountInfo.html" target="content">계좌조회</a><br><br>
                    <a href="allAccountInfo.html" target="content">전체 계좌 조회</a>
                </th>
                <td  style="width:70%;"><iframe style="width:100%;height:100%;align-content: center;" name="content"></iframe></td>
            </tr>
        </tbody>
    </table>
</body>
</html>