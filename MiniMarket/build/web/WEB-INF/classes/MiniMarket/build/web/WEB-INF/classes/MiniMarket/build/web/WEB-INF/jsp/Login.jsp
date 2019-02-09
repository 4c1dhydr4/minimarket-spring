<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MiniMarket Doña Paty</title>
      <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
      <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
      <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <style>
            body#LoginForm{ 
                background-image:url("https://endpoint915698.azureedge.net/globalassets/explore-legoland/beginning/uvid-4974f5/mini-market-1400.jpg?w=1422&h=800&mode=crop&scale=both&quality=80&format=jpg"); 
                background-repeat:no-repeat; background-position:center; background-size:cover; padding:10px;}

            .form-heading { font-size:35px;}
            .panel h2{ color:#444444; font-size:18px; margin:0 0 8px 0;}
            .panel p { color:#777777; font-size:14px; margin-bottom:30px; line-height:24px;}
            .login-form .form-control {
              background: #f7f7f7 none repeat scroll 0 0;
              border: 1px solid #d4d4d4;
              border-radius: 4px;
              font-size: 14px;
              height: 50px;
              line-height: 50px;
            }
            .main-div {
              background: #ffffff none repeat scroll 0 0;
              border-radius: 2px;
              margin: 10px auto 30px;
              max-width: 38%;
              padding: 50px 70px 70px 71px;
            }

            .login-form .form-group {
              margin-bottom:10px;
            }
            .login-form{ text-align:center;}
            .forgot a {
              color: #777777;
              font-size: 14px;
              text-decoration: underline;
            }
            .login-form  .btn.btn-primary {
              background: #f0ad4e none repeat scroll 0 0;
              border-color: #f0ad4e;
              color: #ffffff;
              font-size: 14px;
              width: 100%;
              height: 50px;
              line-height: 50px;
              padding: 0;
            }
            .forgot {
              text-align: left; margin-bottom:30px;
            }
            .botto-text {
              color: #ffffff;
              font-size: 14px;
              margin: auto;
            }
            .login-form .btn.btn-primary.reset {
              background: #ff9900 none repeat scroll 0 0;
            }
            .back { text-align: left; margin-top:10px;}
            .back a {color: #444444; font-size: 13px;text-decoration: none;}
      </style>
      <!------ Include the above in your HEAD tag ---------->
    </head>
    <body id="LoginForm">
        <div class="container">
        <div class="login-form">
        <div class="main-div">
            <div class="panel">
                <h1 class="form-heading text-primary text-center">Doña Paty</h1>
                <h2><strong class="text-primary">Login del Sistema</strong></h2>
                <p>Porfavor ingrese su Usuario y Contraseña</p>
           </div>
            <form:form method = "post" commandName = "User">
                <div class="form-group">
                    <form:label path = "username"> Usuario: </form:label>
                    <form:input path = "username" cssClass = "form-control"/>
                </div>

                <div class="form-group">
                    <form:label path = "password"> Contraseña: </form:label>
                    <form:input path = "password" cssClass = "form-control" type="password"/>
                </div>
                <p><strong class="text-danger">${PassDoNotMatch}</strong></p>
                <input type="submit" value="Ingresar" class="btn btn-primary" />
            </form:form>
            </div>
        <p class="botto-text"> Soluciones Web y Aplicaciones Distribuidas</p>
        </div></div></div>


    </body>
</html>
