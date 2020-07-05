<%--
  Created by IntelliJ IDEA.
  User: Gasana.NHonore
  Date: 05/07/2020
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OnlineStore, Home</title>
</head>
<body>
<h1>OnlineStore, Gestion boutique multimedia en ligne</h1>
<p>
        <%
     String  identifiant =(String) session.getAttribute("login");
     if(identifiant!=null){%>
    Bonjour <%=identifiant%>
<p><a href="logout">(Déconnexion)</a></p>
<%}%>

<a href="add-work-form.html">Ajouter une oeuvre au catalogue</a><br>
<a href="catalogue.jsp">Accés aux au catalogue</a><br>
</body>
</html>
