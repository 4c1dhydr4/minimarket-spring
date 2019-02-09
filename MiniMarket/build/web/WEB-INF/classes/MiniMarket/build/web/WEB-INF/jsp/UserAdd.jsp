<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@page contentType = "text/html" pageEncoding = "UTF-8"%>

<html>
    <head>
        <meta charset = "UTF-8" />
        <title>Módulo de Usuarios</title>
        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    </head>
    <body>
        <div class = "container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <ol class = "breadcrumb">
                        <li><a href = "<c:url value="/UserHome.htm" />"> Lista de Usuarios</a></li>
                        <li class = "active"> Agregar Usuarios </li>
                    </ol>
                    <div class = "panel panel-primary">
                        <div class = "panel-heading"> Agregar Usuarios </div>
                        <div class = "panel-body">
                            <form:form method = "post" commandName = "User">
                                <h3 class="text-center text-primary"> Agregar Usuarios </h3>
                                <form:errors path = "*" element = "div" cssClass = "alert alert-danger" />
                                <div class="row">
                                    <div class="col-md-6">
                                        <p>
                                            <form:label path = "username"> Usuario: </form:label>
                                            <form:input path = "username" cssClass = "form-control"/>
                                        </p>

                                        <p>
                                            <form:label path = "password"> Contraseña: </form:label>
                                            <form:input path = "password" cssClass = "form-control" type="password"/>
                                        </p>
                                        <p>
                                            <form:label path = "password_match"> Repetir Contraseña: </form:label>
                                            <form:input path = "password_match" cssClass = "form-control" type="password"/>
                                        </p>
                                        <p><strong class="text-danger">${PassDoNotMatch}</strong></p>
                                        <p>
                                            <form:label path = "firstname"> Nombres: </form:label>
                                            <form:input path = "firstname" cssClass = "form-control" />
                                        </p>
                                        <p>
                                            <form:label path = "lastname"> Apellidos: </form:label>
                                            <form:input path = "lastname" cssClass = "form-control"/>
                                        </p>
                                    </div>
                                    <div class="col-md-6">
                                        <p>
                                            <form:label path = "email"> Correo Electrónico: </form:label>
                                            <form:input path = "email" cssClass = "form-control"/>
                                        </p>
                                        <p>
                                            <form:label path = "address"> Dirección: </form:label>
                                            <form:input path = "address" cssClass = "form-control"/>
                                        </p>
                                        <p>
                                            <form:label path = "phone"> Número Telefónico: </form:label>
                                            <form:input path = "phone" cssClass = "form-control"/>
                                        </p>
                                        <p>
                                            <div class="form-group">
                                                <form:label path = "typeUser"> Tipo de Usuario: </form:label>
                                                <select name = "typeUser" class="form-control">
                                                    <option value = "U"> Usuario del Sistema</option>
                                                    <option value = "A"> Administrador del Sistema</option>
                                                </select>
                                            </div>
                                        </p>
                                    </div>
                                </div>
                                <hr/>
                                <input type="submit" value="Enviar" class="btn btn-danger" />
                                <a class="btn btn-primary" href="UserHome.htm"> Cancelar </a>
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