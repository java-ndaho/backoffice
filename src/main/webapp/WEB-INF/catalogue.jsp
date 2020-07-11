

<%--
  Created by IntelliJ IDEA.
  User: Gasana.NHonore
  Date: 05/07/2020
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${listOuevres}" var="work">
    <p>${work.title} ${work.annee}</p>
</c:forEach>

