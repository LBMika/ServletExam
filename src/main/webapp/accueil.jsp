<%@page import="fr.mika.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
<%
	User user = (User)request.getSession().getAttribute("user");
%>
<h1>Bonjour <%= user.getNom() %> <%= user.getPrenom() %></h1>

</br>
</br>
<ul>
	<li>
		<h3><a href="<%= request.getContextPath() %>/formations">Les formations</a></h3>
	</li>
	<li>
		<h3><a href="<%= request.getContextPath() %>/eleves">Les élèves</a></h3>
	</li>
	<li>
		<h3><a href="<%= request.getContextPath() %>/logout">Deconnexion</a></h3>
	</li>
</ul>
</body>
</html>