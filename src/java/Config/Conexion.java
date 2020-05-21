/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author willy
 */
public class Conexion {
    
    String url="jdbc:mysql://localhost:3306/te_blog";
    String user="root";
    String pass="";
    
    Connection con;
    
    public Connection getConexion(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return con;
    }
    public void desconect(){
        try {
             con.close();
        } catch (SQLException e) {
            System.out.println("error al cerrar conexion");
        }
    }
}
