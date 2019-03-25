<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Update meals</title>

    <link href="/./css/styles.css" rel="stylesheet">

</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="/gerechten/">View Meals</a></li>
            <li><a href="/gerechten/change">Change Meals</a></li>
            <li><a href="/gerechten/add">Add Meal</a></li>
        </ul>
    </nav>

</header>
<main>
<h1>Update meals</h1>
<c:choose>
    <c:when test="${! errors.isEmpty()}">
        <c:forEach var="error" items="${errors}">
            <p>${error.toString()}</p>
        </c:forEach>
    </c:when>
</c:choose>

<form>
    <input>
</form>
<a href="/gerechten/add/">Voeg gerecht toe</a>
</main>
</body>
</html>