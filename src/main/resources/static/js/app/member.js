$(document).ready(function(){
	
	//member
	//목록조회 list
	$("#memberListBtn").on("Click",fucntion(){
		alert("member listing~~~!!!")
		$.ajax({
			type: "GET",
			url: "/users",
			contentType: "application/json; charset=UTF-8",
			
		});
	});
});
