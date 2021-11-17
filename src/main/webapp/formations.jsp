<%@page import="java.util.List"%>
<%@page import="fr.mika.model.Formation"%>
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
	String sujet = "";
	for (Formation f : (List<Formation>) request.getAttribute("formations")) {
		sujet = f.getSujet();

%>
	<li>
		<h3>
			<a href="<%= request.getContextPath() %>/formation.jsp?sujet=<%= sujet %>">
			<%= sujet %>
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