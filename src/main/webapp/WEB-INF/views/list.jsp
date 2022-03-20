<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/03/2022
  Time: 4:07 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Product</title>
    <style>
        table,td{
            border-collapse: collapse;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>Product List</h1>
<h3><a href="/products/create">Create New Product</a></h3>
<table>
    <tr>
        <td>#</td>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Image</td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><a href="/products/view/${product.id}">${product.name}</a></td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td><img src="${product.image}" alt="product image"></td>
            <td><a href="/products/edit/${product.id}">Edit</a></td>
            <td><a href="/products/delete/${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
