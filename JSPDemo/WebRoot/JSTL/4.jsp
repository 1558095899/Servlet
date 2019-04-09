<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	 <table border="1">
	 		<tr>
	 			<td>数据</td>
	 			<td>索引</td>
	 			<td>计数</td>
	 			<td>第一个</td>
	 			<td>最后一个</td>
	 		</tr>
	 		<c:forEach items="${list }" var="l" varStatus="vs">
		<!-- 	加背景颜色 -->
		<!-- 	 <tr style="background-color: lime;"> -->
		<tr ${vs.count%2==0 ? "style='background-color:lime;'" : "style='background-color:red;'" }>
	 				<td>${l }</td><!-- 输出集合里的所有元素 -->
	 				<td>${vs.index }</td>
	 				<td>${vs.count }</td>
	 				<td>${vs.first }</td>
	 				<td>${vs.last }</td>
	 			</tr>
	 		</c:forEach>
	 		<!--  c:forEach中的varStatus属性。
    	指向一个字符串，该字符串引用一个对象。  map.put("vs",一个对象);
    	这个对象记录着当前遍历的元素的一些信息：
    		getIndex():返回索引。从0开始
    		getCount():返回计数。从1开始
    		isLast():是否是最后一个元素
    		isFirst():是否是第一个元素
	 		 -->
	 	</table>
</body>
</html>