/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Formularios.Lista_Libros;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Algoritmos {

    private ListaSimple<Usuario> listaUsuarios;
    private ListaSimple<Libro> listaLibros;
    private Cola<Prestamo> colaPrestamos;
    private Pila<Prestamo> pilaDevoluciones;
    private Lista_Libros frmLista_Libros;

    public Algoritmos(ListaSimple<Usuario> listaUsuarios, ListaSimple<Libro> listaLibros, Cola<Prestamo> colaPrestamos, Pila<Prestamo> pilaDevoluciones, Lista_Libros frmLista_Libros) {
        this.listaUsuarios = listaUsuarios;
        this.listaLibros = listaLibros;
        this.colaPrestamos = colaPrestamos;
        this.pilaDevoluciones = pilaDevoluciones;
        this.frmLista_Libros = frmLista_Libros;
    }

    ///////////////////////CODIGOS PARA PRESTAR LIBROS//////////////////////////////////
    private Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : listaUsuarios.obtenerTodosLosElementos()) {
            if (usuario.getNIdentificacionU() == id) {
                return usuario;
            }
        }
        return null;
    }

    private Libro buscarLibroPorId(int id) {
        for (Libro libro : listaLibros.obtenerTodosLosElementos()) {
            if (libro.getNumeroIdentificacion() == id) {
                return libro;
            }
        }
        return null;
    }

    public void prestarLibro(int idUsuario, int idLibro) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Libro libro = buscarLibroPorId(idLibro);

        if (usuario != null && libro != null && libro.getEstado().equals("Disponible")) {
            Prestamo prestamo = new Prestamo(usuario, libro);
            colaPrestamos.agregar(prestamo);
            libro.setEstado("Prestado");
            JOptionPane.showMessageDialog(null, "Préstamo realizado con éxito.\n" + prestamo.toString());
        } else {
            JOptionPane.showMessageDialog(null, "El libro que intenta adquirir no se encuentra disponible en estos momentos");
        }
    }
    //////////////////////////////////////////////////////////////////////////////

    ////////////////////CODIGOS PARA DEVOLVER LIBROS//////////////////////////////
    // Método para mostrar la pila de devoluciones
    public void mostrarPilaDevoluciones() {
        if (pilaDevoluciones == null) {
        }
        if (pilaDevoluciones.estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay devoluciones en la pila.");
        } else {
            StringBuilder devolucionesStr = new StringBuilder();
            for (Prestamo prestamo : pilaDevoluciones.obtenerTodosLosElementos()) {
                devolucionesStr.append("Usuario: ").append(prestamo.getUsuario().getNombre())
                        .append(" - Libro: ").append(prestamo.getLibro().getTitulo())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, devolucionesStr.toString(), "Devoluciones en Pila", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    ///////////////////////////////////METODOS DE ORDENAMIENTO Y BUSQUEDA////////////////////////////////////////
    //Busqueda Lineal por Titulo del Libro
    public Libro buscarLibroPorTitulo(ListaSimple listaLibros, String titulo) {
        Nodo temp = listaLibros.getCabeza();
        while (temp != null) {
            Libro libro = (Libro) temp.getDato();
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
            temp = temp.getSiguiente();
        }
        return null; // Devuelve null si no encuentra el libro
    }

    // Método de ordenamiento por selección para ordenar libros por título
    public static void ordenarLibrosPorTitulo(List<Libro> libros) {
        int n = libros.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (libros.get(j).getTitulo().compareToIgnoreCase(libros.get(minIndex).getTitulo()) < 0) {
                    minIndex = j;
                }
            }
            // Intercambiar libros.get(i) con libros.get(minIndex)
            Libro temp = libros.get(i);
            libros.set(i, libros.get(minIndex));
            libros.set(minIndex, temp);
        }
    }

    // Nuevo método de ordenamiento por burbuja para usuarios
    public static void ordenarUsuariosPorNombre(List<Usuario> usuarios) {
        int n = usuarios.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (usuarios.get(j).getNombre().compareToIgnoreCase(usuarios.get(j + 1).getNombre()) > 0) {
                    Usuario temp = usuarios.get(j);
                    usuarios.set(j, usuarios.get(j + 1));
                    usuarios.set(j + 1, temp);
                }
            }
        }
    }

    //Busqueda Binaria
    public static Usuario buscarUsuarioPorNombre(List<Usuario> usuarios, String nombre) {
        int izquierda = 0;
        int derecha = usuarios.size() - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            Usuario usuarioMedio = usuarios.get(medio);
            int comparacion = usuarioMedio.getNombre().compareToIgnoreCase(nombre);

            if (comparacion == 0) {
                return usuarioMedio; // Nombre encontrado
            } else if (comparacion < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return null; // Devuelve null si no encuentra el usuario
    }
}
