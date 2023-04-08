$(document).ready(function(){

    	 //수정버튼
        $(".updateBtn").on("click",function(){
           	var num= $(this).attr("data-xxx");
        	var gAmount = $("#cartAmount"+num).val();
        	var gPrice= $(this).attr("data-price");
        	$.ajax({
        		url:'cartUpdate',
        		type:'get',
        		dataType:'text',
        		data:{
        			num:num,
        			gAmount:gAmount
        		},
        		success:function(data,status,xhr){
        			var sum=gAmount*gPrice;
        			$("#sum"+num).text(sum+"원");
        			alert("수량을 수정하였습니다.");
        		},
        		error:function(xhr,status,error){
        			
        		}
        	});//end ajaxgkgk
        });
    	 
        //삭제버튼
        $(".delBtn").on("click",function(){
        	var num= $(this).attr("data-xxx");
        	var xxx = $(this);
        	$.ajax({
        		url:'cartDelete',
        		type:'get',
        		dataType:'text',
        		data:{
        			num:num
        		},
        		success:function(data,status,xhr){
        			//현재 선택한 레코드의 부모태그 찾기
        			xxx.parents().filter("tr").remove();        			
        			var itemCount=$(".items").length;
        			if(itemCount>0){
        				alert("상품을 삭제하였습니다.");
        			}else{
						alert("상품을 삭제하였습니다. 장바구니가 비어 메인화면으로 이동합니다.");
						location.href="/shop/main";	
					}
        		},
        		error:function(xhr,status,error){
        			
        		}
        	});//end ajaxgkgk
        });
 
        $("#mainBtn").click(function(){
			location.href="/shop/main";
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
		
		
        //전체선택
        $("#allCheck").on("click",function(){
        	var result = this.checked;
        	$(".check").each(function(idx,data){
        		this.checked=result;
        	});
        });
        
       
        $("#delAllCart").on("click",function(){
        	
        	$("form").attr("action", "CartDelAll");
        	$("form").submit();// trigger
        });
        
       
        $(".orderBtn").on("click",function(){
        	var num= $(this).attr("data-xxx");
        	location.href="cartOrderConfirm?num="+num;
        });
     
        $("#orderAllConfirm").on("click",function(){
        	$("form").attr("action", "cartOrderAllConfirm");
        	$("form").submit();// trigger
        });
   });