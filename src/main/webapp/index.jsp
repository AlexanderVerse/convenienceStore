<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="stylesheet" href="css/index.css">
        <title>Tienda de conveniencia</title>
    </head>
    <body>
        <!--
        <form action="controller_proyectos" method="get">
            <input type="submit" value="Ver mis proyectos" name="getAllProjects">
            <input type="submit" value="Salir" name="logout">
        </form>
        -->
        <div id="login-form">
            <form action="ControllerUser" method="post">
                <div class="container login-container">
                    <div class="row">
                        <div class="col-md-12 login-form-1">
                            <h3>Login</h3>
                            <form>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Username *" value="" name="loginUsername" />
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="Password *" value="" name="loginPassword" />
                                </div>
                                <div class="form-group login-controls">
                                    <input type="submit" class="btnSubmit" value="Login" name="loginUser"/>
                                </div>
                                <div id="signup-control" class="login-controls">
                                    <a href="views/signUp.jsp">Sign up</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>