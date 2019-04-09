<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="cou" scope="session" class="BeanDemo.CountDemo"></jsp:useBean>
	<h1>第<jsp:getProperty name="cou" property="count"/>访问次</h1>
	<!-- 删除javabean -->
	<%
		session.removeAttribute("count");//永远都是第一次访问
	 %>
</body>
</html>