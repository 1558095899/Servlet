<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 表单 -->
	 <!--表单控件名name与age要与JavaBean.java中的name与age属性名称相同  -->
	<form action="4.jsp" method="post">
		<h1>姓名：<input type="text" name="name"></h1><br>
		<h1>年龄：<input type="text" name="age"></h1><br>
		<h1><input type="submit" value="提交"></h1>
	</form>
</body>
</html>