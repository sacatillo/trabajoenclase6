/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabajo2;

/**
 *
 * @author Martin Montes
 */
import java.util.Scanner; // Importamos la clase Scanner para leer la entrada del usuario

// Clase Libro que representa un libro con sus atributos y métodos
class Libro {
    // Atributos de la clase Libro
    private String titulo; // Título del libro
    private String autor;  // Autor del libro
    private String isbn;   // ISBN del libro
    private double precio; // Precio del libro

    // Constructor de la clase Libro
    public Libro(String titulo, String autor, String isbn, double precio) {
        this.titulo = titulo; // Inicializa el título
        this.autor = autor;   // Inicializa el autor
        this.isbn = isbn;     // Inicializa el ISBN
        this.precio = precio; // Inicializa el precio
    }

    // Método para mostrar los detalles del libro
    public void mostrarDetalles() {
        System.out.println("Titulo: " + titulo); // Muestra el título
        System.out.println("Autor: " + autor);    // Muestra el autor
        System.out.println("ISBN: " + isbn);       // Muestra el ISBN
        System.out.println("Precio: Lps. " + precio); // Muestra el precio
    }

    // Método para aplicar un descuento basado en la edad del cliente
    public double aplicarDescuento(int edad) {
        double descuento; // Variable para almacenar el porcentaje de descuento
        // Determina el porcentaje de descuento basado en la edad
        if (edad > 25) {
            descuento = 0.25; // 25% de descuento si el cliente es mayor de 25 años
        } else {
            descuento = 0.10; // 10% de descuento si el cliente es 25 años o menor
        }
        // Calcula y devuelve el precio después de aplicar el descuento
        return precio - (precio * descuento);
    }
}

// Clase principal para probar la implementación
public class Libros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer datos del usuario
        
        // Solicitar datos del libro al usuario
        System.out.print("Ingrese el titulo del libro: ");
        String titulo = scanner.nextLine(); // Lee el título del libro
        
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine(); // Lee el autor del libro
        
        System.out.print("Ingrese el ISBN del libro: ");
        String isbn = scanner.nextLine(); // Lee el ISBN del libro
        
        System.out.print("Ingrese el precio del libro: ");
        double precio = scanner.nextDouble(); // Lee el precio del libro
        
        // Crear una instancia de la clase Libro con los datos ingresados
        Libro libro = new Libro(titulo, autor, isbn, precio);
        
        // Mostrar los detalles del libro
        libro.mostrarDetalles();
        
        // Solicitar la edad del cliente
        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt(); // Lee la edad del cliente
        
        // Calcular el precio con descuento y mostrarlo
        double precioConDescuento = libro.aplicarDescuento(edad); // Aplica el descuento
        System.out.println("Precio final despues del descuento: Lps. " + precioConDescuento); // Muestra el precio final
        
        // Cerrar el scanner para evitar fugas de recursos
        scanner.close();
    }
}