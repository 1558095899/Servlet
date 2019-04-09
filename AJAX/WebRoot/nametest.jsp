<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/ajax.js"></script>
<script type="text/javascript">
//用户名验证
	window.onload=function(){
		
		var name=document.getElementsByName("user")[0];
		name.onblur=function(){
			//创建AJAX对象
			var xhr=getXMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4){
					if(xhr.status==200){
						var span=document.getElementById("span");
						if(xhr.responseText="true"){
							span.style.color="red";
							span.innerHTML="用户名已被使用";
						}else{
							span.style.color="blue";
							span.innerHTML="用户名可以使用";
						}
					}
				}	
			}
		xhr.open("get", "${pageContext.request.contextPath}/userNameTestServlet?name="+name.value);
		xhr.send(null);
		}
		
		
	}
</script>
</head>
<body>
	用户名：<input type="text" name="user" id="u"><span id="span"></span>
</body>
</html>