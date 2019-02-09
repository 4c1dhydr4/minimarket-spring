<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<html>
    <head>
        <meta charset = "UTF-8" />
        <title>Módulo de Usuarios</title>
        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"/>
    </head>
    <body>
        <div class = "container">
            <div class = "row">
                <div class="row">
                    <h1 align = "center"> <strong class="text-primary">Módulo de Usuarios</strong> </h1>
                    <hr>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <p>
                            <a href = "<c:url value="UserAdd.htm" />" class = "btn btn-primary"> <span class = "glyphicon glyphicon-plus" aria-hidden = "true"> </span> Agregar Usuario </a>                        
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
                            <th> Usuario </th>
                            <th> Nombres </th>
                            <th> Apellidos </th>
                            <th> Correo Electrónico </th>
                            <th> Dirección </th>
                            <th> Número Telefónico </th>
                            <th> Tipo de Usuario </th>
                            <th> Mantenimiento </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items = "${Datos}" var = "Dato">
                            <tr>
                                <td> <c:out value = "${Dato.username}" /> </td>
                                <td> <c:out value = "${Dato.firstname}" /> </td>
                                <td> <c:out value = "${Dato.lastname}" /> </td>
                                <td> <c:out value = "${Dato.email}" /> </td>
                                <td> <c:out value = "${Dato.address}" /> </td>
                                <td> <c:out value = "${Dato.phone}" /> </td>
                                <td> <c:out value = "${Dato.typeUser}" /> </td>
                                <td>
                                    <a style="margin-bottom: 5px;" type="button" class="btn btn-warning btn-sm" href = "<c:url value = "UserEdit.htm?idUser=${Dato.idUser}" />"> <span class = "glyphicon glyphicon-pencil" aria-hidden = "true"> </span> Editar </a>
                                    <button type="button" class="btn btn-danger btn-sm" id="deleteBtn${Dato.username}" href = "#"> <span class = "glyphicon glyphicon-trash" aria-hidden = "true"> </span> Eliminar </button> 
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
                        "sSearch": "Buscar Usuarios",
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
                $('#deleteBtn${Dato.username}').click(function () {
                    var answer = confirm('¿Desea eliminar el usuario ${Dato.username}?');
                    if (!answer) {
                        $('#deleteBtn${Dato.username}').preventDefault();
                    }else{
                        location.href='<c:url value = "UserDelete.htm?idUser=${Dato.idUser}" />';;
                    }
                });
            </c:forEach>
        </script>
    </body>
</html>