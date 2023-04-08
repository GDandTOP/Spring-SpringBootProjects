<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KT ds Mall</title>
<link rel="stylesheet" href="<c:url value="/css/orderAllConfirm.css"/>">
<!-- jQuery  $ Daum 주소 API -->
<script type="text/javascript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="<c:url value="/js/jquery-3.3.1.js"/>"></script>
<script src="<c:url value="/js/orderAllConfirm.js"/>"></script>
<c:if test="${empty user}">
	<script>
		alert("임직원 전용입니다. 로그인 페이지로 이동합니다.");
		location.href = "/shop";
	</script>
</c:if>
</head>
<body>
	<header>
			<h1>KT ds Mall 주문확인</h1>
			<div class="menu">
				<a id="logoutBtn">로그아웃</a>
				<a id="myPageBtn">회원정보</a>
				<a id="cartListBtn">장바구니</a>				
			</div>
	</header>
	<div class="order">	
		<form name="myForm" method="get" action="cartOrderAllDone">
		<table>
			<tr>
				<td>
				<table>
					<tr>
						<th></th>
						<th>상품정보</th>
						<th>판매가</th>
						<th>수량</th>						
					</tr>
				</table>
				
					<input type="hidden" id="mname" maxlength="20" value="${user.username}">
					<input type="hidden" id="mpost" maxlength="6" value="${user.post}" readonly>
					<input type="hidden" id="maddress1" maxlength="200" value="${user.addr1}" readonly>
					<input type="hidden" id="maddress2" maxlength="200" value="${user.addr2}" readonly>
					<input type="hidden" id="mphone" maxlength="15" value="${user.phone1}-${user.phone2}-${user.phone3}">
					
					<c:set var="totalPrice" value="0"/>
					<c:forEach var="item" items="${cartList}">						
						<input type="hidden" name="num" value="${item.num}">
						<c:set var="totalPrice" value="${item.gPrice * item.gAmount + totalPrice }"/>
									
						<table>							
							<tr>
								<td><img src="images/items/${item.gImage}.gif"></td>
								<td>${item.gName}[옵션: 사이즈(${item.gSize}), 색상(${item.gColor})]</td>
								<td>${item.gPrice}</td>
								<td>${item.gAmount}</td>
							</tr>							
						</table>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th id="totalPrice">총 결제금액: ${totalPrice }</th>
			</tr>
					<!--  고객 정보 시작-->
					<tr>
						<th>고객 정보</th>
					</tr>
					<tr>
						<td>
							<table>
							<colgroup>
								<col style="width: 20%;">
								<col style="width: 80%;">
							</colgroup>
							<tbody>
								<tr>
									<td>이 름</td>
									<td>${user.username}</td>
								</tr>
								<tr>
									<td>우편번호</td>
									<td>${user.post}</td>
								</tr>
								<tr>
									<td>주 소</td>
									<td>${user.addr1} ${user.addr2}
									</td>
								</tr>
								<tr>
									<td>휴대전화</td>
									<td>${user.phone1}-${user.phone2}-${user.phone3}</td>
								</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<!--  고객 정보 끝-->
					<tr>
						<td> <input type="checkbox" name="same" id="same">배송지가 동일할 경우 선택하세요.</td>
					</tr>
					<!--  배송지 정보 시작-->
					<tr>
						<th>배송지 정보</th>
					</tr>
					<tr>
						<td>
							<table>
							<colgroup>
								<col style="width: 20%;">
								<col style="width: 80%;">
							</colgroup>
							<tbody>
								<tr>
									<th>이 름</th>
									<td>
										<input type="text" id="orderName" name="orderName" maxlength="20" required>
									</td>
								</tr>
								<tr>
									<th>주 소</th>
										<td>
											<input type="text" name="post" id="postcode" placeholder="우편번호" required>
											<button type="button" id="calldaumPostCode">우편번호검색</button><br>
											<input type="text" class="addr" name="addr1" id="address" placeholder="주소" required><br>				
											<input type="text" class="addr" name="addr2" id="detailAddress" placeholder="상세 주소">
										</td>
								</tr>
								<tr>
									<th>휴대전화</th>
									<td>
										<input type="text" id="phone" name="phone" maxlength="15" value="">
									</td>
								</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<!--  배송지 정보 끝-->
					<tr>
						<td><b>결제수단</b></td>
					</tr>
					<tr>
						<td>
							<table>
								<tr>
									<td>
										<input type="radio" name="payMethod" value="신용카드" checked>신용카드
										<input type="radio" name="payMethod" value="계좌이체">계좌이체
										<input type="radio" name="payMethod" value="무통장 입금">무통장 입금
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>
						<div id="btnBox">
							<button type='button' id="mainBtn">메인으로</button>
							<button type='button' id="cancelBtn">취소</button>
							<button type='submit' id="orderBtn">결제하기</button>
						</div>
						</td>
					</tr>

				</table>
			</form>	
	</div>
</body>
</html>