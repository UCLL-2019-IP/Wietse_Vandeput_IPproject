<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Meals</title>

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
<h1>Change Meals</h1>
    <div class="content">
<c:choose>
    <c:when test="${meals.isEmpty()}">
        <p>Er staan geen gerechten op het menu.</p>
    </c:when>
    <c:otherwise>
        <table class="table">
            <thead>
            <tr>
            <th>Description</th>
            <th>Price</th>
            <th>Type</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="meal" items="${meals}">
                <tr>
                    <td>${meal.description}</td>
                    <td>€ ${meal.price}</td>
                    <td>${meal.type}</td>
                    <td><a href="<c:url value="/gerechten/update"><c:param name="description" value="${meal.description}"></c:param></c:url>">update</a></td>
                    <td><a href="<c:url value="/gerechten/delete"><c:param name="description" value="${meal.description}"></c:param><c:param name="confirmation" value="false"></c:param></c:url>">delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
<a href="/gerechten/add/" class="button">Voeg gerecht toe</a>
    </div>
</main>
</body>
</html>
