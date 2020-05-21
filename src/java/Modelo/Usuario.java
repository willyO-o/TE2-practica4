
package Modelo;


public class Usuario {
    
    private int idus;
    private String nombre;
    private String user;
    private String clave;
    private int tipo;

    public Usuario() {
    }

    public Usuario(int idus, String nombre, String user, String clave, int tipo) {
        this.idus = idus;
        this.nombre = nombre;
        this.user = user;
        this.clave = clave;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public int getIdus() {
        return idus;
    }

    public void setIdus(int idus) {
        this.idus = idus;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
    
}
