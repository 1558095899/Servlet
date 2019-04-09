<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Long c=session.getCreationTime();
		Long l=session.getLastAccessedTime();
		Long time=(l-c)/1000;
	 %>
	 停留时间：<%=time%>
	 <%=this.getServletContext().getRealPath("/") %>
	 
</body>
</html>