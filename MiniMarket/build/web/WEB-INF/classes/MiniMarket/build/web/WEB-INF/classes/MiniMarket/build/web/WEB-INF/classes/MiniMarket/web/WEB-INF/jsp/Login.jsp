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
      <!------ Include the above in your HEAD tag ---------->
    </head>
    <body id="LoginForm">
        <div class="container">
        <h1 class="form-heading">login Form</h1>
        <div class="login-form">
        <div class="main-div">
            <div class="panel">
           <h2>Admin Login</h2>
           <p>Please enter your email and password</p>
           </div>
            <form id="Login">

                <div class="form-group">


                    <input type="email" class="form-control" id="inputEmail" placeholder="Email Address">

                </div>

                <div class="form-group">

                    <input type="password" class="form-control" id="inputPassword" placeholder="Password">

                </div>
                <div class="forgot">
                <a href="reset.html">Forgot password?</a>
        </div>
                <button type="submit" class="btn btn-primary">Login</button>

            </form>
            </div>
        <p class="botto-text"> Designed by Sunil Rajput</p>
        </div></div></div>


    </body>
</html>
