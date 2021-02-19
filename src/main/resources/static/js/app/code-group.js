$(document).ready(function() {
	
			//목록조회
			$("#codeGroupListBtn").on("click",function() {
						$.ajax({
							type : "GET",
							url : "/codegroups",
							contentType : "application/json; charset=UTF-8",
							success : function(date) {
								console.log(date);
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
						$.ajax({
							type : "GET",
							url : "/codegroups/"+$("#groupCode").val(),
							contentType : "application/jason; charset=UTF-8",
							success : function(data){
								console.log(data);
								alert(JSON.stringify(data));
								$(#"groupName").val(data.groupName);
							},
							error : function(xhr, status, error){
								alert("code:" + xhr.status + "\n"
									+ "message:" + xhr.responseText + "\n"
									+ "error:" + error)
							}
						});
			});
			
			$("#codeGroupRegisterBtn").on("click",function(){
					var codeGroupObject = {
							groupCode : $("#groupCode").val();
							groupName : $("#groupName").val();
					};
					
					
				
				
			});
			

});