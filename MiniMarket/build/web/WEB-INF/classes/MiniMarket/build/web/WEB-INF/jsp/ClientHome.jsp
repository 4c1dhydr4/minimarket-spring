<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<html>
    <head>
        <meta charset = "UTF-8" />
        <title>Módulo de Clientes</title>
        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"/>
    </head>
    <body>
        <div class = "container">
            <div class = "row">
                <div class="row">
                    <h1 align = "center"> <strong class="text-primary">Módulo de Clientes</strong> </h1>
                    <hr>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <p>
                            <a href = "<c:url value="ClientAdd.htm" />" class = "btn btn-primary"> <span class = "glyphicon glyphicon-plus" aria-hidden = "true"> </span> Agregar Cliente </a>                        
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
                            <th> Código de Cliente </th>
                            <th> Nombres </th>
                            <th> Apellidos </th>
                            <th> Fecha de Registro </th>
                            <th> Manenimiento </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items = "${Datos}" var = "Dato">
                            <tr>
                                <td> <c:out value = "${Dato.ClientCode}" /> </td>
                                <td> <c:out value = "${Dato.FirstName}" /> </td>
                                <td> <c:out value = "${Dato.LastName}" /> </td>
                                <td> <c:out value = "${Dato.RegisterDate}" /> </td>
                                <td>
                                    <a type="button" class="btn btn-warning btn-sm" href = "<c:url value = "ClientEdit.htm?idClient=${Dato.idClient}" />"> <span class = "glyphicon glyphicon-pencil" aria-hidden = "true"> </span> Editar </a>
                                    <button type="button" class="btn btn-danger btn-sm" id="deleteBtn${Dato.ClientCode}" href = "#"> <span class = "glyphicon glyphicon-trash" aria-hidden = "true"> </span> Eliminar </button> 
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
                        "sSearch": "Buscar Cliente",
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
                $('#deleteBtn${Dato.ClientCode}').click(function () {
                    var answer = confirm('¿Desea eliminar el elemento ${Dato.ClientCode}?');
                    if (!answer) {
                        $('#deleteBtn${Dato.ClientCode}').preventDefault();
                    }else{
                        location.href='<c:url value = "ClientDelete.htm?idClient=${Dato.idClient}" />';;
                    }
                });
            </c:forEach>
        </script>
    </body>
</html>