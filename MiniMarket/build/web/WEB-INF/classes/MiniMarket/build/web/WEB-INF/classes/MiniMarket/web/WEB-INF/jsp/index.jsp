<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Minimarket Doña Patty</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <img src="https://i0.wp.com/detrujillo.com/wp-content/uploads/2013/08/universidad-privada-del.norte_.jpg?fit=450%2C144&ssl=1"
                         class="img-fluid" width="90%">
                </div>
                <div class="col-md-4">
                    <h3>Soluciones Web y Aplicaciones Distribuidas</h3>
                    <h4>Universidad Privada del Norte</h4>
                    <h4>Entrega Final - 2018-2</h4>
                </div>
                <div class="col-md-4">
                    <h5>Estudiantes:</h5>
                    <ul>
                        <li><strong>Ames Mendez, Edith</strong> - N00045629</li>
                        <li><strong>Donayre Fajardo, Patricia</strong> - N00076644</li>
                        <li><strong>Quiroz Burga, Luis Augusto</strong> - N00030949</li>
                    </ul>
                    <h5>Docente: <strong>Fernando Alex Sierra Liñan</strong></h5>
                </div>
            </div>
        </div>
        <hr>
        <c:if test="${Initial}">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <ul class="list-group">
                            <li class="list-group-item"><strong>Usuario: </strong> <c:out value = "${User.getUsername()}" /></li>
                            <li class="list-group-item"><strong>Nombres y Apellidos: </strong> <c:out value = "${User.getFirstname()}" /> <c:out value = "${User.getLastname()}" /></li>
                            <li class="list-group-item"><strong>Correo: </strong> <c:out value = "${User.getEmail()}" /></li>
                            <li class="list-group-item"><strong>Teléfono: </strong> <c:out value = "${User.getPhone()}" /></li>
                        </ul>                    
                    </div>
                </div>
            </div>
        </c:if>
        
        <div class="row">
            <div class="col-md-6 offset-md-4"><img class="img-fluid" src="https://s3images.coroflot.com/user_files/individual_files/311230_SGRZvf91Gs7aHmlxcpiz7kvbc.jpg" width="50%">    
        </div>
        </div>
        <div class="container">
            <div class="row">
              <div class="col-sm-3">
                <div class="card">
                  <img class="card-img-top" src="https://www.sales-initiative.com/downloads/3803/download/BoostProductivity.jpg?cb=c8eb31a7c1611fa2fe0cfaff17025e67" alt="Card image cap">
                  <div class="card-body">
                    <h3 class="card-title">Módulo de Ventas</h3>
                    <p class="card-text">Ingresar al Módulo de Control de Ventas.</p>
                    <a href="SaleHome.htm" class="btn btn-primary">Ingresar</a>
                  </div>
                </div>
              </div>
              <div class="col-sm-3">
                <div class="card">
                    <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6I281GKw6cezt8uYSu0DrY2YiMcbORlipXC7EXUK1GrR45uSE" alt="Card image cap">
                    <div class="card-body">
                    <h3 class="card-title">Módulo de Clientes</h3>
                    <p class="card-text">Ingresar al Módulo de Control de Clientes.</p>
                    <a href="ClientHome.htm" class="btn btn-danger">Ingresar</a>
                  </div>
                </div>
              </div>
              <div class="col-sm-3">
                <div class="card">
                  <img class="card-img-top" src="data:image/jpeg;base64,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" alt="Card image cap">
                    <div class="card-body">
                    <h3 class="card-title">Módulo de Productos</h3>
                    <p class="card-text">Ingresar al Módulo de Control de Productos.</p>
                    <a href="ProductHome.htm" class="btn btn-warning">Ingresar</a>
                  </div>
                </div>
              </div>
              <div class="col-sm-3">
                <div class="card">
                <img class="card-img-top" src="data:image/jpeg;base64,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" alt="Card image cap">
                     <div class="card-body">
                    <h3 class="card-title">Módulo de Usuarios</h3>
                    <p class="card-text">Ingresar al Módulo de Control de Usuarios.</p>
                    <a href="UserHome.htm" class="btn btn-success">Ingresar</a>
                  </div>
                </div>
              </div>
            </div>
        </div>
        <br><br><br><br>
    </body>
</html>