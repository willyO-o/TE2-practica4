
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>
    <body class="text-center bg-secondary">
        <div class="card col-lg-3 mx-auto mt-5">
            <div class="card-body">

                <form class="form-signin" method="POST" action="Validar">
                    <img class="mb-4" src="logo.png" alt="" width="72" height="72">
                    <h1 class="h3 mb-3 font-weight-normal">Login</h1>
                    <c:if test="${error!=null}" >
                        <div class="alert alert-danger" role="alert">
                            <b>Error:</b> Usuario o Clave incorrectos
                        </div>
                    </c:if>

                    <label for="inputEmail" class="sr-only">Usuario:</label>
                    <input type="text" id="inputEmail" class="form-control" name="user" placeholder="Usuario" required="" autofocus="" ><br>
                    <label for="inputPassword" class="sr-only">Clave:</label>
                    <input type="password" id="inputPassword" name="clave" class="form-control" placeholder="Password" required=""><br>
                    <input type="hidden" name="accion" value="login">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
                    <p class="mt-5 mb-3 text-muted">© 2020</p>
                </form>
            </div>
        </div>


        <script src="js/jquery-3.4.1.slim.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
    </body>
</body>
</html>
