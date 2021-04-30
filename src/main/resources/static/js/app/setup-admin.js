$(document).ready(function(){
	//등록
	$("#adminRegisterBtn").on("click",function(){
		var userObject = {
			userId: $("#adminId").val(),
			userPw: $("#adminPw").val(),
			userName: $("#adminName").val()
		};
		
		console.log("userObject: "+userObject);
		
		alert("userObject: "+JSON.stringify(userObject);
		
		$.ajax({
			type: "POST",
			url: "/users/setup",
			data: JSON.stringify(userObject),
			contextType: "application/json; charSet=UTF-8",
			success: function(){
				
				alert("Admin user Created");
				
			},
			error: function(xhr, status, error){
				alert("code: "+xhr.status+"\n"
						+ "message: "+xhr.responseText+"\n"
						+ "error: "+error);
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