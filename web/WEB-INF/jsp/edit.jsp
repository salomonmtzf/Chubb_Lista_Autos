<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Hola desde Spring Web MVC</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
        <ol class="breadcrumb">
        <li><a href="<c:url value="/home.htm" />">Listado de Autos</a></li>
                <li class="active">Editar</li>
            </ol>
                <div class="panel panel-primary">
                <div class="panel-heading">Editar</div>
                <div class="panel-body">
                
                    <form:form method="post" commandName="autos">
                        <h1>Complete el formulario</h1>
                    
                    <form:errors path="*" element="div" cssClass=" alert alert-danger" />
                        
                <p>
                    <form:label path="marca">Marca</form:label>
                    <form:input path="marca" cssClass="form-control"/>
                </p>
                <p>
                    <form:label path="cantidad">Cantidad</form:label>
                    <form:input path="cantidad" cssClass="form-control"/>
                </p>
                  <p>
                    <form:label path="inventario">Codigo Inventario</form:label>
                    <form:input path="inventario" cssClass="form-control"/>
                </p>
                <hr />
                <input type="submit" value="Enviar" class="btn btn-danger"/>
            </form:form>
        </div>       
        </div>        
        </div>   
    </body>
</html>