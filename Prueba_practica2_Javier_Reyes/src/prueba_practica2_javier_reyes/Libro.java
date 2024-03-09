/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba_practica2_javier_reyes;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Javier Reyes
 */
public class Libro {
    private String nombre;
    private String autor;
    private String ID;
    private String estado;
    private String dueño;

    public Libro(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
        this.ID = generarID();
        this.estado = "disponible";
        this.dueño = "";
    }

    private String generarID() {
        Random random = new Random();
        String id = "";
        for (int i = 0; i < 6; i++) {
            id += random.nextInt(10);
        }
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getAutor() {
        return autor;
    }

    public String getID() {
        return ID;
    }

    public String getEstado() {
        return estado;
    }

    public String getDueño() {
        return dueño;
    }

    public void prestar(String solicitante) {
        if (estado.equals("disponible")) {
            estado = "prestado";
            dueño = solicitante;
            System.out.println("Libro prestado a " + solicitante);
        } else {
            System.out.println("El libro no está disponible en este momento.");
        }
    }

    public void regresar() {
        if (estado.equals("prestado")) {
            estado = "disponible";
            dueño = "";
            System.out.println("Libro devuelto correctamente.");
        } else {
            System.out.println("El libro no estaba prestado.");
        }
    }
    
}
