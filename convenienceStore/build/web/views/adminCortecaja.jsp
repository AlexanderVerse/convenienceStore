<%-- 
    Document   : adminCortecaja
    Created on : 23-abr-2021, 8:30:20
    Author     : hapib
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    </head>
    <body>
        <div class="container m-5 ">
            <h1 class="text-center">Corte de caja - Admin</h1>
            <div class="row m-5">
                <div class="col-md-12 text-center">
                    <form action="adminCorte" method="post">
                        <button class="btn btn-primary" type="submit" name="corteTotal" value="total"> Corte total </button>
                    </form>
                    <form action="adminCorte" method="post">
                        <button class="btn btn-primary m-5" type="submit" name="cortePersonal" value="personal"> Corte por personal </button>
                    </form>
                </div>
                


            </div>

        </div>
    </body>
</html>
