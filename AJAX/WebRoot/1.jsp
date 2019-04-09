<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="ajax.js"></script>
<script type="text/javascript">
	 window.onload=function(){
		var req=getXMLHttpRequest();
		req.onreadystatechange=function(){
			//alert(req.readyState);//查看浏览器响应状态  4为响应就绪
			 if(req.readyState==4){
				if(req.status==200){//查看服务器响应状态      200为正常
					alert(req.responseText);//获取响应text
				}
			} 
			
		}
		req.open("get","${pageContext.request.contextPath}/servletDemo1");
		req.send(null);
	} 
	/* window.onload=function(){
		var xmlhttp;
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		 {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  		}
  		xmlhttp.onreadystatechange=function(){
  			//alert(xmlhttp.readyState);//查看浏览器响应状态
  			 0: 请求未初始化 
			1: 服务器连接已建立 
			2: 请求已接收 
			3: 请求处理中 
			4: 请求已完成，且响应已就绪  
  			if(xmlhttp.readyState==4){//当请求已完成，且响应已就绪时
	  			 //200: "OK"
				//404: 未找到页面	 
  				alert(xmlhttp.status);//查看服务器响应状态
  			} 
  			
  		}
  		xmlhttp.open("get","${pageContext.request.contextPath}/servletDemo1");
  		xmlhttp.send(null);
} */
</script>
</head>
<body>

</body>
</html>