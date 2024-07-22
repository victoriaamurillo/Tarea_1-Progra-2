/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajo_clase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Administrator
 */


public class TestEmpresa extends JFrame {
    private Empresa empresa;
    private JTextArea textArea;
    private JTextField nombreField, tarifaField, horasField;

    public TestEmpresa() {
        empresa = new Empresa();
        setTitle("Gestión de Empleados por Hora");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior para botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.setBackground(Color.DARK_GRAY);

        JButton agregarButton = new JButton("Agregar Empleado");
        JButton mostrarButton = new JButton("Mostrar Empleados");
        JButton asignarHorasButton = new JButton("Asignar Horas");
        JButton pagarButton = new JButton("Pagar Empleado");

        agregarButton.setBackground(new Color(70, 130, 180));
        agregarButton.setForeground(Color.WHITE);
        mostrarButton.setBackground(new Color(70, 130, 180));
        mostrarButton.setForeground(Color.WHITE);
        asignarHorasButton.setBackground(new Color(70, 130, 180));
        asignarHorasButton.setForeground(Color.WHITE);
        pagarButton.setBackground(new Color(70, 130, 180));
        pagarButton.setForeground(Color.WHITE);

        agregarButton.setFocusPainted(false);
        mostrarButton.setFocusPainted(false);
        asignarHorasButton.setFocusPainted(false);
        pagarButton.setFocusPainted(false);

        panelBotones.add(agregarButton);
        panelBotones.add(asignarHorasButton);
        panelBotones.add(mostrarButton);
        panelBotones.add(pagarButton);

        add(panelBotones, BorderLayout.NORTH);

        // Área de texto para mostrar detalles de empleados
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Color.BLACK);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Panel para campos de entrada
        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new GridLayout(3, 2, 10, 10));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCampos.setBackground(Color.LIGHT_GRAY);

        panelCampos.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panelCampos.add(nombreField);

        panelCampos.add(new JLabel("Tarifa por hora:"));
        tarifaField = new JTextField();
        panelCampos.add(tarifaField);

        panelCampos.add(new JLabel("Horas a asignar:"));
        horasField = new JTextField();
        panelCampos.add(horasField);

        add(panelCampos, BorderLayout.SOUTH);

        // Acciones de los botones
        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarEmpleado();
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarEmpleados();
            }
        });

        asignarHorasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                asignarHoras();
            }
        });

        pagarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pagarEmpleado();
            }
        });
    }

    // Método para agregar un empleado
    private void agregarEmpleado() {
        try {
            String nombre = nombreField.getText();
            double tarifa = Double.parseDouble(tarifaField.getText());
            empresa.agregarEmpleado(new EmpleadoPorHora(nombre, tarifa));
            textArea.append("Empleado agregado: " + nombre + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para mostrar todos los empleados
    private void mostrarEmpleados() {
        textArea.setText(empresa.mostrarEmpleados());
    }

    // Método para asignar horas a un empleado
    private void asignarHoras() {
        try {
            String nombre = nombreField.getText();
            int horas = Integer.parseInt(horasField.getText());
            empresa.asignarHoras(nombre, horas);
            textArea.append("Horas asignadas a " + nombre + ": " + horas + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para pagar a un empleado
    private void pagarEmpleado() {
        String nombre = nombreField.getText();
        double pago = empresa.pagarEmpleado(nombre);
        textArea.append("Pago realizado a " + nombre + ": " + pago + "\n");
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestEmpresa().setVisible(true);
            }
        });
    }
}