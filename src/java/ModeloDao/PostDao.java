/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import Config.Conexion;
import Modelo.Post;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

/**
 *
 * @author willy
 */
public class PostDao {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    public int agregarPost(Post p) {
        String sql = "INSERT INTO post VALUES(null,?,?,?,?,?)";
        try {
            
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getFecha());
            ps.setString(3, p.getContenido());
            ps.setInt(4, p.getUs().getIdus());
            ps.setString(5, p.getUs().getNombre());
            r = ps.executeUpdate();
            cn.desconect();
        } catch (SQLException e) {
        }

        return r;
    }
     public int update(Post p) {
        String sql = "UPDATE  post SET titulo=?, fecha=?, contenido=?, idus=?,autor=? WHERE idbg=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getFecha());
            ps.setString(3, p.getContenido());
            ps.setInt(4, p.getUs().getIdus());
            ps.setString(5, p.getUs().getNombre());
            ps.setInt(6, p.getIdbg());
            r = ps.executeUpdate();
            cn.desconect();
        } catch (SQLException e) {
        }

        return r;
    }

    
    public List listar(int pag) throws ParseException {
        List<Post> l = new ArrayList<>();
        String sql = "SELECT * FROM post ORDER BY fecha DESC LIMIT "+ pag+", 3";
        SimpleDateFormat parseador = new SimpleDateFormat("yyyy-MM-dd");
        // el que formatea
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setIdbg(rs.getInt(1));
                p.setTitulo(rs.getString(2));
                Date date = parseador.parse(rs.getString(3));
                p.setFecha(formateador.format(date));
                p.setContenido(rs.getString(4));
                p.setAutor(rs.getString(6));
                l.add(p);

            }
            cerrarCon();
        } catch (SQLException e) {
        }

        return l;
    }
    
    public Post getPost(int id) {
        Post p = new Post();
        String sql = "SELECT * FROM post WHERE idbg=" + id;

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setIdbg(rs.getInt(1));
                p.setTitulo(rs.getString(2));
                p.setFecha(rs.getString(3));
                p.setContenido(rs.getString(4));
                p.setAutor(rs.getString(6));
                
            }
            cerrarCon();
        } catch (SQLException e) {
        }
        return p;
    }
    
    public int delete(int id){
        String sql= "DELETE FROM post WHERE idbg="+id;
        try {
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            r=ps.executeUpdate();
            //cn.desconect();
        } catch (SQLException e) {
        }
        return r;
    }

    public Usuario getUser(int id) {
        Usuario us = new Usuario();
        String sql = "SELECT idus,nombre FROM usuario WHERE idus=" + id;

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                us.setIdus(rs.getInt(1));
                us.setNombre(rs.getString(2));
                
            }
        } catch (SQLException e) {
        }
        return us;
    }
    
    public int filas(){
        int filas=0;
        String sql="SELECT COUNT(*) FROM post";
        try {
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
            filas=rs.getInt(1);
            cn.desconect();
        } catch (SQLException e) {
        }
        
        return filas;
    }

    public void cerrarCon() {
        try {
            this.con.close();
            this.ps.close();
            this.rs.close();
        } catch (SQLException e) {
        }
    }

}
