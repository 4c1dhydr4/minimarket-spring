<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@page contentType = "text/html" pageEncoding = "UTF-8"%>

<html>
    <head>
        <meta charset = "UTF-8" />
        <title>Módulo de Clientes</title>
        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    </head>
    <body>
        <div class = "container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <ol class = "breadcrumb">
                        <li><a href = "<c:url value="/ClientHome.htm" />"> Lista de Clientes </a></li>
                        <li class = "active"> Editar Cliente </li>
                    </ol>
                    <div class = "panel panel-primary">
                        <div class = "panel-heading"> Módulo de Clientes </div>
                        <div class = "panel-body">
                            <form:form method = "post" commandName = "Client">
                                <h3 class="text-center text-primary"> Editar Cliente </h3>
                                <form:errors path = "*" element = "div" cssClass = "alert alert-danger" />
                                <p>
                                    <form:label path = "ClientCode"> Código de Cliente: </form:label>
                                    <form:input path = "ClientCode" cssClass = "form-control" />
                                </p>

                                <p>
                                    <form:label path = "FirstName"> Nombres: </form:label>
                                    <form:input path = "FirstName" cssClass = "form-control" />
                                </p>
                                <p>
                                    <form:label path = "LastName"> Apellidos: </form:label>
                                    <form:input path = "LastName" cssClass = "form-control" />
                                </p>
                                <p>
                                    <form:label path = "RegisterDate"> Fecha de Registro: </form:label>
                                    <form:input path = "RegisterDate" cssClass = "form-control" id="datepicker" />
                                </p>
                                <hr/>
                                <input type="submit" value="Enviar" class="btn btn-danger" />
                                <a class="btn btn-primary" href="ClientHome.htm"> Cancelar </a>
                            </form:form>
                        </div>
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