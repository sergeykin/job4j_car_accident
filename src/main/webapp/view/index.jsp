<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>

    <title>Accident</title>
</head>
<body>
<div>
    Hello : ${user}
</div>
<div>
    <a href="<c:url value='/create'/>">Добавить инцидент</a>
</div>
<div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Имя</th>
            <th scope="col">Текст</th>
            <th scope="col">Адрес</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${accidentMem}" var="accident">
            <tr>
                <td><c:out value="${accident.id}"/></td>
                <td><c:out value="${accident.name}"/></td>
                <td><c:out value="${accident.text}"/></td>
                <td><c:out value="${accident.address}"/></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>