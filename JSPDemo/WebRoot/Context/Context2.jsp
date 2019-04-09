<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/* String name=(String)pageContext.getAttribute("name");
		out.println(name); */
	 %>
	 <%=request.getAttribute("name") %>
	 <%=session.getAttribute("name") %>
	 <%--<%=pageContext.getAttribute("name", pageContext.SESSION_SCOPE) %>--%>
	 
	 <%=application.getAttribute("name") %>
	 <%--findAttribute(String name); 自动从page request session application依次查找，
	 	找到了就取值，结束查找。 --%>
	 <%=pageContext.findAttribute("name") %>  <%--取到值就立即结束  不往下查找 --%>
</body>
</html>