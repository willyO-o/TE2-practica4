/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Post;
import Modelo.Usuario;
import ModeloDao.PostDao;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author willy
 */
public class Controlador extends HttpServlet {

    Post p = new Post();
    PostDao pdao = new PostDao();
    Usuario u = new Usuario();
    int id;
    String home = "Vista/Dashboard.jsp";
    String nuevo = "Vista/Agregar.jsp";
    String editar = "Vista/Editar.jsp";
    String login = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        double filas;
        String acceso = "";
        List<Post> lista = new ArrayList<>();
        switch (accion) {
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                pdao.delete(id);
                filas = pdao.filas();
                
                String ac=(request.getParameter("pag")==null? "1":request.getParameter("pag"));
                int actual=Integer.parseInt(ac);
                int limit=(actual-1)*3;
                BigDecimal x = new BigDecimal(filas/3);
                int x2 = x.setScale(0, RoundingMode.UP).intValue();

                try {
                    lista = pdao.listar(limit);
                } catch (ParseException ex) {
                    System.out.println("error listar");
                }
                //System.out.println(lista.size());
                request.setAttribute("act", actual);
                request.setAttribute("pag", x2);
                request.setAttribute("lista", lista);

                acceso = home;
                break;

            case "nuevo":
                acceso = nuevo;
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));

                p = pdao.getPost(id);
                request.setAttribute("post", p);

                acceso = editar;
                break;
            case "home":
                filas = pdao.filas();

                String ac2=(request.getParameter("pag")==null? "1":request.getParameter("pag"));
                int actual2=Integer.parseInt(ac2);
                int limit2=(actual2-1)*3;
                BigDecimal x1 = new BigDecimal(filas/3);
                int x21 = x1.setScale(0, RoundingMode.UP).intValue();


                try {
                    lista = pdao.listar(limit2);
                } catch (ParseException ex) {
                    System.out.println("error listar");
                }
                //System.out.println(lista.size());
                request.setAttribute("act", actual2);
                request.setAttribute("pag", x21);
                request.setAttribute("lista", lista);

                acceso = home;
                break;
            case "salir":
                HttpSession sesion = request.getSession();
                sesion.invalidate();
                acceso=login;
                break;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String acceso = "";
        switch (accion) {
            case "add":
                String fecha = request.getParameter("fecha");
                String titulo = request.getParameter("titulo");
                String contenido = request.getParameter("contenido");
                HttpSession session = request.getSession();
                int idus = Integer.parseInt(session.getAttribute("idus").toString());
                String nombre = session.getAttribute("nombre").toString();

                p.setTitulo(titulo);
                p.setFecha(fecha);
                p.setContenido(contenido);
                u.setIdus(idus);
                u.setNombre(nombre);
                p.setUs(u);

                if (pdao.agregarPost(p) == 1) {
                    request.setAttribute("exito", true);
                } else {
                    request.setAttribute("exito", false);
                }
                request.getRequestDispatcher(nuevo).forward(request, response);
                break;
            case "update":
                String fecha1 = request.getParameter("fecha");
                String titulo1 = request.getParameter("titulo");
                String contenido1 = request.getParameter("contenido");
                HttpSession sesion = request.getSession();
                int idus1 = Integer.parseInt(sesion.getAttribute("idus").toString());
                String nombre1 = sesion.getAttribute("nombre").toString();

                p.setTitulo(titulo1);
                p.setFecha(fecha1);
                p.setContenido(contenido1);
                u.setIdus(idus1);
                u.setNombre(nombre1);
                p.setUs(u);

                if (pdao.update(p) == 1) {
                    request.setAttribute("exito", true);
                } else {
                    request.setAttribute("exito", false);
                }
                response.sendRedirect("Controlador?accion=home");
                break;
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
