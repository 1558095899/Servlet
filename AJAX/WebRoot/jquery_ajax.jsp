<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="jquery-1.8.3.js"></script>
<script type="text/javascript">
	function fu(){
		$.ajax({
			url:"/AJAX/jqueryAjax",
			async:"true",
			type:"post",
			data:{"name":"tom"},
			dataType:"json",
			success:function(data){
			var s="tom";
			
			alert(s==data.name);
				alert(data.name);
				alert(typeof data.name);
			}
		});
}
		function fu1(){
		$.post("/AJAX/jqueryAjax",
				{"name":"tom","age":"18"},
				function(data){
					alert(data);
				},
				"text"
		
		);
	};
</script>
</head>
<body>
	<input type="button" value="ajax" onclick="fu()">
	<input type="button" value="post" onclick="fu1()">
</body>
</html>