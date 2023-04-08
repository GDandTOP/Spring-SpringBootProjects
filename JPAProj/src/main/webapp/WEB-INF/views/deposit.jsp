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
        body {
            margin: 0 auto;
            width: 280px;
        }

        .container {
            padding: 10px;
            border: 1px solid;
        }

        .header {
            height: 40px;
        }

        .row {
            height: 30px;
        }

        .title {
            width: 70px;
            float: left;
            font-weight: bold;
        }

        .input {
            float: left;
        }

    </style>
</head>

<body>
    <center>
        <div class="header">
            <h3>입 금</h3>
        </div>
        <div class="container" id='deposit'>
            <form id='form' action="./deposit" method="post">
                <div class="row">
                    <div class="title">계좌번호</div>
                    <div class="input"><input type="text" name="id"></div>
                </div>
                <div class="row">
                    <div class="title">입금액</div>
                    <div class="input"><input type="text" name="money"></div>
                </div>
                <div class="button">
                    <input type="submit" value="입 금">
                </div>
            </form>
        </div>
    </center>  
</body>
</html>