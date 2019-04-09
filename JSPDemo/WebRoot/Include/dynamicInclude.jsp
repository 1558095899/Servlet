<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>动态包含：</h1>
	<%--不传递参数 --%>
	<h1><jsp:include page="jsptype.jsp"/></h1>
	<h1><jsp:include page="htmlType.html"/></h1>
	
	<%
		String s="数理化";
	 %>
	 <h1><font color="red"><%=s %></font></h1>
	<%--传达参数 --%>
	<h1>动态包含传达参数</h1>
	<jsp:include page="receivJSP.jsp">
		<jsp:param value="<%=s %>" name="name"/>
		<jsp:param value="www.lll.com" name="in"/>
	</jsp:include>
</body>
</html>