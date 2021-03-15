$(document).ready(function(){
	
	//member
	//전체목록조회 list
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
	
	//상세목록조회 Read
	$("#memberReadBtn").on("click",function(){
		alert("member Read~~!!!");
		$.ajax({
			type: "GET",
			url: "/users/"+$("#userNo").val(),
			contentType: "application/json; charset=UTF-8",
			success: function(data){
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
	$("#memberRegisterBtn").on("click",function(){
		alert("member insert~!!!");
		var memberObject = {
			userNo = $("#userNo").val();
			userId = $("#userId").val();
			userPw = $("#userPassword").val();
			userName = $("#userName").val();
				
		};
		
		$.ajax({
			type: "POST",
			url: "/users",
			contentType: "application/json; charset=UTF-8",
			success: function(data){
				console.log(data);
				alert(JSON.stringify(data));
			},
			error: fucntion(xhr, status, error){
				alert("code: "+xhr.status+"\n"
						+"message: "+xhr.reponseText+"\n"
						+"error: "+error);
			}
			
		})
		
	});
	
	
});
