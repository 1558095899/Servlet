<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--获得参数并输出 --%>
	<h1>参数一：<%=request.getParameter("name") %></h1>
	<h1>参数二：<%=request.getParameter("in") %></h1>
	<%
		String st="bilibili";
	 %>
	<a href="https://www.bilibili.com"><h1>receiv=<font color="black"><%=st %></font></h1></a>
</body>
</html>