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
                        <li class = "active"> Agregar Venta </li>
                    </ol>
                        <form:form method = "post" commandName = "Sale">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class = "panel panel-primary">
                                        <div class = "panel-heading"> Agregar Venta</div>
                                        <div class = "panel-body">
                                            <h3 class="text-center text-primary"> Agregar Venta </h3>
                                            <form:errors path = "*" element = "div" cssClass = "alert alert-danger" />
                                            <p>
                                                <form:label path = "idUser"> Vendedor: </form:label>
                                                <select name="idUser" class="form-control">
                                                    <c:forEach items="${Users}" var="user">
                                                        <option value="${user.getIdUser()}" <c:if test="${user.idUser == param.id}" > selected </c:if>>
                                                            <c:out value="${user.getFirstname()}" />
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </p>
                                            <p>
                                                <form:label path = "idClient"> Cliente: </form:label>
                                                <select name="idClient" class="form-control">
                                                    <c:forEach items="${Clients}" var="client">
                                                        <option value="${client.getIdClient()}" <c:if test="${client.idClient == param.id}" > selected </c:if>>
                                                            <c:out value="${client.getFirstName()}" />
                                                        </option>
                                                    </c:forEach>
                                                </select>
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
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class = "panel panel-primary">
                                        <div class = "panel-heading"> Detalle de Venta</div>
                                        <div class = "panel-body">
                                            <table class = "table table-bordered table-striped table-hover">
                                                <thead>
                                                    <tr>
                                                        <th> Código </th>
                                                        <th> Nombre </th>
                                                        <th> Cantidad </th>
                                                        <th> Agregar </th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items = "${Products}" var = "product">
                                                        <tr>
                                                            <td> <c:out value = "${product.getProductCode()}" /> </td>
                                                            <td> <c:out value = "${product.getProductName()}" /> </td>
                                                            <td><input type="number" name="N${product.getIdProduct()}" class="form-control"></td>
                                                            <td> <input type="checkbox" name="A${product.getIdProduct()}" value="${product.isDetailAdd()}" class="form-control"> </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form:form>
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