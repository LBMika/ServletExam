<%@page import="fr.mika.service.UserService"%>
<%@page import="java.util.List"%>
<%@page import="fr.mika.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eleves</title>
</head>
<body>
<h1>Détails d'un élève</h1>

</br>
<ul>
<%
	List<User> users = UserService.getInstance().getUsers();
	String nom = request.getParameter("nom");
	String prenom = request.getParameter("prenom");
	User user = users.stream()
				.filter(u -> u.getNom().equals(nom) && u.getPrenom().equals(prenom))
				.findFirst().orElse(null);

%>
<h3>Nom : <%= user.getNom() %></h3>
<h3>Prenom : <%= user.getPrenom() %></h3>
<h3>Age : <%= user.getAge() %></h3>
<h3>Formation : <%= user.getFormation().getSujet() %></h3>
<h3>Note : <%= user.getNote() %></h3>
</ul>
<br>
<h3><a href="<%=request.getContextPath() %>/eleves">Retour</a></h3>
</body>
</html>