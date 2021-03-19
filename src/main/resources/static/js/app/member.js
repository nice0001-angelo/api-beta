$(document).ready(function(){
	
	//member
	//전체목록조회 list
	$("#memberListBtn").on("click",function(){
		
		$.ajax({
			type: "GET",
			url: "/users",
			contentType: "application/json; charset=UTF-8",
			success: function(data){
				
				alert("member listing~~~success !!!")
				
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
	
	//상세목록조회 Read
	$("#memberReadBtn").on("click",function(){

		$.ajax({
			type: "GET",
			url: "/users/"+$("#userNo").val(),
			contentType: "application/json; charset=UTF-8",
			success: function(data){
				alert("member Read~~success !!!");
				console.log(data);
				alert(JSON.stringify(data));
				$("#userId").val(data.userId);
				$("#userPassword").val(data.userPassword);
				$("#userName").val(data.userName);
				$("#job").val(data.job);				
			},
			error: function(xhr, status, error){
				alert("code: "+xhr.status+"\n"
						+"message: "+xhr.reponseText+"\n"
						+"error: "+error);
			}
		});
	});
	
	//등록 Insert
	$("#memberRegisterBtn").on("click", function() {
		var memberObject = {
				userId: $("#userId").val(),
				userPw: $("#userPassword").val(),
				userName:  $("#userName").val(),
				job: $("#job").val()
			};
		
		alert("JSON.stringify(memberObject): "+JSON.stringify(memberObject));

		$.ajax({
			type: "POST",
			url: "/users",
			data: JSON.stringify(memberObject),
			contentType: "application/json; charset=UTF-8",
			success: function(data){
					console.log(data);
					alert("memberObject: "+data);
					alert("Created~~success!!");
			},
			error: function(xhr, status, error){
				alert("code: "+xhr.status+"\n"
						+"message: "+xhr.reponseText+"\n"
						+"error: "+error);
			}
		});
	});
	
	
	//delete by id
	$("#memberDeleteBtn").on("click",function(){
		$.ajax({
			type: "DELETE",
			url: "/users"+$("#userNo").val(),
			contentType: "application/json; charset=UTF-8",
			success: function(data){
				console.log(data);
				alert("data: "+data);
				alert("Deleted~!!!")
			},
			error: function(xhr, status, error){
				alert("code: "+xhr.status+"\n"
						+"message: "+xhr.reponseText+"\n"
						+"error: "+error);
			}
			
		});
		
	});
});
