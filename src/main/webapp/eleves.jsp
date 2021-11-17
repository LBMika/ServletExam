<%@page import="java.util.List"%>
<%@page import="fr.mika.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formations</title>
</head>
<body>
<h1>Les formations</h1>

</br>
<ul>
<%
	String nom = "";
	for (User u : (List<User>) request.getAttribute("users")) {
		nom = u.getNom()+" "+u.getPrenom();

%>
	<li>
		<h3>
			<a href="<%= request.getContextPath() %>/eleve.jsp?nom=<%= u.getNom() %>&prenom=<%= u.getPrenom() %>">
			<%= nom %>
			</a>
		</h3>
	</li>
<%
	}
%>
</ul>
</body>
</html>