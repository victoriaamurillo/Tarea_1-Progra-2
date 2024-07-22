/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajo_clase;
/**
 *
 * @author Administrator
 */

public class Empresa {
    private Nodo cabeza;

    private class Nodo {
        EmpleadoPorHora empleado;
        Nodo siguiente;

        Nodo(EmpleadoPorHora empleado) {
            this.empleado = empleado;
            this.siguiente = null;
        }
    }

    public Empresa() {
        cabeza = null;
    }

    public void agregarEmpleado(EmpleadoPorHora empleado) {
        Nodo nuevoNodo = new Nodo(empleado);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public EmpleadoPorHora buscarEmpleado(String nombre) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.empleado.getNombre().equals(nombre)) {
                return actual.empleado;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public String mostrarEmpleados() {
        StringBuilder sb = new StringBuilder();
        Nodo actual = cabeza;
        while (actual != null) {
            sb.append(actual.empleado.toString()).append("\n");
            actual = actual.siguiente;
        }
        return sb.toString();
    }

    public void asignarHoras(String nombre, int horas) {
        EmpleadoPorHora emp = buscarEmpleado(nombre);
        if (emp != null) {
            emp.asignarHoras(horas);
        }
    }

    public double pagarEmpleado(String nombre) {
        EmpleadoPorHora emp = buscarEmpleado(nombre);
        if (emp != null) {
            double pago = emp.calcularPago();
            emp.resetHoras();
            return pago;
        }
        return 0;
    }
}
