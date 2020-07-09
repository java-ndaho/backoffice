<%--
  Created by IntelliJ IDEA.
  User: Gasana.NHonore
  Date: 05/07/2020
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>OnlineStore, Home</title>
</head>
<body>
<h1>OnlineStore, Gestion boutique multimedia en ligne</h1>
<p>
 <c:if test="${ not empty login }">
<p>  Bonjour Mrs ${sessionScope.login}
<a href="logout"> (Déconnexion)</a></p>
</c:if>

<a href="add-work-form.html">Ajouter une oeuvre au catalogue</a><br>
<a href="catalogue">Accés aux au catalogue</a><br>
</body>
</html>
