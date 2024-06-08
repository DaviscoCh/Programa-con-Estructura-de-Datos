/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author hp
 */
public class Pila<T> {

    private Stack<T> pila;

    public Pila() {
        this.pila = new Stack<>();
    }

    public void agregar(T elemento) {
        pila.push(elemento);
    }

    public T remover() {
        return pila.isEmpty() ? null : pila.pop();
    }

    public T mirarFrente() {
        return pila.isEmpty() ? null : pila.peek();
    }

    public boolean estaVacia() {
        return pila.isEmpty();
    }

    public void imprimirPila() {
        if (pila.isEmpty()) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Elementos en la pila:");
            int i = 1;
            for (T elemento : pila) {
                System.out.println(elemento.toString());
                i++;
            }
        }
    }
    public Iterator<T> iterator() {
        return pila.iterator();
    }
    
     public Stack<T> obtenerTodosLosElementos() {
        return (Stack<T>) pila.clone();
    }
}
