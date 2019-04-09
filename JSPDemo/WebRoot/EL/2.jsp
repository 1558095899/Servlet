<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="JSPContextDemo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--获取1.jsp里类的数据 --%>
	<%
		request.getAttribute("name");
		
	 %>
	 <%-- 可直接获取Student类里私有化的数据 类似反射 --%>
	 ${name.name}<%-- 输出tom --%>
	 
	 <%
		List l=new ArrayList();
		l.add("a");
		l.add("b");
		l.add("c");
		request.setAttribute("l", l);
		
		Map m=new HashMap();
		m.put("1","aa");
		m.put("2","bb");
		m.put("3","cc");
		request.setAttribute("m",m);
	 %>
	 <%--使用EL表达式为 --%>
	 <%--设置了reqeust.setAttribute 后才能用 --%>
	 <%--输出[a,b,c] --%>>
	 ${l} <%-- ${l}==等价于pageContext.findAttribute("l") --%>
	 
	 ${m}
	 
</body>
</html>