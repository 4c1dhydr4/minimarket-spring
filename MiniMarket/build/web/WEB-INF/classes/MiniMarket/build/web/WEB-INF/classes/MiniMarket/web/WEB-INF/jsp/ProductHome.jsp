<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<html>
    <head>
        <meta charset = "UTF-8" />
        <title>Módulo de Productos</title>
        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"/>
    </head>
    <body>
        <div class = "container">
            <div class = "row">
                <div class="row">
                    <h1 align = "center"> <strong class="text-primary">Módulo de Productos</strong> </h1>
                    <hr>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <p>
                            <a href = "<c:url value="ProductAdd.htm" />" class = "btn btn-primary"> <span class = "glyphicon glyphicon-plus" aria-hidden = "true"> </span> Agregar Producto </a>                        
                        </p> 
                    </div>
                    <div class="col-md-4">
                        <p>
                            <a href = "<c:url value="index.htm" />" class = "btn btn-success"> Menú Principal </a>                        
                        </p> 
                    </div>
                </div>
                <br>
                <table class = "table table-bordered table-striped table-hover" id="myTable">
                    <thead>
                        <tr>
                            <th> Código de Producto </th>
                            <th> Nombre de Producto </th>
                            <th> Cantidad por Unidad </th>
                            <th> Precio </th>
                            <th> Stock Disponible </th>
                            <th> Mantenimiento </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items = "${Datos}" var = "Dato">
                            <tr>
                                <td> <c:out value = "${Dato.ProductCode}" /> </td>
                                <td> <c:out value = "${Dato.ProductName}" /> </td>
                                <td> <c:out value = "${Dato.QuantityPerUnit}" /> </td>
                                <td> <c:out value = "${Dato.UnitPrice}" /> </td>
                                <td> <c:out value = "${Dato.UnitsInStock}" /> </td>
                                <td>
                                    <a type="button" class="btn btn-warning btn-sm" href = "<c:url value = "ProductEdit.htm?idProduct=${Dato.idProduct}" />"> <span class = "glyphicon glyphicon-pencil" aria-hidden = "true"> </span> Editar </a>
                                    <button type="button" class="btn btn-danger btn-sm" id="deleteBtn${Dato.ProductCode}" href = "#"> <span class = "glyphicon glyphicon-trash" aria-hidden = "true"> </span> Eliminar </button> 
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready( function () {
                $('#myTable').DataTable({
                    "iDisplayLength": 10,
                    "oLanguage": {
                        "sSearch": "Buscar Producto",
                        "oPaginate":{
                            "sFirst": "Primera Página",
                            "sLast": "Última Página",
                            "sNext": "Siguiente",
                            "sPrevious": "Anterior",
                        }
                    }
                });
                
            } );
            <c:forEach items = "${Datos}" var = "Dato">
                $('#deleteBtn${Dato.ProductCode}').click(function () {
                    var answer = confirm('¿Desea eliminar el elemento ${Dato.ProductCode}?');
                    if (!answer) {
                        $('#deleteBtn${Dato.ProductCode}').preventDefault();
                    }else{
                        location.href='<c:url value = "ProductDelete.htm?idProduct=${Dato.idProduct}" />';;
                    }
                });
            </c:forEach>
        </script>
    </body>
</html>