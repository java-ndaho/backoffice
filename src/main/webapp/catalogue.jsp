
<%@ page import="java.util.List" %>
<%@ page import="org.example.models.Catalogue" %>
<%@ page import="org.example.models.Work" %><%--
  Created by IntelliJ IDEA.
  User: Gasana.NHonore
  Date: 05/07/2020
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administration-Oeuvres au catalogue</title>
</head>
<body>
<h1>Oeuvres au catalogue</h1>
<%
    List catalogue= Catalogue.listsOfWorks;
    for (Object work:catalogue) {%>
        <p><%=((Work)work).getTitle() %></p>
<%}%>
</body>
</html>
