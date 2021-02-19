$(document).ready(function(){
	$.ajax({
		type: "GET",
		url: "/codegroups",
		contentType: "application/json; charset=UTF-8",
		success: function(date){
			console.log(date);
			alert(JSON.stringify(data));
		},
		error: function(xhr, status, error){
			alert("code:"+xhr.status+"\n"
					+"message:"+xhr.responseText+"\n"
					+"error:"+error);
		}
	});
});