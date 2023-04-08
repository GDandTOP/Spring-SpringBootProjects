
	$(document).ready(function() {
		var amount=$("#gAmount");
		$("#up").click(function(){
			var count=parseInt(amount.val().trim());
			amount.val(count+1);
		});
		$("#down").click(function(){
			var count=parseInt(amount.val().trim());			
			if(count!=1){
				amount.val(count-1);
				return;
			}			
		});
		
		var size=$("#gSize");
		var color=$("#gColor");
		
		$(document.forms[0]).submit(function(){
			if(size.val()=="사이즈선택" || color.val()=="색상선택"){
				alert("사이즈 또는 색상이 선택되지 않았습니다.");
				return false;
			}
		});
						
		
		$("#logoutBtn").click(function() {			
			location.href = "/shop/logout";	
			alert("로그아웃 되었습니다.");		
		});
		$("#myPageBtn").click(function() {
			location.href = "/shop/mypage";
		});
		$("#cartListBtn").click(function() {
			location.href = "/shop/cartList";
		});
		$("#mainBtn").click(function(){
			location.href="/shop/main";
		});
	});
	