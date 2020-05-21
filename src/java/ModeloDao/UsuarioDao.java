
package ModeloDao;

import Config.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDao {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Usuario validar(String us, String pass ){
        Usuario u=new Usuario();
        String sql="SELECT * FROM usuario WHERE usuario=? AND clave=?";
        try {
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, us);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            while(rs.next()){
                u.setIdus(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setUser(rs.getString(3));
                u.setTipo(rs.getInt(4));
            }
            
            this.cerrarCon();
        } catch (SQLException e) {
        }
        
        return u;
    }
    
    
    
    public void cerrarCon(){
        try {
            this.con.close();
            this.ps.close();
            this.rs.close();
        } catch (SQLException e) {
        }
    }
}
