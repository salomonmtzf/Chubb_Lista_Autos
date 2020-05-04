<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/home.htm" />">Listado de Autos</a></li>
                <li class="active">Agregar</li>
            </ol>
                <div class="panel panel-primary">
                <div class="panel-heading">Registrar un nuevo vehiculo</div>
                <div class="panel-body">
                
                    <form:form method="post" commandName="autos">
                        <h2>Complete el formulario</h2>
                    
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
                    <form:label path="inventario">Código Inventario</form:label>
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