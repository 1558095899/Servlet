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
		String s="999";
		out.println(s);
	 %>
	 <jsp:scriptlet>
	 	String t="888";
	 </jsp:scriptlet>
	 <h2>t=<%=t %></h2>
	 <h1>s=<%=s %></h1>
</body>
</html>