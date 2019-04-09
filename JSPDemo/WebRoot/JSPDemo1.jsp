<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="100%">
	<%--获取客户端页面输入的行数与列数   并处理生成表格 --%>
	<%	
		int rows=Integer.parseInt( request.getParameter("rows"));
		int cols=Integer.parseInt(request.getParameter("cols"));
		for(int i=0;i<rows;i++){
	%>
		<tr>
			<%
				for(int j=0;j<cols;j++){					
			 %>
			 	<td><%=(i*j)%></td>
			<%
				}
			 %>	
		</tr>	 
	<%
		}
	%>
	 </table>
</body>
</html>