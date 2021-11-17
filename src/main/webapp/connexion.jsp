<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Connexion</h1>
<br>
<%
	String invalid = (String) request.getSession().getAttribute("invalide");
%>
<p class="login_error"> <%= (invalid!=null?"Pseudo ou mot de passe invalide !!":"") %>
</p>
<form action = "<%=request.getContextPath() %>/accueil.jsp" method = "POST">
	Username : <input type = "text" name = "username">
	</br>
	</br>
	Password : <input type = "password" name = "pwd">
	</br>
	</br>
	<input type = "submit" value = "Connexion" />
</form>
</body>
</html>