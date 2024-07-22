/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajo_clase;

/**
 *
 * @author Administrator
 */
public class EmpleadoPorHora {
    private String nombre;
    private int horasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoPorHora(String nombre, double tarifaPorHora) {
        this.nombre = nombre;
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void asignarHoras(int horas) {
        this.horasTrabajadas += horas;
    }

    public double calcularPago() {
        return horasTrabajadas * tarifaPorHora;
    }

    public void resetHoras() {
        this.horasTrabajadas = 0;
    }

    public String toString() {
        return "Empleado: " + nombre + ", Horas trabajadas: " + horasTrabajadas + ", Tarifa por hora: " + tarifaPorHora;
    }
}