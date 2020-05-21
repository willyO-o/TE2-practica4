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
                        Bienvenido, aqui puede administrar sus Posts 
                    </p>
                </div>
            </div>
            <div class="my-3">
                <a href="Controlador?accion=nuevo"><button class="btn btn-primary"> <i class="fas fa-plus"></i>  Nueva Entrada</button></a>
            </div>
            <div class="row mb-2">
                <div class="col-12">

                    <c:forEach var="li" items="${lista}">
                        <div class="col-12">
                            <div class="card flex-md-row mb-4 box-shadow h-md-250">
                                <div class="card-body d-flex flex-column align-items-start">
                                    <strong class="d-inline-block mb-2 text-primary">${li.getFecha()}</strong>
                                    <h3 class="mb-0">
                                        <a class="text-dark" href="#">${li.getTitulo()}</a>
                                    </h3>
                                    <br>
                                    <p class="card-text mb-auto">${li.getContenido()}</p>
                                    <br>

                                    <div class="d-flex justify-content-between col-12">
                                        <p class="text-muted"><b>Autor:</b> ${li.getAutor()}</p>
                                        <div>
                                            <a href="Controlador?accion=editar&id=${li.getIdbg()}"><button class="btn btn-warning">Editar</button></a>
                                            <a href="Controlador?accion=delete&id=${li.getIdbg()}"><button class="btn btn-danger">Eliminar</button></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    
                    <div class="d-flex justify-content-end">
                        <nav aria-label="...">
                            <ul class="pagination">
                                <li class="page-item ${act==1?"disabled": ""}">
                                    <a class="page-link " href="Controlador?accion=home&pag=${act-1}" tabindex="-1" aria-disabled="true">Anterior</a>
                                </li>
                                
                                <c:forEach  var="i" begin="1" end="${pag}">
                                    <li class="page-item ${i==act? "active": ""}"><a class="page-link" href="Controlador?accion=home&pag=${i}">${i}</a></li>
                                </c:forEach>
      
                                
                                
                                
                                <li class="page-item ${act==pag?"disabled": ""}">
                                    <a class="page-link" href="Controlador?accion=home&pag=${act+1}">Siguiente</a>
                                </li>
                            </ul>
                        </nav>
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
