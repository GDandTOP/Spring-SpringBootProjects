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

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
		$(function() {
			$('#query').click(function() {
				let id = $('#id').val()
				if (id=='') {
					alert("계좌 입력하세요!")
					return;
				}
				
	        	$.ajax({
	        		type:"post",
	        		datatype:"text",
	        		async:false,
	        		url:"http://localhost:8080/bank/AccountInfo2",
	        		data:{id:id},
	        		success:function(data,textStatus) {
	        			console.log(data);
	        			$('#rid').val(data.id)
	        			$('#rname').val(data.name)
	        			$('#rbalance').val(data.balance)
	        			$('#rtype').val(data.type)
	        			if(!data.grade)
	        			{ 
	        				$('#rgrade').val("일반등급")
 	        			} 
	        			else $('#rgrade').val(data.grade)
	        		},
	        		error : function(err,textStatus,errorThrown){
		        		console.log("err : " , err)
		        		console.log("text : " , textStatus)
		        		console.log("thrown : " , errorThrown)

	        		}
	        	})
			})
		});
        
    </script>    
</head>

<body>
    <center>
        <div class="header">
            <h3>계좌조회</h3>
        </div>
        <div class="container">
            <form id='form' action="./AccountInfo" method="post">
                <div class="row">
                    <div class="title">계좌번호</div>
                    <div class="input"><input type="text" name="id" id="id"></div>
                </div>
                <div class="button">
                    <input type="button" id="query" value="조 회">
                </div>
            </form>
        </div>
        
        <div class="container" id="result">
            <table border="1">
				<tbody>
					<tr><td>계좌번호</td><td><input type="text" id="rid" readonly="readonly"/></td></tr>
					<tr><td>이름</td><td><input type="text" id="rname" readonly="readonly"/></td></tr>
					<tr><td>잔액</td><td><input type="text" id="rbalance" readonly="readonly"/></td></tr>
					<tr><td>계좌구분</td><td><input type="text" id="rtype" readonly="readonly"/></td></tr>
					<tr><td>등급</td><td><input type="text" id="rgrade" readonly="readonly"/></td></tr>
				</tbody>
			</table>
        </div>
	
        
    </center>
</body>
</html>