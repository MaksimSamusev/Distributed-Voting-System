<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login page</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
    <link href="/static/css/signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body style="background-color: #ffffff;">
<div id="wrap">
    <div class="row" style="margin: 20px;">
        <div class="col-xs-12 col-md-8">
            <div class="jumbotron" style="margin-top: 20px;">
                <h1>Vote server</h1>

                <p class="lead">GrSU O.M. labs 2015</p>
            </div>
        </div>
        <div class="col-xs-6 col-md-4"><c:url value="/j_spring_security_check" var="loginUrl"/>
            <form action="${loginUrl}" method="post">
                <h3 class="form-signin-heading">Please sign in</h3>

                <div class="form-group"><input type="text" class="form-control" name="j_username"
                                               placeholder="Email address" required autofocus
                                               value="admin"></div>
                <div class="form-group"><input type="password" class="form-control" name="j_password"
                                               placeholder="Password"
                                               required value="1111"></div>
                <button class="btn btn-lg btn-success btn-block" type="submit">Login</button>
            </form>
        </div>
    </div>
</div>

</body>

</html>
