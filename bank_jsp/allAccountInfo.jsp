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
            width: 552px;
        }

        .container {
            /* padding:10px; */
            border: 1px solid;
        }
        .header {
            height: 40px;
        }

        .row {
            height: 30px;
        }

        .title {
            font-weight: bold;
            background-color: lightgrey;
        }
        .colume {
            padding:5px;
            width: 100px;
            float: left;
        }

        .input {
            float: left;
        }
    </style>
</head>

<body>
    <center>
        <form>
            <div class="header">
                <h3>전체 계좌 조회</h3>
            </div>
            <div class="container" id="container">
                <div class="row">
                    <div class="title colume">계좌번호</div>
                    <div class="title colume">이름</div>
                    <div class="title colume">잔액</div>
                    <div class="title colume">계좌종류</div>
                    <div class="title colume">등급</div>
                </div>
            </div>
        </form>
    </center>
</body>
</html>