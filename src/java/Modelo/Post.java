/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author willy
 */
public class Post {
    private int idbg;
    private String titulo;
    private String fecha;
    private String contenido;
    private String autor;
    private Usuario us;

    public Post() {
    }

    public Post(int idbg, String titulo, String fecha, String contenido, String autor, Usuario us) {
        this.idbg = idbg;
        this.titulo = titulo;
        this.fecha = fecha;
        this.contenido = contenido;
        this.autor = autor;
        this.us = us;
    }



    public int getIdbg() {
        return idbg;
    }

    public void setIdbg(int idbg) {
        this.idbg = idbg;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }
    
    
}
