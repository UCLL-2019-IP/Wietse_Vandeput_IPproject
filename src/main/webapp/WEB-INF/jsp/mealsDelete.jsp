<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete meals</title>

    <link href="/./css/styles.css" rel="stylesheet">
    <script src="/./js/custom.js"></script>

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
<h1>Delete meals</h1>
    <p>Bent u zeker dat u het gerecht ${meal.description} wilt verwijderen?</p>
<ul>
    <li><a href="<c:url value="/gerechten/delete"><c:param name="description" value="${meal.description}"></c:param><c:param name="confirmation" value="true"></c:param></c:url>">yes</a></li>
    <li><a href="/gerechten/change">no</a></li>
</ul>
</main>
</body>
</html>