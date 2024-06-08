/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class ListaSimple<T> {
    private Nodo<T> cabeza; // Cabeza de la lista

    // Constructor de la lista
    public ListaSimple() {
        this.cabeza = null; // La lista está vacía inicialmente
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }
    
    // Método para agregar un elemento a la lista
    public void agregar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato); // Crear un nuevo nodo con el dato
        if (cabeza == null) {
            cabeza = nuevoNodo; // Si la lista está vacía, el nuevo nodo es la cabeza
        } else {
            Nodo<T> temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente; // Recorrer la lista hasta el último nodo
            }
            temp.siguiente = nuevoNodo; // Añadir el nuevo nodo al final
        }
    }

    // Método para imprimir la lista
    public void imprimirLista() {
        Nodo<T> temp = cabeza;
        while (temp != null) {
            System.out.println(temp.dato); // Imprimir el dato del nodo actual
            temp = temp.siguiente; // Pasar al siguiente nodo
        }
    }

    // Método para buscar un elemento en la lista
    public boolean buscar(T dato) {
        Nodo<T> temp = cabeza;
        while (temp != null) {
            if (temp.dato.equals(dato)) {
                return true; // Si se encuentra el dato, devolver verdadero
            }
            temp = temp.siguiente; // Pasar al siguiente nodo
        }
        return false; // Si no se encuentra el dato, devolver falso
    }

    // Método para eliminar un elemento de la lista
    public void eliminar(T dato) {
        if (cabeza == null) {
            return; // Si la lista está vacía, no hay nada que eliminar
        }
        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente; // Si el dato está en la cabeza, cambiar la cabeza
            return;
        }
        Nodo<T> temp = cabeza;
        while (temp.siguiente != null) {
            if (temp.siguiente.dato.equals(dato)) {
                temp.siguiente = temp.siguiente.siguiente; // Eliminar el nodo con el dato
                return;
            }
            temp = temp.siguiente; // Pasar al siguiente nodo
        }
    }
    
    public List<T> obtenerTodosLosElementos() {
        List<T> listaElementos = new ArrayList<>();
        Nodo<T> temp = cabeza;
        while (temp != null) {
            listaElementos.add(temp.dato);
            temp = temp.siguiente;
        }
        return listaElementos;
    }
    
}
