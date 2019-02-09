<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@page contentType = "text/html" pageEncoding = "UTF-8"%>

<html>
    <head>
        <meta charset = "UTF-8" />
        <title>Módulo de Ventas</title>
        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    </head>
    <body>
        <div class = "container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <ol class = "breadcrumb">
                        <li><a href = "<c:url value="/SaleHome.htm" />"> Lista de Ventas</a></li>
                        <li class = "active"> Editar Venta </li>
                    </ol>
                        <div class="row">
                            <div class="col-md-6">
                                <div class = "panel panel-primary">
                                    <div class = "panel-heading"> Editar Venta</div>
                                    <div class = "panel-body">
                                        <form:form method = "post" commandName = "Sale">
                                            <h3 class="text-center text-primary"> Editar Venta </h3>
                                            <form:errors path = "*" element = "div" cssClass = "alert alert-danger" />
                                            <p>
                                                <form:label path = "idUser"> idUser: </form:label>
                                                <form:input path = "idUser" cssClass = "form-control"/>
                                            </p>

                                            <p>
                                                <form:label path = "idClient"> idClient: </form:label>
                                                <form:input path = "idClient" cssClass = "form-control" />
                                            </p>
                                            <p>
                                                <form:label path = "SaleCode"> Código de Venta: </form:label>
                                                <form:input path = "SaleCode" cssClass = "form-control" />
                                            </p>
                                            <p>
                                                <form:label path = "SaleDate"> Fecha de Venta: </form:label>
                                                <form:input path = "SaleDate" cssClass = "form-control" id="datepicker"/>
                                            </p>
                                            <p>
                                                <form:label path = "Total"> Total: </form:label>
                                                <form:input path = "Total" cssClass = "form-control"/>
                                            </p>
                                            <hr/>
                                            <input type="submit" value="Enviar" class="btn btn-danger" />
                                            <a class="btn btn-primary" href="SaleHome.htm"> Cancelar </a>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6"></div>
                        </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $( function() {
                $("#datepicker").datepicker({
                    dateFormat: 'yy-mm-dd',
                });
            });
        </script>
    </body>
</html>