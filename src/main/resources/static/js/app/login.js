//엑세스 토큰 저장할 변수 선언
var ACCESS_TOKEN = "";

$(document).ready(function(){
	//로그인
	$("#loginBtn").on("click",function(){
		$.ajax({
			type: "POST",
			url: "aou/authenticate?username="+$("#userid").val()+"&password="+$("#password").val(),
			success: function(data, textStatus, request){
				var responseHeader = request.getResponseHeader("Authorization");
				alert(responseHeader);
				
				ACCESS_TOKEN = responseHeader.substr(7);
				
				console.log(ACCESS_TOKEN);
			}
			error: function(request, textStatus, errorThrown){
				alert(request.getREsponseHeader("Authorization"));
			}
		});
	});
	
	//로그인 사용자 정보
	$("#myInfoBtn").on("click",function(){
		$.ajax({
			type: "GET",
			url: "/users/myinfo/",
			contentType: "application/json: charset=UTF-8",
			headers:{
				"Authorization": "Bearer"+ACCESS_TOKEN
			},
			success: function(data){
				console.log(data);
				alert(JSON.stringify(data));
			},
			error: function(xhr, status, error){
				alert("code: "+xhr.status+"\n"
						+"message: ")
			}
		});
		
	});
	
});