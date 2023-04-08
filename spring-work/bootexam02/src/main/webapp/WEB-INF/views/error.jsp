<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 페이지 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
<script type="text/javascript">
	function go_list(){
		location.href="list";
	}
</script>	
</head>
<body>
	<div class="container">
		
		<form class="form-horizontal" action="write" method="post">
			<div class="form-group">
				<div class="col-sm-10" >
						<a href="home"><img src="resources/images/ktds.png"></a>
				</div>
				<div class="col-sm-10" >
					<a href="login" class="text-center">로그인</a>
					<a href="memberAdd" class="text-center">회원가입</a>
					<a href="" class="text-center">QnA</a>
				</div>
		
			</div>
			<div class="form-group">
				<div class="col-sm-10" >
                	<img src="resources/images/error.png">
				</div>
			</div>
			
		</form>
		
	</div>
</body>
</html>