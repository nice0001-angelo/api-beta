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
				if(data.memberAuthList[0]){
					$("#memberAuth0").val(data.memberAuthList[0].auth);
				}
				
				if(data.memberAuthList[1]){
					$("#memberAuth1").val(data.memberAuthList[1].auth);
				}
				
				if(data.memberAuthList[2]){
					$("#memberAuth2").val(data.memberAuthList[2].auth);
				}
			},
			error: function(xhr, status, error){
				alert("code: "+xhr.status+"\n"
						+"message: "+xhr.reponseText+"\n"
						+"error: "+error);
			}
		});
	});
	
	//Insert all
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
					alert("memberObject after success: "+JSON.stringify(data));
					alert("Created~~success!!");
			},
			error: function(xhr, status, error){
				alert("code: "+xhr.status+"\n"
						+"message: "+xhr.reponseText+"\n"
						+"error: "+error);
			}
		});
	});
	
	
	//delete by userNo
	$("#memberDeleteBtn").on("click",function(){
		$.ajax({
			type: "DELETE",
			url: "/users/"+$("#userNo").val(),
			contentType: "application/json; charset=UTF-8",
			success: function(data){
				console.log(data);
				alert("data: "+JSON.stringify(data));
				alert("Deleted~!!!")
			},
			error: function(xhr, status, error){
				alert("code: "+xhr.status+"\n"
						+"message: "+xhr.reponseText+"\n"
						+"error: "+error);
			}
			
		});
		
	});
	
	
	//update by userNo
	$("#memberModifyBtn").on("click",function(){
		var userNoVal = $("#userNo").val();
		
		var memberObject = {
				userId: $("#userId").val(),
				userPw: $("#userPassword").val(),
				userName: $("#userName").val(),
				job: $("#job").val(),
				memberAuthList:[
					{
						userNo: userNoVal,
						auth: $("#memberAuth0").val()
					},
					{
						userNo: userNoVal,
						auth: $("#memberAuth1").val()
					},
					{
						userNo: userNoVal,
						auth: $("#memberAuth2").val()
					}
				]
		};
		
		alert("JSON.stringify(memberObject) :"+JSON.stringify(memberObject));
		
		$.ajax({
			type: "PUT",
			url: "/users/"+userNoVal,
			data: JSON.stringify(memberObject),
			contentType: "application/json; charset=UTF-8",
			success: function(data){
				alert("after success JSON.stringify(data): "+JSON.stringify(data));
				alert("member Modified~!!!");
			},
			error: function(xhr, status, error){
				alert("code: "+xhr.status+"\n"
						+"message: "+xhr.reponseText+"\n"
						+"error: "+error);
			}
		});
		
	});
	
	
	//reset
	$("#memberResetBtn").on("click",function(){
		$("#userNo").val("");
		$("#userId").val("");
		$("#userPassword").val("");
		$("#userName").val("");
		$("#job").val("");
		$("#memberAuth0").val("");
		$("#memberAuth1").val("");
		$("#memberAuth2").val("");
	});
	
	
	//화면 초기값 로딩
	$.getJSON("/codes/job", function(list){
		$(list).each(function(){
			var str = "<option value= '"+ this.value + "'>" + this.label + "</option>";
			$("#job").append(str);
		});
			
	});
	
});
