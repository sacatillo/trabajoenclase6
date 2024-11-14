/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabajo;

/**
 *
 * @author Martin Montes
 */
import java.util.Scanner;

// Clase base Empleado
class Empleado {
    private String nombre;
    private double salario;
    private String genero;
    private int edad;
    private int aniosTrabajo;

    // Constructor
    public Empleado(String nombre, double salario, String genero, int edad, int aniosTrabajo) {
        this.nombre = nombre;
        this.salario = salario;
        this.genero = genero;
        this.edad = edad;
        this.aniosTrabajo = aniosTrabajo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public int getAniosTrabajo() {
        return aniosTrabajo;
    }
}

// Subclase Bonificacion que hereda de Empleado
class Bonificacion extends Empleado {
    private double bonificacion;

    // Constructor
    public Bonificacion(String nombre, double salario, String genero, int edad, int aniosTrabajo) {
        super(nombre, salario, genero, edad, aniosTrabajo);
        this.bonificacion = calcularBonificacion();
    }

    // Método para calcular la bonificación
    private double calcularBonificacion() {
        double salario = getSalario();
        int aniosTrabajo = getAniosTrabajo();
        double bonificacion = 0;

        if (salario > 45000) {
            bonificacion = salario * 0.20;
        } else if (salario > 25000 && salario <= 45000 && aniosTrabajo > 7) {
            bonificacion = salario * 0.15;
        } else if (salario > 18900 && aniosTrabajo > 5) {
            bonificacion = salario * 0.10;
        }

        return bonificacion;
    }

    // Método para calcular el salario final con bonificación
    public double calcularSalarioFinal() {
        return getSalario() + bonificacion;
    }
}

// Clase principal para probar la implementación
public class Salario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar datos al usuario
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese el salario del empleado: ");
        double salario = scanner.nextDouble();
        
        System.out.print("Ingrese el genero del empleado: ");
        String genero = scanner.next(); // Asumimos que el género es una sola palabra
        
        System.out.print("Ingrese la edad del empleado: ");
        int edad = scanner.nextInt();
        
        System.out.print("Ingrese la longevidad de trabajo del empleado: ");
        int aniosTrabajo = scanner.nextInt();

        // Crear instancia de Bonificacion
        Bonificacion empleado = new Bonificacion(nombre, salario, genero, edad, aniosTrabajo);
        
        // Mostrar el salario final
        System.out.println("Salario final de " + empleado.getNombre() + ": " + empleado.calcularSalarioFinal());

        // Cerrar el scanner
        scanner.close();
    }
}