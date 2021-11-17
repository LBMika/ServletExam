<%@page import="java.util.List"%>
<%@page import="fr.mika.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elèves</title>
</head>
<body>
<h1>Les élèves</h1>

</br>
<ul>
<%
	String nom = "";
	for (User u : (List<User>) request.getAttribute("users")) {
		nom = u.getNom()+" "+u.getPrenom();

%>
	<li>
		<h3>
			<a href="<%= request.getContextPath() %>/eleve?nom=<%= u.getNom() %>&prenom=<%= u.getPrenom() %>">
			<%= nom %>
			</a>
		</h3>
	</li>
<%
	}
%>
</ul>
<br>
<h3><a href="<%=request.getContextPath() %>/accueil.jsp">Retour</a></h3>
</body>
</html>