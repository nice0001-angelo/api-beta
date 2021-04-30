$(document).ready(function(){
	//등록
	$("#adminRegisterBtn").on("click",function(){
		var userObject = {
			userId: $("#adminId").val(),
			userPw: $("#adminPw").val(),
			userName: $("#adminName").val()
		};
		
		console.log("userObject: "+userObject);
		
		alert("userObject: "+JSON.stringnify(userObject);
		
		$.ajax({
			type: "POST",
			url: "/users/setup",
			success: function(data, textStatus, request){
				var responseHeader = request.getResponseHeader("Authorization");
				alert(responseHeader);
				
				ACCESS_TOKEN = responseHeader.substr(7);
				
				console.log(ACCESS_TOKEN);
			},
			error: function(request, textStatus, errorThrown){
				alert(request.getResponseHeader("Authorization"));
			}
		});
		
	});
	
	//입력값 리셋
	$("#adminReset").on("click",function(){
		$("#adminId").val("");
		$("#adminPw").val("");
		$("#adminName").val("");
	});
	
});