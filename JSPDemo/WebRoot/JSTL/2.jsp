<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--条件标签 if choose --%>
	<c:if test="${5>3 }">
		aaaaaa
	</c:if>
	<!-- 或者可以先声明在比较 -->
	<c:set var="num" value="${5 }"></c:set>
	<c:if test="${num<2 }">
		cccccc
	</c:if><br>
	
	<c:set var="m" value="${3 }"></c:set>
	<c:choose >
	<!-- 判断m等于多少 -->
		<c:when test="${m==1 }">a</c:when>
		<c:when test="${m==2 }">b</c:when>
		<c:when test="${m==3 }">c</c:when>
		<c:otherwise>ggggg</c:otherwise>
	</c:choose>
	
</body>
</html>