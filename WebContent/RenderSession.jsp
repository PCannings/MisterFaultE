<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="uk.ac.dundee.computing.aec.session.*" %>
    <%@ page import="uk.ac.dundee.computing.aec.testbean.*" %>
    <%@ page import="uk.ac.dundee.computing.aec.store.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="CSS/mystyle.css">
		<title>Render Session</title>
	</head>
	<body>
		<div id="sessions">
			<p>session is assigned at the HomePageController, the first response from a client.</p>
			<p>An http session is either retrieved or created.</p>
			<p>A new object is created of type SessionStore and a String value is set.</p>
			<p>The object is then added to the session. The controller then forwards to the applications home page.</p>
			<p>The following output is invoked from the JQuery tab that implements an AJAX interface on the home page for loading each tab.</p>
			<p>This uses the same values and method as the session tracker servlet, but displayed in a jsp page, the servlet generates a html page.</p>
			<p>The session object has additional data with the SessionData object.
			<p> session get attribute = <%= session.getAttribute("tracker.count") %></p>
		
		</div>
		<hr>
		<div id="sessionData">
			
			<p>The following output uses a bean accessed in the jsp page with jsp:useBean</p>
			<p>The useBean is defined, then within a scriptlet its increment counter is called. This increment has been moved to the Welcome Page</p>
			<p>2 properties are then retrieved from the bean, the counter value and a boolean value for tracking if user has logged in or not.</p>
								
			<jsp:useBean 
				id="myBean"
				scope="application"
				class="uk.ac.dundee.computing.aec.testbean.ABean"
			></jsp:useBean>
				
			<p>Visit counter = <jsp:getProperty
				name="myBean"
				property="counter"/></p>
					
			<p>Logged in: <jsp:getProperty
				name="myBean"
				property="loggedIn"/></p>
				
		</div>
	</body>
</html>