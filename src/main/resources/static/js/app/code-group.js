$(document).ready(function() {

	        //CodeGroup
			//CodeGroup 목록조회 List
			$("#codeGroupListBtn").on("click",function() {
				alert("CodeGroup Listing~!!");
						$.ajax({
							type : "GET",
							url : "/codegroups",
							contentType : "application/json; charset=UTF-8",
							success : function(data) { //data: url에 들어가는 값을 자동 참조한다
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

			//CodeGroup 상세조회 read
			$("#codeGroupReadBtn").on("click",function(){
				alert("CodeGroup Reading~!!");
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

			
			//CodeGroup 등록
			$("#codeGroupRegisterBtn").on("click",function(){
					var codeGroupObject = {
							groupCode : $("#groupCode").val(),
							groupName : $("#groupName").val()
					};
					
					alert("CodeGroup Registering~!!");
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
			
		
			//CodeGroup 삭제
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


			//CodeGroup 수정
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
			
			//CodeGroup 입력값 리셋
			$("#codeGroupResetBtn").on("click", function() {
				alert("CodeGroup Resetting~!!");
				$("#groupCode").val("");
				$("#groupName").val("");
				
			});
			
			
			
			
			
			//CodeDetail
			//CodeDetail 목록조회 List
			$("#codeDetailListBtn").on("click",function() {
				alert("CodeDetail List~!!");
						$.ajax({
							type : "GET",
							url : "/codedetails",
							contentType : "application/json; charset=UTF-8",
							success : function(data) {
								console.log(data);
								alert(JSON.stringify(data)); //url을 통해서 파라미터로 요청하고 받은 결과객체 List<CodeDetail>: 매퍼 참조
							},
							error : function(xhr, status, error) {
								alert("code:" + xhr.status + "\n" 
									+ "message:" + xhr.responseText + "\n" 
									+ "error:" + error);
							}
						});
					});

			//CodeDetail 상세조회 Read
			$("#codeDetailReadBtn").on("click",function(){
				alert("Reading~!!");
						$.ajax({
							type : "GET",
							url : "/codedetails/"+$("#codeGroupCode").val()+"/"+$("#codeValue").val(),
							contentType : "application/jason; charset=UTF-8",
							success : function(data){
								console.log(data);
								alert(JSON.stringify(data));
								$("#codeGroupCode").val(data.groupCode);
								$("#codeValue").val(data.codeValue);
								$("#codeName").val(data.codeName);
							},
							error : function(xhr, status, error){
								alert("code:" + xhr.status + "\n"
									+ "message:" + xhr.responseText + "\n"
									+ "error:" + error)
							}
						});
			});

			
			//CodeDetail 등록 Register
			$("#codeDetailRegisterBtn").on("click",function(){
					var codeDetailObject = {
							groupCode : $("#codeGroupCode").val(),
							codeValue : $("#codeValue").val(),
							codeName : $("#codeName").val(),
					};
					
					alert("CodeDetail Registering~!!");
					alert(JSON.stringify(codeDetailObject));
					
					$.ajax({
						type : "POST",
						url : "/codedetails",
						data : JSON.stringify(codeDetailObject),
						contentType : "application/json; charset=UTF-8",
						success : function(){
							alert("CodeDetail Created");
						},
						error : function(xhr, textStatus, error){
							alert("code:" + xhr.status + "\n"
									+ "message:" + xhr.responseText + "\n"
									+ "error:"+error);
						}
					});
			});
			
		
			//CodeDetail 삭제 Delete
			$("#codeDetailDeleteBtn").on("click", function() {
				alert("CodeDetail Deleting~!!");
				$.ajax({
					type : "DELETE",
					url : "/codedetails/" + $("#codeGroupCode").val()+"/"+$("codeValue").val(),
					contentType : "application/json; charset=UTF-8",
					success : function() {
						alert("CodeDetail Deleted");
					},
					error : function(xhr, status, error) {
						alert("code:" + xhr.status + "\n"
							+ "message:" + xhr.responseText + "\n"
							+ "error:" + error);
					}
				});
			});


			//CodeDetail 수정 Modify
			$("#codeDetailModifyBtn").on("click", function() {
				var codeGroupCodeVal = $("#codeGroupCode").val();
				
				var codeGroupCodeObject = {
					groupCode : codeGroupCodeVal,
					groupName : $("#groupName").val()
				};
				
				alert("Modifying~!!");
				$.ajax({
					type : "PUT",
					url : "/codeDetails/" + groupCodeVal,
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
			
			//CodeDetail 입력값 리셋 Reset
			$("#codeDetailResetBtn").on("click", function() {
				alert("CodeDetail Resetting~!!");
				$("#codeGroupCode").val("");
				$("#codeValue").val("");
				$("#codeName").val("");
			});
});