<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="removeWord">

		<tr>
			<td>Remove Word</td>
			<td><input type="text" name="dremove"></td>
		</tr>
		<tr>
			<td><input type="submit"></td>
			<td><input type="reset"></td>
		</tr>
		   <tr><td><a href="index.jsp">Home</a></td></tr>
	</form>
	
<%
	
	String s = (String)request.getAttribute("msg");
	if(s != null){
		out.println(s);
	}
%>

</body>
</html>