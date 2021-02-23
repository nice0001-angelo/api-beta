$(document).ready(function() {
			//CodeGroup
			//목록조회
			$("#codeGroupListBtn").on("click",function() {
				alert("List~!!");
						$.ajax({
							type : "GET",
							url : "/codegroups",
							contentType : "application/json; charset=UTF-8",
							success : function(data) {
								console.log(data);
								alert(JSON.stringify(data));
							},
							error : function(xhr, status, error) {
								alert("code:" + xhr.status + "\n" 
									+ "message:" + xhr.responseText + "\n" 
									+ "error:" + error);
							}
						});
					});

			//상세조회
			$("#codeGroupReadBtn").on("click",function(){
				alert("Reading~!!");
						$.ajax({
							type : "GET",
							url : "/codegroups/"+$("#groupCode").val(),
							contentType : "application/jason; charset=UTF-8",
							success : function(data){
								console.log(data);
								alert(JSON.stringify(data));
								$("#groupName").val(data.groupName);
							},
							error : function(xhr, status, error){
								alert("code:" + xhr.status + "\n"
									+ "message:" + xhr.responseText + "\n"
									+ "error:" + error)
							}
						});
			});

			
			//등록
			$("#codeGroupRegisterBtn").on("click",function(){
					var codeGroupObject = {
							groupCode : $("#groupCode").val(),
							groupName : $("#groupName").val()
					};
					
					alert("Registering~!!");
					alert(JSON.stringify(codeGroupObject));
					
					$.ajax({
						type : "POST",
						url : "/codegroups",
						data : JSON.stringify(codeGroupObject),
						contentType : "application/json; charset=UTF-8",
						success : function(){
							alert("Created");
						},
						error : function(xhr, textStatus, error){
							alert("code:" + xhr.status + "\n"
									+ "message:" + xhr.responseText + "\n"
									+ "error:"+error);
						}
					});
			});
			
		
			//삭제
			$("#codeGroupDeleteBtn").on("click", function() {
				alert("Deleting~!!");
				$.ajax({
					type : "DELETE",
					url : "/codegroups/" + $("#groupCode").val(),
					contentType : "application/json; charset=UTF-8",
					success : function() {
						alert("Deleted");
					},
					error : function(xhr, status, error) {
						alert("code:" + xhr.status + "\n"
							+ "message:" + xhr.responseText + "\n"
							+ "error:" + error);
					}
				});
			});


			//수정
			$("#codeGroupModifyBtn").on("click", function() {
				var groupCodeVal = $("#groupCode").val();
				
				var codeGroupObject = {
					groupCode : groupCodeVal,
					groupName : $("#groupName").val()
				};
				
				alert("Modifying~!!");
				$.ajax({
					type : "PUT",
					url : "/codegroups/" + groupCodeVal,
					data : JSON.stringify(codeGroupObject),
					contentType : "application/json; charset=UTF-8",
					success : function() {
						alert("Modified");
					},
					error : function(xhr, status, error) {
						alert("code:" + xhr.status + "\n"
							+ "message:" + xhr.responseText + "\n"
							+ "error:" + error);
					}
				});
			});
			
			//입력값 리셋
			$("#codeGroupResetBtn").on("click", function() {
				alert("Resetting~!!");
				$("#groupCode").val("");
				$("#groupName").val("");
				
			});
			
			
			
			//CodeDetail
			//목록조회
			$("#codeDetailListBtn").on("click",function() {
				alert("List~!!");
						$.ajax({
							type : "GET",
							url : "/codegroups",
							contentType : "application/json; charset=UTF-8",
							success : function(data) {
								console.log(data);
								alert(JSON.stringify(data));
							},
							error : function(xhr, status, error) {
								alert("code:" + xhr.status + "\n" 
									+ "message:" + xhr.responseText + "\n" 
									+ "error:" + error);
							}
						});
					});

			//상세조회
			$("#codeDetailReadBtn").on("click",function(){
				alert("Reading~!!");
						$.ajax({
							type : "GET",
							url : "/codegroups/"+$("#groupCode").val(),
							contentType : "application/jason; charset=UTF-8",
							success : function(data){
								console.log(data);
								alert(JSON.stringify(data));
								$("#groupName").val(data.groupName);
							},
							error : function(xhr, status, error){
								alert("code:" + xhr.status + "\n"
									+ "message:" + xhr.responseText + "\n"
									+ "error:" + error)
							}
						});
			});

			
			//등록
			$("#codeDetailRegisterBtn").on("click",function(){
					var codeGroupObject = {
							groupCode : $("#groupCode").val(),
							groupName : $("#groupName").val()
					};
					
					alert("Registering~!!");
					alert(JSON.stringify(codeGroupObject));
					
					$.ajax({
						type : "POST",
						url : "/codegroups",
						data : JSON.stringify(codeGroupObject),
						contentType : "application/json; charset=UTF-8",
						success : function(){
							alert("Created");
						},
						error : function(xhr, textStatus, error){
							alert("code:" + xhr.status + "\n"
									+ "message:" + xhr.responseText + "\n"
									+ "error:"+error);
						}
					});
			});
			
		
			//삭제
			$("#codeDetailDeleteBtn").on("click", function() {
				alert("Deleting~!!");
				$.ajax({
					type : "DELETE",
					url : "/codegroups/" + $("#groupCode").val(),
					contentType : "application/json; charset=UTF-8",
					success : function() {
						alert("Deleted");
					},
					error : function(xhr, status, error) {
						alert("code:" + xhr.status + "\n"
							+ "message:" + xhr.responseText + "\n"
							+ "error:" + error);
					}
				});
			});


			//수정
			$("#codeDetailModifyBtn").on("click", function() {
				var groupCodeVal = $("#groupCode").val();
				
				var codeGroupObject = {
					groupCode : groupCodeVal,
					groupName : $("#groupName").val()
				};
				
				alert("Modifying~!!");
				$.ajax({
					type : "PUT",
					url : "/codegroups/" + groupCodeVal,
					data : JSON.stringify(codeGroupObject),
					contentType : "application/json; charset=UTF-8",
					success : function() {
						alert("Modified");
					},
					error : function(xhr, status, error) {
						alert("code:" + xhr.status + "\n"
							+ "message:" + xhr.responseText + "\n"
							+ "error:" + error);
					}
				});
			});
			
			//입력값 리셋
			$("#codeGroupResetBtn").on("click", function() {
				alert("Resetting~!!");
				$("#groupCode").val("");
				$("#groupName").val("");
				
			});
});