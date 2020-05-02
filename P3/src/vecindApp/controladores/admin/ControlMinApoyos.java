package vecindApp.controladores.admin;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.admin.Desbloquear;
import vecindApp.vistas.admin.MinApoyos;
import vecindApp.vistas.home.HomeAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMinApoyos implements ActionListener {
    private MinApoyos vista;
    private HomeAdmin<Notificacion, Proyecto, ElementoColectivo> frame;
    private Aplicacion modelo;

    public ControlMinApoyos(HomeAdmin<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getpMinApoyos();
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String newMin = vista.getNewMin();
        try {
            int nm = Math.abs(Integer.parseInt(newMin));
            Aplicacion.setMinApoyos(nm);
            vista.update(newMin);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista,
                    "Valor inválido. Introduzca un número.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
