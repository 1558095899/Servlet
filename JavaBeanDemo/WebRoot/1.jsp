<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="BeanDemo.JavaBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 传统方法 -->
<!--<jsp:useBean id="j" scope="page" class="BeanDemo.JavaBean"/>
	相等于JavaBean j=new JavaBean()  -->
	<% JavaBean jb=new JavaBean();
	jb.setName("tom");
	jb.setAge(18);
	%>
	<h1>姓名：<%=jb.getName() %></h1>
	<h1>年龄：<%=jb.getAge() %></h1>
</body>
</html>