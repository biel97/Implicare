<%-- 
    Document   : index
    Created on : 17/11/2018, 15:05:06
    Author     : ADM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css\bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css\bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="css\bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css\bootstrap-theme.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="">
            <div class="form-group">
              <label for="exampleInputEmail1">Email address</label>
              <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
              <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Password</label>
              <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <div class="form-group form-check">
              <input type="checkbox" class="form-check-input" id="exampleCheck1">
              <label class="form-check-label" for="exampleCheck1">Check me out</label>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
          </form>

        <script src="js\bootstrap.js"></script>
        <script src="js\bootstrap.min.js"></script>
        <script src="js\jquery.js"></script>
    </body>
</html>
