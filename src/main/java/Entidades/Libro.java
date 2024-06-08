/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author hp
 */
public class Libro {
    private int NumeroIdentificacion;
    private String Titulo;
    private String Autor;
    private String Estado;

    public Libro() {
    }

    public Libro(int NumeroIdentificacion, String Titulo, String Autor, String Estado) {
        this.NumeroIdentificacion = NumeroIdentificacion;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Estado = Estado;
    }

    public int getNumeroIdentificacion() {
        return NumeroIdentificacion;
    }

    public void setNumeroIdentificacion(int NumeroIdentificacion) {
        this.NumeroIdentificacion = NumeroIdentificacion;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    @Override
    public String toString(){
        return "N.Identificacion: " + NumeroIdentificacion + "\n" +
               "Titulo del Libro: " + Titulo + "\n" + 
               "Autor: " + Autor + "\n" + 
               "Estado: " + Estado;
    }
}
