//엑세스 토큰 저장할 변수 선언
var ACCESS_TOKEN = "";

$(document).ready(function(){
	$.ajax({
		type: "POST",
		url: "aou/authenticate?username="+$("#userid").val()+"&password="+$("#password").val(),
		success: function(data, textStatus, request){
			var responseHeader = request.getResponseHeader("Authorization");
			alert(responseHeader);
		}
		
		
	});
	
	
});