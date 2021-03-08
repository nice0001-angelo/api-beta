$(document).ready(function(){
	
	//member
	//목록조회 list
	$("#memberListBtn").on("click",function(){
		alert("member listing~~~!!!")
		$.ajax({
			type: "GET",
			url: "/users",
			contentType: "application/json; charset=UTF-8",
			success: function(data){
				console.log(data);
				
				alert(JSON.stringify(data));
			},
			error: function(xhr, status, error){
				alert("code: "+xhr.status+"\n"
						+ "message: "+xhr.responseText+"\n"
						+ "error: "+error);
			}
			
		});
	});
	
	//
	
	
});
