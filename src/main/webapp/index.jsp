
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>

        <div class="container mt-5" >

            <div class="" style="width: 18rem;" >


            </div>

            <h1>Lista de Estudiantes</h1>

            <a class="btn btn-primary mt-4" href="MainController?action=add">Nuevo</a>

            <table class="table table-dark table-hover mt-5">
                <tr>
                    <th>Id</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Email</th>
                    <th>Fecha de Nacimiento</th>
                    <th></th>
                    <th></th>
                </tr>

                <c:forEach var="item" items="${estudiantes}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.nombre}</td>
                        <td>${item.apellidos}</td>
                        <td>${item.email}</td>          
                        <td>
                            <fmt:formatDate value="${item.fechaNacimiento}" pattern="dd-MM-yyyy" />
                        </td>
                        <td>
                            <a href="MainController?action=edit&id=${item.id}">Editar</a>
                        </td>
                        <td>
                            <a href="MainController?action=delete&id=${item.id}">Eliminar</a>
                        </td>
                        
                    </tr>
                </c:forEach>


            </table>

        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
