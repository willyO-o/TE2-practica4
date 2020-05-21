/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import ModeloDao.UsuarioDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author willy
 */
@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {
    
    Usuario u=new Usuario();
    UsuarioDao udao=new UsuarioDao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        processRequest(request, response);
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
        processRequest(request, response);
        String accion=request.getParameter("accion");
        
        if (accion.equalsIgnoreCase("login")) {
            String user=request.getParameter("user");
            String cla=request.getParameter("clave");
            
            u=udao.validar(user, cla);
            System.out.println("asdasd");
            if (u.getUser()!=null) {
                HttpSession session=request.getSession();
                
                session.setAttribute("idus", u.getIdus());
                session.setAttribute("nombre", u.getNombre());
                session.setAttribute("user", u.getUser());
                session.setAttribute("tipo", u.getTipo());
                
                response.sendRedirect("Controlador?accion=home");
            }else{
                request.setAttribute("error", "nnUser");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
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
