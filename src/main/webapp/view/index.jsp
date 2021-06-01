<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <title>Accident</title>
</head>
<body>
<div>
    Hello : ${user}
</div>
<div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Пункты</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${menu}" var="menuitem">
            <tr>
                <td><c:out value="${menuitem}"/></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>