<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- JSTL标签库 -->
	<%--var:声明变量     value用${}取值   scope域对象即范围 --%>
	设置变量：<c:set var="num" value="${5 }" scope="session" ></c:set><br>
	输出变量：<c:out value="${num }"></c:out><br>
	删除变量：<c:remove var="num"/><br>
	删除后输出：<c:out value="${num }" default="被删除了"></c:out>
</body>
</html>