<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	
	function find(){
	var xhr="";
	if(window.XMLHttpRequest){
		var xhr=new XMLHttpRequest();
	}else{// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}	
		var em=document.getElementById("em");
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				var span=document.getElementById("span");
				if(xhr.responseText=="true"){
					span.style.color="red";
					span.innerHTML="邮箱已被注册";	
				}else{
					span.style.color="blue";
					span.innerHTML="邮箱可以使用";
				}
			}
		}
	
	xhr.open("get", "${pageContext.request.contextPath}/userEmailTestServlet?email="+em.value);
	xhr.send(null);
}
	
	 
</script>
<title>Insert title here</title>
</head>
<body>
	邮箱：<input type="text" name="email" id="em" onblur="find()"><span id="span"></span>
</body>
</html>