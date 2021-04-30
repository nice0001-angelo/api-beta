$(document).ready(function(){
	//등록
	$("#adminRegisterBtn").on("click",function(){
		var userObject = {
			userId: $("#adminId").val(),
			userPw: $("#adminPw").val(),
			userName: $("#adminName").val()
				
		};
		
	});
	
	//입력값 리셋
	$("#adminReset").on("click",function(){
		$("#adminId").val("");
		$("#adminPw").val("");
		$("#adminName").val("");
	});
	
});