<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 默认enctype="application/x-www-form-urlencoded" 改为enctype="multipart/form-data" -->
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/test" method="post">
		<input type="text" name="name"><br>
		<input type="file" name="photo" value="ppppp"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>