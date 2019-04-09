<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="st" scope="page" class="ServletDemo1.Student"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%	
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		Student st=new Student();
		st.setAge(Integer.parseInt(request.getParameter("age")));
		st.setName(request.getParameter("name"));
	 %>
	姓名：<%=st.getName() %><br>
	年龄：<%=st.getAge() %> --%>
	 <%	request.setCharacterEncoding("utf-8");%>
	 <jsp:setProperty property="*" name="st"/>
	姓名：<jsp:getProperty property="name" name="st"/><br>
	年龄：<jsp:getProperty property="age" name="st"/>
</body>
</html>