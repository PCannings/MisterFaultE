<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="uk.ac.dundee.computing.aec.store.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="CSS/mystyle.css">
		<title>Faults</title>
	</head>
	<body>
		<div id="faults">
			<%
				List<FaultsStore> lParts = (List<FaultsStore>)request.getAttribute("Faults");
			if (lParts==null){
			 %>
				<h1>Error no Hashmap</h1>
			<% 
			}else{
			%>
				<p>News</p>
				<hr>
			<% 
				Iterator<FaultsStore> iterator;

				iterator = lParts.iterator();     
				while (iterator.hasNext())
				{
					FaultsStore md = (FaultsStore)iterator.next();
	
				%>
					<p>Fault ID: <%=md.getIDFault() %></p>
					<p>Title: <%=md.getFaultTile() %></p>
					<p>Fault Information: <%=md.getFaultInformation() %></p>
					<p>Author: <%=md.getFaultAuthor() %></p>
					<hr>
				<%
				}
			}
			%>
		</div>
	</body>
</html>