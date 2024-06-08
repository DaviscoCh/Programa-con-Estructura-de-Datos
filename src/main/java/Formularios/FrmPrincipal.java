/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import Entidades.Algoritmos;
import Entidades.Cola;
import Entidades.Libro;
import Entidades.Pila;
import Entidades.Prestamo;
import Entidades.Usuario;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */

public class FrmPrincipal extends javax.swing.JFrame {

    public Lista_Libros frmListaLibros;
    public Lista_Usuarios frmListaUsuarios;

    public Cola<Prestamo> colaPrestamos;
    public Algoritmos algoritmo;
    public Pila<Prestamo> pilaDevoluciones;

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        setLocationRelativeTo(this);
        setSize(700, 590);
        frmListaLibros = new Lista_Libros();
        frmListaUsuarios = new Lista_Usuarios();

        colaPrestamos = new Cola<>();
        pilaDevoluciones = new Pila<>();
        algoritmo = new Algoritmos(frmListaUsuarios.ListaUsuarios, frmListaLibros.ListaLibro, colaPrestamos, pilaDevoluciones, frmListaLibros);
    }

    /////////////////////////////////////////////////METODOS DE ORDENAMIENTO
    private void ordenarYMostrarLibros() {
        List<Libro> libros = frmListaLibros.obtenerListaLibros();
        Algoritmos.ordenarLibrosPorTitulo(libros); // Ordenar los libros

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Libros ordenados:\n");
        for (Libro libro : libros) {
            mensaje.append(libro.getTitulo()).append("\n"); // Agregar cada libro al mensaje
        }

        JOptionPane.showMessageDialog(this, mensaje.toString(), "Libros Ordenados", JOptionPane.INFORMATION_MESSAGE);
    }

    private void ordenarYMostrarUsuarios() {
        List<Usuario> usuarios = frmListaUsuarios.obtenerListaUsuarios();
        Algoritmos.ordenarUsuariosPorNombre(usuarios); // Ordenar los usuarios

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Usuarios ordenados:\n");
        for (Usuario usuario : usuarios) {
            mensaje.append(usuario.getNombre()).append("\n"); // Agregar solo el nombre de cada usuario al mensaje
        }
        JOptionPane.showMessageDialog(this, mensaje.toString(), "Usuarios Ordenados", JOptionPane.INFORMATION_MESSAGE);
    }

    ///////////////////////////////////////////////////////PRESENTACION DE LA COLA PRESTAMOS
    private void mostrarColaPrestamos() {
        if (colaPrestamos.estaVacia()) {
            JOptionPane.showMessageDialog(this, "No hay préstamos en la cola.");
        } else {
            StringBuilder prestamosStr = new StringBuilder();
            for (Prestamo prestamo : colaPrestamos) {  // Ya puedes usar el bucle for-each
                prestamosStr.append("Usuario: ").append(prestamo.getUsuario().getNombre())
                        .append(" - Libro: ").append(prestamo.getLibro().getTitulo())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(this, prestamosStr.toString(), "Préstamos en Cola", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //////////////////////////////////////////////////////////////PRESTAR LIBROS
    // Método para realizar préstamo de un libro a un usuario
    public void prestarLibro(int idUsuario, int idLibro) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Libro libro = buscarLibroPorId(idLibro);

        if (usuario != null && libro != null && libro.getEstado().equals("Disponible")) {
            Prestamo prestamo = new Prestamo(usuario, libro);
            colaPrestamos.agregar(prestamo);  // Agregar el préstamo a la cola
            libro.setEstado("Prestado");
            frmListaLibros.actualizarJListL();  // Actualizar la lista de libros en el formulario
            JOptionPane.showMessageDialog(this, "Préstamo realizado con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al realizar el préstamo.");
        }
    }

    // Métodos de búsqueda de usuario y libro por ID
    private Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : frmListaUsuarios.obtenerListaUsuarios()) {
            if (usuario.getNIdentificacionU() == id) {
                return usuario;
            }
        }
        return null;
    }

    private Libro buscarLibroPorId(int id) {
        for (Libro libro : frmListaLibros.obtenerListaLibros()) {
            if (libro.getNumeroIdentificacion() == id) {
                return libro;
            }
        }
        return null;
    }

    /////////////////////////////////////////////////////////////////DEVOLUCION DE LIBROS
    public void devolverFrente() {
        System.out.println("Debugging: Iniciando devolverFrente()");
        if (colaPrestamos.estaVacia()) {
            JOptionPane.showMessageDialog(this, "No hay préstamos para devolver.");
            return;
        }

        Prestamo prestamo = colaPrestamos.mirarFrente(); // Obtener el préstamo al frente de la cola
        Libro libro = prestamo.getLibro();
        libro.setEstado("Disponible");  // Cambiar el estado del libro
        colaPrestamos.remover();  // Remover el préstamo de la cola
        pilaDevoluciones.agregar(prestamo);  // Agregar el préstamo a la pila de devoluciones
        frmListaLibros.actualizarJListL();  // Actualizar la lista de libros en el formulario

        JOptionPane.showMessageDialog(this, "Devolución realizada con éxito.\n"
                + "Usuario: " + prestamo.getUsuario().getNombre() + "\n"
                + "Libro: " + prestamo.getLibro().getTitulo());
        System.out.println("Debugging: Finalizando devolverFrente()");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Biblioteca de la Real Academia Española");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Registrar Libro:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setText("N.Identificacion:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel4.setText("Titulo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel5.setText("Autor:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel6.setText("Estado:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 72, 140, 30));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 102, 140, 30));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 132, 140, 30));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 162, 140, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Buscar un Libro:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel8.setText("Ingrese el Titulo del Libro a Buscar:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 180, 30));

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 80, 30));

        jButton2.setText("Ordenar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 80, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Eliminar un Libro:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel10.setText("Ingrese el Titulo del Libro a Eliminar:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 180, 30));

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 80, 30));

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 80, 30));

        jButton5.setText("Imprimir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 60, 30));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 60, 30));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 60, 30));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 60, 30));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 60, 30));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 60, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Registrar un Usuario:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));

        jLabel12.setText("N.Identificacion:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, -1));

        jLabel13.setText("Nombre:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 140, 30));

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 140, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Eliminar un Usuario:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        jLabel15.setText("Ingrese el Nombre del Usuario a Eliminar:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, -1));
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 150, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Buscar un Usuario:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, -1, -1));

        jLabel17.setText("Ingrese el Nombre del Usuario a Buscar:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));
        getContentPane().add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 150, 30));

        jButton6.setText("Ingresar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 80, 30));

        jButton7.setText("Ordenar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 80, 30));

        jButton8.setText("Imprimir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, -1, 30));

        jButton9.setText("Eliminar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 80, 30));

        jButton10.setText("Buscar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 80, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Realizar el Prestamo de un Libro:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        jLabel19.setText("ID_Usuario:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jLabel20.setText("ID_Libro:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));
        getContentPane().add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 150, 30));
        getContentPane().add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 150, 30));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 60, 30));
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 650, 10));

        jButton11.setText("Prestar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 80, -1));

        jButton13.setText("Imprimir Cola de Prestaciones");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, -1, -1));

        jButton12.setText("Imprimir Pila de Devoluciones");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, -1, -1));

        jButton14.setText("Devolver");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 90, -1));

        jButton15.setText("Eliminar.D");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        frmListaLibros.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        frmListaUsuarios.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int NI = Integer.parseInt(jTextField1.getText());
        String Titulo = jTextField2.getText();
        String Autor = jTextField3.getText();
        String Estado = jTextField4.getText();
        Libro NuevoLibro = new Libro(NI, Titulo, Autor, Estado);
        frmListaLibros.ListaLibro.agregar(NuevoLibro);
        frmListaLibros.actualizarJListL();
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int NIU = Integer.parseInt(jTextField7.getText());
        String Nombre = jTextField8.getText();
        Usuario NuevoUsuario = new Usuario(NIU, Nombre);
        frmListaUsuarios.ListaUsuarios.agregar(NuevoUsuario);
        frmListaUsuarios.actualizarJListL();
        jTextField7.setText("");
        jTextField8.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String NLE = jTextField5.getText();
        Libro libroeliminar = algoritmo.buscarLibroPorTitulo(frmListaLibros.ListaLibro, NLE);
        if (libroeliminar != null) {
            frmListaLibros.ListaLibro.eliminar(libroeliminar);
            frmListaLibros.actualizarJListL();
            JOptionPane.showMessageDialog(null, "Se ha eliminado con exito el Libro: " + libroeliminar.toString());
        } else {
            JOptionPane.showMessageDialog(null, "El libro que ha ingresado no se encuentra en la lista");
        }
        jTextField5.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String NLB = jTextField6.getText();
        Libro librobuscar = algoritmo.buscarLibroPorTitulo(frmListaLibros.ListaLibro, NLB);
        if (librobuscar != null) {
            JOptionPane.showMessageDialog(null, "Se ha localizado con exito el libro buscado\n"
                    + librobuscar.toString());
        } else {
            JOptionPane.showMessageDialog(null, "El libro que ha ingresado no se encuentra en la lista");
        }
        jTextField6.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ordenarYMostrarLibros();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        ordenarYMostrarUsuarios();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String NUE = jTextField9.getText();
        List<Usuario> usuarios = frmListaUsuarios.obtenerListaUsuarios();
        Algoritmos.ordenarUsuariosPorNombre(usuarios);
        Usuario usuarioeliminar = Algoritmos.buscarUsuarioPorNombre(usuarios, NUE);
        if (usuarioeliminar != null) {
            frmListaUsuarios.ListaUsuarios.eliminar(usuarioeliminar);
            frmListaUsuarios.actualizarJListL();
            JOptionPane.showMessageDialog(null, "Se ha eliminado con exito el Usuario: " + usuarioeliminar.toString());
        } else {
            JOptionPane.showMessageDialog(null, "El Usuario que ha ingresado no se encuentra en la lista");
        }
        jTextField9.setText("");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        String nombreUsuario = jTextField10.getText();
        List<Usuario> usuarios = frmListaUsuarios.obtenerListaUsuarios();

        Algoritmos.ordenarUsuariosPorNombre(usuarios);

        Usuario usuario = Algoritmos.buscarUsuarioPorNombre(usuarios, nombreUsuario);

        if (usuario != null) {
            JOptionPane.showMessageDialog(this, "Usuario encontrado: " + usuario.getNombre() + "\nNumero Identificacion: " + usuario.getNIdentificacionU(),
                    "Búsqueda de Usuario", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado", "Búsqueda de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        jTextField10.setText(""); // Limpiar el campo de texto
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        int idUsuario = Integer.parseInt(jTextField11.getText());
        int idLibro = Integer.parseInt(jTextField12.getText());
        prestarLibro(idUsuario, idLibro);
        jTextField11.setText("");
        jTextField12.setText("");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        mostrarColaPrestamos();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        algoritmo.mostrarPilaDevoluciones();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        devolverFrente();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        if (pilaDevoluciones.estaVacia()) {
            JOptionPane.showMessageDialog(this, "La pila de devoluciones está vacía.");
            return;
        }

        Prestamo ultimoElemento = pilaDevoluciones.remover();
        JOptionPane.showMessageDialog(this, "Se eliminó el último elemento de la pila de devoluciones.\n"
                + "Usuario: " + ultimoElemento.getUsuario().getNombre() + "\n"
                + "Libro: " + ultimoElemento.getLibro().getTitulo());
    }//GEN-LAST:event_jButton15ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new FrmPrincipal().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
