<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>用户注册表</h1>
	<form action="${pageContext.request.contextPath}/registerServer" method="post">
		用户名：<input type="text" name="name"><br>
		密码：<input type="password" name="password"><br>
		出生日期：<input type="text" name="date"><br>
		<input type="submit" value="注册">
	</form>
</body>
</html>