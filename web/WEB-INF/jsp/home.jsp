<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Ejemplo de JdbcTemplete</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
       
        <div class="container">
            <div class="row">
                <h1>Listado de Autos</h1>
                <p>
                    <a href="<c:url value="add.htm"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar</a>    
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Marca</th>
                            <th>Cantidad</th>
                            <th>Código Inventario</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.id}" /> </td>
                                <td><c:out value="${dato.marca}" /> </td>
                                <td><c:out value="${dato.cantidad}" /> </td>
                                <td><c:out value="${dato.inventario}" /> </td>
                                <td> 
                                <a href="<c:url value="edit.htm?id=${dato.id}"/>" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a> 
                                <a href="<c:url value="delete.htm?id=${dato.id}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a> 
                                </td>
                            </tr>
                        </c:forEach>  
                    </tbody>
                </table>
            </div>
        </div>
     
    </body>
</html>
