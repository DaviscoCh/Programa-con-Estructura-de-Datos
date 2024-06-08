/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author hp
 */
public class Usuario {
    private int NIdentificacionU;
    private String Nombre;

    public Usuario() {
    }

    public Usuario(int NIdentificacionU, String Nombre) {
        this.NIdentificacionU = NIdentificacionU;
        this.Nombre = Nombre;
    }

    public int getNIdentificacionU() {
        return NIdentificacionU;
    }

    public void setNIdentificacionU(int NIdentificacionU) {
        this.NIdentificacionU = NIdentificacionU;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    @Override
    public String toString(){
        return "N.Identificacion del usuario: " + NIdentificacionU + "\n" +
               "Nombre del Usuario: " + Nombre;
    }
}
