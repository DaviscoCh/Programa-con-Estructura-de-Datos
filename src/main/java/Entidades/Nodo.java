/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Entidades.Usuario;

/**
 *
 * @author hp
 */
public class Nodo<T> {

    T dato; // Dato almacenado en el nodo
    Nodo<T> siguiente; // Referencia al siguiente nodo

    // Constructor del nodo
    Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null; // Al crear un nodo, el siguiente es nulo por defecto
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public static Usuario[] ArregloUsuarios() {
        return new Usuario[]{
            new Usuario(1, "Juan Pérez"),
            new Usuario(2, "Ana García"),
            new Usuario(3, "Samuel Villareal"),
            new Usuario(4, "Melina Gonzales"),
            new Usuario(5, "Carlos Zambrano")
        };
    }

    public static Libro[] ArregloLibro() {
        return new Libro[]{
            new Libro(1, "Cien Años de Soledad", "Gabriel García Márquez", "Disponible"),
            new Libro(2, "Don Quijote de la Mancha", "Miguel de Cervantes", "Disponible"),
            new Libro(3, "Lo que el Viento se llevo", "Margaret Mitchell", "Disponible"),
            new Libro(4, "El diario de Ana Frank", "Ana Frank", "Disponible"),
            new Libro(5, "El alquimista", "Paulo Coelho", "Disponible")
        };
    }
}
