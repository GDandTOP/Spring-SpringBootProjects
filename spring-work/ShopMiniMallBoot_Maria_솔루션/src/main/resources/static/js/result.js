$(function() {
	console.log("bb")
	var loginBtn = $('#loginBtn');

	loginBtn.click(function() {
		console.log("test")
		location.href = '/shop';
	});
	
	var retryBtn = $('#retryBtn');

	retryBtn.click(function() {		
		history.back();
	});
});