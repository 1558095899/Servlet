<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="jb" scope="page" class="BeanDemo.JavaBean"/>
<body>
<!--<jsp:useBean id="j" scope="page" class="BeanDemo.JavaBean"/>
	相等于JavaBean j=new JavaBean()  -->
	<%--javaBean标签 --%>
	<%--<% jb.setName("lu");
	jb.setAge(18);%> --%>
	<%--
	<h1>姓名：<%=jb.getName() %></h1>
	<h1>年龄：<%=jb.getAge() %></h1>
	 --%>
	 <jsp:setProperty property="name" name="jb" value="tom"/>
	  <jsp:setProperty property="age" name="jb" value="18"/>
	 <jsp:getProperty property="name" name="jb"/><br>
	 <jsp:getProperty property="age" name="jb"/>
</body>
</html>