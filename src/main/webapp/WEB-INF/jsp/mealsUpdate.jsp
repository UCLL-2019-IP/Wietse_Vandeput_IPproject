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
    <div class="content">
    <c:if test="${! errors.isEmpty()}">
        <c:forEach var="error" items="${errors}">
            <p class="error">${error.defaultMessage}</p>
        </c:forEach>
    </c:if>

    <form method="POST" action="/gerechten/update" class="table">
        <input type="hidden" name="mealId" value="${ meal.mealId }">
        <p>
            <label>Beschrijving</label>
            <input type="text" name="description" value="${meal.description}"/>
        </p>
        <p>
            <label>Prijs</label>
            <input type="text" name="price" value="${meal.price}"/>
        </p>
        <p>
            <label>Type</label>
            <select name="type">
                <option value="soep">Soep</option>
                <option value="dagschotel">Dagschotel</option>
                <option value="veggie">Veggie</option>
            </select>
        </p>
        <p>
            <input type="submit" value="Update" />
        </p>
    </form>
    <form method="get" action="/gerechten/change">
        <p>
            <input type="submit" value="Cancel"/>
        </p>
    </form>
</div>
</main>
</body>
</html>
