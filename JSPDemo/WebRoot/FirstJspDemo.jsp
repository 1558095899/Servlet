<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 显式注释     用户可看见-->
	<%--隐式注释   用户看不见 --%>
	<%
		//java中提供的单行注释   客户不可视
		/*
			java中多行注释    不可视
		*/
	 %>
	 <%-- 使用表达式输出 --%>
	 <%
	 	//这里相当于主函数
	 	String s="Scriptlet输出表达式";
	 	int i=8;
	 	//可以使用print输出  但不推荐
	 	out.println(s);
	  %>
	  <%--输出表达式 --%>
	  <h1>s=<%=s %></h1>
	  <h1>i=<%=i %></h1>
	  <%--JSP中方法，全局变量等的写法 --%>
	  
	  <%--另一种标签 --%>
	  <jsp:scriptlet>
	  	String u="w";
	  </jsp:scriptlet>
	  <h1><%=u %><h1>
</body>
</html>