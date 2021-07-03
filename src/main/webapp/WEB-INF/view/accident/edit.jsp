<%--
  Created by IntelliJ IDEA.
  User: sergeykin
  Date: 13.06.2021
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
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
<c:set var="accident" value="${accident}" />
<body>
<div class="container">
    <form action="<c:url value='/save'/>" method='POST'>
        <div class="form-group">
            <label for="name">Ид </label>
            <input type="text" class="form-control" id="id" name="id" value="${accident.id}">
        </div>
        <div class="form-group">
            <label for="name">Имя </label>
            <input type="text" class="form-control" id="name" name="name" value="${accident.name}">
        </div>
        <div class="form-group">
            <label for="text">Описание </label>
            <input type="text" class="form-control" id="text" name="text" value="${accident.text}">
        </div>
        <div class="form-group">
            <label for="address">Адрес</label>
            <input type="text" class="form-control" id="address" name="address" value="${accident.address}">
        </div>
        <button type="submit" class="btn btn-light">Добавить</button>
    </form>
</div>
</body>
</html>
