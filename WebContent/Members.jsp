<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="uk.ac.dundee.computing.aec.store.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html lang="en-us">
	<title>Members Page</title>
	<meta http-equiv="Content-Type" charset="utf-8" />
	
	<link rel="stylesheet" href="jquery-ui-1.10.1.custom.css" />
	<link rel="stylesheet" type="text/css" href="CSS/mystyle.css">
	
	<div id="banner">
	<p><a id="bannerLink" href="WelcomePage.jsp">Mister Fault E.</a></p> 
	
	</div>
	
	<header id="head">
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>

		<script>
			$(function()
			{
				$( "#tabs" ).tabs(
				{
					beforeLoad: function( event, ui ) 
					{
						ui.jqXHR.error(function() 
						{
							ui.panel.html(
							"Couldn't load this tab. We'll try to fix this as soon as possible. " +
							"If this wouldn't be a demo." );
						});
					}
				});
			});
		</script>
		
		<div id="tabs">
			<ul>
				<li><a href="FaultServlet">Reports</a></li>
				<li><a href="FaultServlet">Open Report</a></li>
				<li><a href="FaultServlet">Log out</a></li>
			</ul>
			<div id="tabs-1">
			</div>
		</div>
		
	</header>

	<body>
		<div id="staticcontent">
		
			<div id="staticBodyText">
				<h1>Information</h1>
				<p>This is the first 'live' iteration of the website, developed for a university project.</p>
				<p>The assignment was to do develop understanding of client server web applications and to create a web application that conforms to the MVC model.</p>
				<p>The web application should have a RESTful interface and provide functionality to view, edit or follow faults and bugs providing a frame work to move the faults to a conclusion.</p>
				<p>At the moment the site has the following functionality :</p>
				<p>Main page has an AJAX tab provided by JQuery. Each tab has a separate controller and connects to the database to pull down its data independently</p>
				<p>News tab will show anything that may be important to visitors. Changes, related information etc. Administration users will be able to add or delete news items.</p>
				<p>Login tab allows people that have already registered access to the fault section of the web application. Tiered login will be present.</p>
				<p>Register tab for new visitors, existing users will be rejected.</p>
				<p>The web application, its function and scope will continue to be developed beyond the assignment</p>				
			</div>
		</div>
	</body>
	
	<footer id="foot">
		<div id="footerstaticcontent">
			<p>Developed by Paul Cannings 2013</p>
			</div>
		
	</footer>

</html> 