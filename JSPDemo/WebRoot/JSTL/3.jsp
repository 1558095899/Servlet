<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 迭代标签  foreach -->
	<c:forEach var="i" begin="1" end="5" step="1">
		${i }&nbsp;
	</c:forEach>
	<%
		//遍历迭代数组
		List list=new ArrayList();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		
		//request.setAttribute("list", list);
		pageContext.setAttribute("list",list);

	 %>
	 <!-- 把放在外面 -->
	 	${list}<br><br>
	 	
	 	
</body>
</html>