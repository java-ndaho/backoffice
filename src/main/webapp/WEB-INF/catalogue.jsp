
<%@ page import="org.example.models.Catalogue" %>
<%@ page import="org.example.models.Work" %>
<%@ page import="org.example.models.Artist" %>
<%@ page import="java.util.Arrays" %>

<%--
  Created by IntelliJ IDEA.
  User: Gasana.NHonore
  Date: 05/07/2020
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Administration-Oeuvres au catalogue</title>
</head>
<body>
<h1>Oeuvres du catalogue</h1>
    <c:forEach items="${listOuevres}" var="work">
    <p>${work.title} ${work.annee}</p>
    </c:forEach>
</body>
</html>
