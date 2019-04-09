<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js\jquery-1.8.3.js"></script>
<!-- 再导入validate规范 -->
<script type="text/javascript" src="js\jquery.validate.min.js"></script>
<!-- 最后导入国际化 中文 -->
<script type="text/javascript" src="js\messages_zh.js"></script>
<script type="text/javascript">
		$(function(){
			$("#form").validate({
				rules:{
					username:{
						required:true,
						minlength:3
					},
					password:{
						required:true,
						digits:true,
						minlength:6
					}
				},
				messages:{
					username:{
						required:"用户名不能为空",
						minlength:"用户名长度不小于3位"
					},
					password:{
						required:"密码不能为空",
						digits:"密码不为整数",
						minlength:"密码长度不小于6位"
						
					}
				}
			});
		});
	</script>
</head>
<body>
		<form action="#" id="form">
	<label for="user">用户名：</label>
	<input type="text" name="username" id="user"><br>
	<label for="pass">密码：</label>
	<input type="password" name="password" id="pass"><br>
	<input type="submit" value="提交">
	</form>
</body>
</html>