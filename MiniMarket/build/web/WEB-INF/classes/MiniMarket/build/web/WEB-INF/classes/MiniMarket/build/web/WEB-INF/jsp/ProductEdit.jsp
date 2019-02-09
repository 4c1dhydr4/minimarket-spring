<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@page contentType = "text/html" pageEncoding = "UTF-8"%>

<html>
    <head>
        <meta charset = "UTF-8" />
        <title>Módulo de Productos</title>
        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    </head>
    <body>
        <div class = "container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <ol class = "breadcrumb">
                        <li><a href = "<c:url value="/ProductHome.htm" />"> Lista de Productos</a></li>
                        <li class = "active"> Editar Producto </li>
                    </ol>
                    <div class = "panel panel-primary">
                        <div class = "panel-heading"> Editar Productos </div>
                        <div class = "panel-body">
                            <form:form method = "post" commandName = "Product">
                                <h3 class="text-center text-primary"> Editar Producto </h3>
                                <form:errors path = "*" element = "div" cssClass = "alert alert-danger" />
                                <p>
                                    <form:label path = "ProductCode"> Código de Producto: </form:label>
                                    <form:input path = "ProductCode" cssClass = "form-control"/>
                                </p>

                                <p>
                                    <form:label path = "ProductName"> Nombre de Producto: </form:label>
                                    <form:input path = "ProductName" cssClass = "form-control" />
                                </p>
                                <p>
                                    <form:label path = "QuantityPerUnit"> Cantidad por Unidad: </form:label>
                                    <form:input path = "QuantityPerUnit" cssClass = "form-control" />
                                </p>
                                <p>
                                    <form:label path = "UnitPrice"> Precio por Unidad: </form:label>
                                    <form:input path = "UnitPrice" cssClass = "form-control"/>
                                </p>
                                <p>
                                    <form:label path = "UnitsInStock"> Stock: </form:label>
                                    <form:input path = "UnitsInStock" cssClass = "form-control"/>
                                </p>
                                <hr/>
                                <input type="submit" value="Enviar" class="btn btn-danger" />
                                <a class="btn btn-primary" href="ProductHome.htm"> Cancelar </a>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    </body>
</html>