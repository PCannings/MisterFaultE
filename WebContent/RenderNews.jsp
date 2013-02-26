<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="uk.ac.dundee.computing.aec.store.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>News</title>
	</head>
	<body>
		<div id="news">
			<%
				List<NewsStore> lParts = (List<NewsStore>)request.getAttribute("News");
			if (lParts==null){
			 %>
				<h1>Error no Hashmap</h1>
			<% 
			}else{
			%>
				<p>News</p>
				<hr>
			<% 
				Iterator<NewsStore> iterator;

				iterator = lParts.iterator();     
				while (iterator.hasNext())
				{
					NewsStore md = (NewsStore)iterator.next();
	
				%>
					<p>ID Number: <%=md.getIDNews() %></p>
					<p>Date: <%=md.getDateNews() %></p>
					<p>News: <%=md.getTextNews() %></p>
					<p>Author: <%=md.getAuthorNews() %></p>
					<hr>
				<%
				}
			}
			%>
		</div>
	</body>
</html>