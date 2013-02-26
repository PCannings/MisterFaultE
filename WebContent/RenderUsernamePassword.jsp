<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="uk.ac.dundee.computing.aec.store.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="CSS/mystyle.css">
		<title>Insert title here</title>
	</head>
	<body>
	<div id="members">
	<%
		List<UsernamePasswordStore> lParts = (List<UsernamePasswordStore>)request.getAttribute("Members");
		if (lParts==null)
		{
	%>
			<h1>Error no Hashmap</h1>
			<% 
		}
		else
		{
			%>
			<h1>Members</h1>
			<% 
			Iterator<UsernamePasswordStore> iterator;

			iterator = lParts.iterator();     
		while (iterator.hasNext())
		{
			UsernamePasswordStore md = (UsernamePasswordStore)iterator.next();
			%>
			<%=md.getUsername() %>
			<%=md.getPassword() %>  <br/><%
		}
		}
										 %>
										 </div>
	</body>
</html>