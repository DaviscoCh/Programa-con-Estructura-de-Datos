/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author hp
 */
public class Cola<T> implements Iterable<T> {

    private Queue<T> cola;

    public Cola() {
        this.cola = new LinkedList<>();
    }

    public void agregar(T elemento) {
        cola.add(elemento);
    }

    public T remover() {
        return cola.poll();
    }

    public T mirarFrente() {
        return cola.peek();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public void imprimirCola() {
        if (cola.isEmpty()) {
            System.out.println("La cola está vacía.");
        } else {
            System.out.println("Elementos en la cola: ");
            int i = 1;
            for (T elemento : cola) {
                System.out.println(elemento.toString());
                i++;
            }
        }
    }

  public Queue<T> obtenerTodosLosElementos() {
        return new LinkedList<>(cola);
    }

    public Iterator<T> iterator() {
        return cola.iterator();
    }

}
