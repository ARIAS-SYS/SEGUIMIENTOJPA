<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <div class="container mt-5 row justify-content-center" >
            <h1 class="text-center">
                <c:if test="${estudiante.id == null}">Nuevo </c:if>
                <c:if test="${estudiante.id != null}">Editar </c:if>
                Estudiante
            </h1>
            <form action="MainController" style="width: 18rem;" method="post">
                <c:if test="${estudiante.id == null}"><input type="hidden" name="id" value="0"> </c:if>
                <c:if test="${estudiante.id != null}"><input type="hidden" name="id" value="${estudiante.id}"> </c:if>
                
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombres</label>
                    <input type="text" name="nombre" class="form-control" id="nombre" value="${estudiante.nombre}">
                </div>
                <div class="mb-3">
                    <label for="apellidos" class="form-label">Apellidos</label>
                    <input type="text" name="apellidos" class="form-control" id="apellidos" value="${estudiante.apellidos}">
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" name="email" class="form-control" id="email" value="${estudiante.email}">
                </div>
                <div class="mb-3">
                    <label for="fechaNacimiento" class="form-label">Fecha de Nacimiento</label>
                    <input type="date" name="fechaNacimiento" class="form-control" id="fechaNacimiento" value="<fmt:formatDate value="${estudiante.fechaNacimiento}" pattern="yyyy-MM-dd" />">
                </div>
                <div class="mb-3">
                    <input type="submit" class="btn btn-primary">
                </div>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    </body>
</html>
