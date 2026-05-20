package Controlador;

import Modelo.ModeloSopa;
import Vista.GUISopa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorSopa implements ActionListener {

    private GUISopa vista;
    private ModeloSopa modelo;

    public ControladorSopa(GUISopa vista, ModeloSopa modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.getBAñadir().addActionListener(this);
        this.vista.getBEliminar().addActionListener(this);
        this.vista.getBConsultarPalabras().addActionListener(this);
        this.vista.getBGenerarSopaLetras().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getBAñadir()) {
            añadirPalabra();
        }

        if (e.getSource() == vista.getBEliminar()) {
            eliminarPalabra();
        }

        if (e.getSource() == vista.getBConsultarPalabras()) {
            consultarPalabras();
        }

        if (e.getSource() == vista.getBGenerarSopaLetras()) {
            generarSopa();
        }
    }

   private void añadirPalabra() {

    String palabra = vista.getTfPalabra().getText().trim();

    if (palabra.isEmpty()) {
        JOptionPane.showMessageDialog(
                vista,
                "Introduce una palabra"
        );
        return;
    }

    if (palabra.length() > 10) {
        JOptionPane.showMessageDialog(vista, "La palabra supera el tamaño máximo permitido (10 letras)");
        vista.getTfPalabra().setText("");
        return;
    }

    if (palabra.contains(" ")) {
        JOptionPane.showMessageDialog(vista, "Las palabras no pueden contener espacios");
        vista.getTfPalabra().setText("");
        return;
    }

    boolean insertada = modelo.insertarPalabra(palabra);

    if (insertada) {

        JOptionPane.showMessageDialog(vista, "Palabra añadida :D");

        vista.getTfPalabra().setText("");

        consultarPalabras();

    } else {

        JOptionPane.showMessageDialog(vista, "No se pudo añadir la palabra (puede que ya exista)");

    }
}

    private void eliminarPalabra() {
        String palabra = vista.getTfPalabra().getText().trim();

        if (palabra.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Introduce una palabra para eliminar");
            return;
        }

        boolean eliminada = modelo.eliminarPalabra(palabra);

        if (eliminada) {
            JOptionPane.showMessageDialog(vista, "Palabra eliminada :D");
            vista.getTfPalabra().setText("");
            consultarPalabras();
        } else {
            JOptionPane.showMessageDialog(vista, "La palabra no existe");
        }
    }

    private void consultarPalabras() {
        String texto = modelo.consultarPalabrasTexto();
        vista.getTaConsultarPalabras().setText(texto);
    }

    private void generarSopa() {
        GeneradorSopaLetras generador = new GeneradorSopaLetras();

        String palabras = modelo.consultarPalabrasTexto();

        if (palabras.trim().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "No hay palabras en la base de datos");
            return;
        }

        palabras = palabras.replace("\n", ",");

        String sopa = generador.generarSopa(palabras);

        vista.getTaSopaLetras().setText(sopa);
    }
}
