
	$(document).ready(function() {
		var amount=$("#gAmount");
		$("#up").click(function(){
			
			/*  상품상세화면에서 수량 증가 JS 구현
			 *
			 *
			 */
			
		});
		$("#down").click(function(){
		
		
			/*  상품상세화면에서 수량 감소 JS 구현 ( 최소값은 항상 1 )
			 *
			 *
			 */	
		});
		
		var size=$("#gSize");
		var color=$("#gColor");
		
		$(document.forms[0]).submit(function(){
			if(size.val()=="사이즈선택" || color.val()=="색상선택"){
				alert("사이즈 또는 색상이 선택되지 않았습니다.");
				return false;
			}
		});
						
		$("#order").click(function(){
			var frm=$(document.forms[0]);
			frm.attr("action", "orderConfirm");			
			frm.submit();
			
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
	