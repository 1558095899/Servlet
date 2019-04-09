<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--以表格的方式生成表单 --%>
	<form action="JSPDemo1.jsp" method="post">
		<table>
			<tr>
				<td>输入表格的行数</td>
				<td><input type="text" name="rows"></td>
			</tr>
			<tr>
				<td>输入表格列数</td>
				<td><input type="text" name="cols"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="显示">
					<input type="reset" value="重置">
				</td>>
			</tr>
		</table>
	</form>
</body>
</html>