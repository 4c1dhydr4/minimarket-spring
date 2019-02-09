<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<html>
    <head>
        <meta charset = "UTF-8" />
        <title>Módulo de Ventas</title>
        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"/>
    </head>
    <body>
        <div class = "container">
            <div class = "row">
                <div class="row">
                    <h1 align = "center"> <strong class="text-primary">Módulo de Ventas</strong> </h1>
                    <hr>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <p>
                            <a href = "<c:url value="SaleAdd.htm" />" class = "btn btn-primary"> <span class = "glyphicon glyphicon-plus" aria-hidden = "true"> </span> Nueva Venta </a>                        
                        </p> 
                    </div>
                    <div class="col-md-4">
                        <p>
                            <a href = "<c:url value="index.htm" />" class = "btn btn-success"> Menú Principal </a>                        
                        </p> 
                    </div>
                    <div class="col-md-4">
                        <p>
                            <a href = "<c:url value="SaleHome.htm" />" class = "btn btn-warning"> Regresar </a>                        
                        </p> 
                    </div>
                </div>
                <br>
                <div class="col-md-6">
                    <ul class="list-group">
                        <li class="list-group-item"><strong>Código de Venta: </strong> <c:out value = "${Sale.getSaleCode()}" /></li>
                        <li class="list-group-item"><strong>Usuario Responsable: </strong> <c:out value = "${Sale.getSalesMan()}" /></li>
                        <li class="list-group-item"><strong>Fecha de Venta: </strong> <c:out value = "${Sale.getSaleDate()}" /></li>
                        <li class="list-group-item"><strong>Cliente: </strong> <c:out value = "${Sale.getClientName()}" /></li>
                        <li class="list-group-item"><strong>Total: </strong> <c:out value = "${Sale.getTotal()}" /></li>
                    </ul>
                </div>
                <div class="col-md-6">
                    <table class = "table table-bordered table-striped table-hover">
                        <thead>
                            <tr>
                                <th> Código de Producto </th>
                                <th> Nombre del Producto </th>
                                <th> Cantidad </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items = "${SalesDetails}" var = "saleDetail">
                                <tr>
                                    <td> <c:out value = "${saleDetail.getProductCode()}" /> </td>
                                    <td> <c:out value = "${saleDetail.getProductName()}" /> </td>
                                    <td> <c:out value = "${saleDetail.getQuantity()}" /> </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    </body>
</html>