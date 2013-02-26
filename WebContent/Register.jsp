<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Register Page</title>
	</head>
	<body>
		<div id="Registerform">
			<form action = "RegisterServlet" method = "get">
				<p>Name:</p>
					<input type="text" name="username">
				<p>Password:</p>
					<input type="password" name="password"><br>
				<br>
					<input id="RegisterButton" type="submit" value="Submit"><br>
			</form>	
		</div>
	</body>
</html>