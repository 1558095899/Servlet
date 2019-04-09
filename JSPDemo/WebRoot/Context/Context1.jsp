<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 四大域对象 域范围从小到大为  pageContext->request->session->application --%>
	<%	
		/* 操作其它域对象的方法
		void setAttribute(String name,Object o，int Scope);
		Object getAttribute(String name,int Scope);
		void removeAttribute(String name,int Scope);
		scpoe的值：
		PageContext.PAGE_SCOPE 
		PageContext.REQUEST_SCOPE 
		PageContext.SESSION_SCOPE 
		PageContext.APPLICATION_SCOPE */
		
		
		//PageContext域只能在当前页获取数据  其他jsp不可以获取保存的数据
		//pageContext.setAttribute("name", "pageContext", pageContext.PAGE_SCOPE);
		pageContext.setAttribute("name", "pageContext");
		String name=(String)pageContext.getAttribute("name");
		//out.println(name);
		
		//request域对象 当请求转发时其他jsp才能获取到数据   重定向和不转发不可获取
		request.setAttribute("name", "request");
		//请求转发时 路径同目录下可以直接写Context2.jsp  
		//request.getRequestDispatcher("Context2.jsp").forward(request, response);
		//重定向无法获取    路径要写完
		response.sendRedirect(request.getContextPath()+"/Context2.jsp");
		
		//session域对象  都可以获取
		//等价于
		//pageContext.setAttribute("name", "session", pageContext.SESSION_SCOPE);
		session.setAttribute("name", "session");
		
		//application域  javax.servlet.ServletContext  
		application.setAttribute("name", "application");
	 %>
	 <%--选择类型 --%>
	 ${requestScope.name }
	 <%--
	 
	 四大域对象：实际开发
	PageContext : pageConext 存放的数据在当前页面有效。开发时使用较少。
	ServletRequest: request  存放的数据在一次请求（转发）内有效。使用非常多。
	HttpSession: session 存放的数据在一次会话中有效。使用的比较多。如：存放用户的登录信息，购物车功能。
	ServletContext: application 存放的数据在整个应用范围内都有效。因为范围太大，应尽量少用。
	 
	 
	  --%>
	 	
</body>
</html>