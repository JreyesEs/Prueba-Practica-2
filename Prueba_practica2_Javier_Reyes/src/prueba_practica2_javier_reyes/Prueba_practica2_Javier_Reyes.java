/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba_practica2_javier_reyes;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Javier Reyes
 */
public class Prueba_practica2_Javier_Reyes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner book = new Scanner(System.in);
        int maxLibros = 10; // limite de libros que se pueden ingresar
        Libro[] biblioteca = new Libro[maxLibros];
        int cLibros = 0; //cantidad de libros

        System.out.println("Este es el menú de la prueba practica 2 ");
        while (true) {
            
            System.out.println();
            System.out.println("Estas son las opciones que se pueden realizar:");
            System.out.println("1) Agregar Nuevo libro a la biblioteca");
            System.out.println("2) Solicitar libro");
            System.out.println("3) Regresar libro");
            System.out.println("4) Buscar libro por nombre");
            System.out.println("5) Listar libros disponibles");
            System.out.println("6) Listar libros prestados");
            System.out.println("7) Salir");

            int opcion = book.nextInt();
            book.nextLine(); 

            switch (opcion) {
                case 1:
                    if (cLibros < maxLibros) {
                        System.out.print("Ingrese el nombre del libro: ");
                        String nombreLibro = book.nextLine();
                        System.out.print("Ingrese el autor del libro: ");
                        String autorLibro = book.nextLine();
                        biblioteca[cLibros] = new Libro(nombreLibro, autorLibro);
                        cLibros++;
                        System.out.println("Libro agregado correctamente a la biblioteca.");
                    } else {
                        System.out.println("La biblioteca está llena, no se pueden agregar más libros.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese su nombre: ");
                    String solicitante = book.nextLine();
                    System.out.print("Ingrese la posición del libro que desea solicitar: ");
                    int pSolicitud = book.nextInt(); //posición del libro
                    book.nextLine(); 
                    if (pSolicitud >= 0 && pSolicitud < cLibros) {
                        biblioteca[pSolicitud].prestar(solicitante);
                    } else {
                        System.out.println("Posición inválida.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la posición del libro que desea devolver: ");
                    int pDevolucion = book.nextInt(); // posición para devolver el libro
                    book.nextLine(); 
                    if (pDevolucion >= 0 && pDevolucion < cLibros) {
                        biblioteca[pDevolucion].regresar();
                    } else {
                        System.out.println("Posición inválida.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del libro que desea buscar: ");
                    String nombreBuscar = book.nextLine();
                    for (int i = 0; i < cLibros; i++) {
                        if (biblioteca[i].getNombre().equalsIgnoreCase(nombreBuscar)) {
                            System.out.println("Libro encontrado:");
                            System.out.println("Nombre: " + biblioteca[i].getNombre());
                            System.out.println("Autor: " + biblioteca[i].getAutor());
                            System.out.println("ID: " + biblioteca[i].getID());
                            System.out.println("Estado: " + biblioteca[i].getEstado());
                            System.out.println("Dueño: " + biblioteca[i].getDueño());
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Libros disponibles:");
                    for (int i = 0; i < cLibros; i++) {
                        if (biblioteca[i].getEstado().equals("disponible")) {
                            System.out.println(i + ") " + biblioteca[i].getNombre());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Libros prestados:");
                    for (int i = 0; i < cLibros; i++) {
                        if (biblioteca[i].getEstado().equals("prestado")) {
                            System.out.println(i + ") " + biblioteca[i].getNombre() + " - Prestado a " + biblioteca[i].getDueño());
                        }
                    }
                    break;
                case 7:
                    System.out.println("Saliendo del programa, Gracias por usarlo...");
                    System.exit(0); // finaliza la ejecuión del programa
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
    
}
