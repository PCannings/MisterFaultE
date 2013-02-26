<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="CSS/mystyle.css">
		<title>Login Page</title>
	</head>
	<body>
		<div id="loginform">
			<form action = "LoginServlet" method = "get">
				<p>Name:</p>
					<input type="text" name="username">
				<p>Password:</p>
					<input type="password" name="password"><br>
				<br>
					<input id="loginButton" type="submit" value="Submit"><br>
			</form>	
		</div>
	</body>
</html>