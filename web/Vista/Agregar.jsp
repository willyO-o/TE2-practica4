<%-- 
    Document   : Dashboard
    Created on : 17-may-2020, 21:15:02
    Author     : willy
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="control.jsp" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>

        <div class="container">
            <header class="blog-header py-3">
                <div class="row flex-nowrap justify-content-end align-items-center">

                    <div class="col-lg-2 text-center">
                        <a class="blog-header-logo text-dark" ><i class="fas fa-user"></i> ${sessionScope.nombre}
                        </a>
                    </div>
                    <div class="col-lg-1 d-flex justify-content-end align-items-center">

                        <a class="" href="Controlador?accion=salir"><i class="fas fa-sign-out-alt"></i>  Salir</a>
                    </div>
                </div>
            </header>



            <div class="jumbotron p-3 p-md-5 text-white rounded bg-dark mx-auto">
                <div class=" px-0 text-center">
                    <h1 class="display-4 font-italic">Blog de Salud</h1>
                    <p class="lead my-3">
                        Bienvenido, aqui puede Agregar nuevos Posts 
                    </p>
                </div>
            </div>
            <div class="text-center my-3">
                <h1> Nueva Entrada</h1>
            </div>

            <div class="row mb-2">
                <div class="col-12 d-flex justify-content-center">
                    <div class="card col-md-6">
                        <div class="card-body">
                            <c:choose>
                                <c:when test="${exito==true}">
                                    <div class="alert alert-success" role="alert">
                                        Post agregado!!!
                                    </div>
                                </c:when>
                                <c:when test="${exito==false}">
                                    <div class="alert alert-danger" role="alert">
                                        Ocurrio un error, intente de nuevo
                                    </div>
                                </c:when>
                            </c:choose>



                            <form action="Controlador" method="POST">
                                <div class="form-group row">
                                    <label for="exampleFormControlInput1" class="col-12">Fecha</label>
                                    <div class="col-md-6">

                                        <input type="date" class="form-control" name="fecha" required="">
                                    </div>
                                    <div class="col-md-2">
                                        <h3><i class="fas fa-calendar-alt"></i></h3>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlInput1">Titulo</label>
                                    <input type="text" class="form-control" name="titulo"  required="">
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlTextarea1">Contenido</label>
                                    <textarea class="form-control"  rows="3" name="contenido" required=""></textarea>
                                </div>

                                <input type="hidden" name="accion" value="add">
                                <div class="form-group">
                                    <div class="d-flex justify-content-between mb-3">
                                        <a href="Controlador?accion=home"><button class="btn btn-danger" type="button"> <i class="fas fa-arrow-left"></i> Cancelar o Volver a inicio</button></a>
                                        <button class="btn btn-primary" type="submit">Enviar</button>
                                    </div>
                                </div>
                            </form>

                        </div>

                    </div>
                </div>

            </div>
        </div>



        <div class="container bg-light py-3">
            <div class="row ">
                <footer class="blog-footer col text-center" >
                    <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
                    <p>
                        <a href="#">Back to top</a>
                    </p>
                </footer>
            </div>
        </div>

        <script src="js/jquery-3.4.1.slim.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/7d3d3951ea.js" crossorigin="anonymous"></script>
    </body>
</html>
