<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--javabean与表单 --%>
	<%
		request.setCharacterEncoding("utf-8");
	 %>
	 <!--表单控件名name与age要与JavaBean.java中的name与age属性名称相同  -->
	<jsp:useBean id="d" scope="page" class="BeanDemo.JavaBean"></jsp:useBean>
	<jsp:setProperty property="*" name="d"/>
	<jsp:getProperty property="name" name="d"/><br>
	<jsp:getProperty property="age" name="d"/>
</body>
</html>