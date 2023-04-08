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
            width: 380px;
        }

        .container {
            padding:10px;
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

        input[type='submit'] {
            font-weight: bold;
            width:120px;
            background-color: lightgrey;
        }
    </style>
</head>

<body>
    <center>
        <form action="./makeAccount" method="post">
            <div class="header">
                <h3>계좌개설</h3>
            </div>
            <div class="container">
                <div class="row">
                    <div class="title">계좌번호</div>
                    <div class="input">
                    	<input type="text" name="id" id='id'>
                    	<input type="button" id="doubleid" value="버튼">
                    </div>
                </div>
                <div class="row">
                    <div class="title">이름</div>
                    <div class="input"><input type="text" name="name" id='name'></div>
                </div>
                <div class="row">
                    <div class="title">입금액</div>
                    <div class="input"><input type="text" name="balance" id='balance'></div>
                </div>
                <div class="row">
                    <div class="title">종류</div>
                    <div class="input">
                        <input type="radio" name="type" value="normal" checked>일반
                        <input type="radio" name="type" value="special">특수
                    </div>
                </div>
                <div class="row">
                    <div class="title">등급</div>
                    <div class="input">
                        <select disabled name="grade" id='grade'>
                            <option>VIP</option>
                            <option>Gold</option>
                            <option>Silver</option>
                            <option>Normal</option>
                        </select>
                    </div>
                </div>
                <div class="button">
                    <input type="submit" value="개 설"></button>
                </div>
            </div>
        </form>
    </center>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $('input[type="radio"]').change(function() {
            let type = $('input[type="radio"]:checked').val();
            if(type=='special') {
                $('select').attr('disabled',false);
            } else {
                $('select').attr('disabled',true);
            }
        });
        
        $('#doubleid').click(function() {
        	let id = $("#id").val();
        	if(id=='') {
        		alert("아이디를 입력하세요");
        		return;
        	}
        	
        	$.ajax({
        		type:"post",
        		datatype:"text",
        		async:false,
        		url:"http://localhost:8080/bank/doubleid",
        		data:{id:id},
        		success:function(data,textStatus) {
        			if(data==true) {
        				alert("사용 불가능 합니다.");
        			} else{
        				alert("사용 가능 합니다.");
        			}
        		}
        	})
        	
        })
        
    </script>    
</body>
</html>