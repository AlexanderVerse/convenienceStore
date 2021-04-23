<%-- 
    Document   : signIn
    Created on : 22 abr. 2021, 20:12:43
    Author     : alexa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/signUp.css">
        <title>Sign Up</title>
    </head>
    <body>
        <!--
        <form action="controller_proyectos" method="get">
            <input type="submit" value="Ver mis proyectos" name="getAllProjects">
            <input type="submit" value="Salir" name="logOut">
        </form>
        -->
        <div id="signup-form">
            <form action="../controller_users" method="post">
                
                <div class="container signup-container">
                    <div class="row">
                        <div class="col-md-12 signup-form-1">
                            <h3>Sign up</h3>
                            <form>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Username *" value="" name="signupUsername" />
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="Password *" value="" name="signupPassword" />
                                </div>
                                <div class="form-group signup-controls">
                                    <input type="submit" class="btnSubmit" value="Sign up" name="signupUser"/>
                                </div>
                                <div id="login-control" class="signup-controls">
                                    <a href="../index.jsp">Log in</a>
                                </div>
                            </form>
                        </div>
                        <!--
                        <div class="col-md-6 login-form-2">
                            <h3>Login for Form 2</h3>
                            <form>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Your Email *" value="" />
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="Your Password *" value="" />
                                </div>
                                <div class="form-group">
                                    <input type="submit" class="btnSubmit" value="Login" />
                                </div>
                                <div class="form-group">

                                    <a href="#" class="ForgetPwd" value="Login">Forget Password?</a>
                                </div>
                            </form>
                        </div>
                        -->
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
