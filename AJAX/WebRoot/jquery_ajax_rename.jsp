<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("#user").blur(function(){
			var value=$("#user").val();
			 $.ajax({
				url:"/AJAX/jqueryAjaxRename",
				async:true,
				type:"post",
				data:{"name":value},
				dataType:"json",
				success:function(data){
					var c=$("#span")
					//jQuery封装的ajax   这里最好传int类型 进行判断       如果用string 会不相等
					if(data==1){
						c.css("color","red");
						c.html("用户名已存在");
					}else{
						c.css("color","green");
						c.html("用户名可以使用");
					}
				}
			});
		}); 
	});
</script>
</head>
<body>
<form action="#">
	用户名：<input type="text" name="user" id="user"><span id="span"></span>
	
	</form>
</body>
</html>