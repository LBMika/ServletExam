<%@page import="fr.mika.service.FormationService"%>
<%@page import="java.util.List"%>
<%@page import="fr.mika.model.Formation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formation</title>
</head>
<body>
<h1>Détails d'une formation</h1>

</br>
<ul>
<%
	String sujet = request.getParameter("sujet");
	Formation formation = null;
	
	for (Formation f : FormationService.getInstance().getFormations()) {
		if (f.getSujet().equals(sujet)) {
			formation = f;
			break;
		}
	}

%>
<h3>Sujet : <%= formation.getSujet() %></h3>
<h3>Programme : <%= formation.getProgramme() %></h3>
<h3>Nombre d'inscrits : <%= formation.getInscrit() %></h3>
</ul>

<br>
<h3><a href="<%=request.getContextPath() %>/formations">Retour</a></h3>
</body>
</html>