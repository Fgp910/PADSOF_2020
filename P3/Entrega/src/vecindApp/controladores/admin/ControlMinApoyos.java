package vecindApp.controladores.admin;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.vistas.admin.MinApoyos;
import vecindApp.vistas.home.HomeAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Define el controlador para la vista de configuracion del minimo de apoyos.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ControlMinApoyos implements ActionListener {
    private MinApoyos vista;
    private HomeAdmin<Notificacion, ElementoColectivo> frame;
    private Aplicacion modelo;

    /**
     * Crea el controlador para la vista de configuracion del minimo de apoyos
     * @param frame el componente padre (la vista principal del administrador)
     * @param modelo la aplicacion fuente
     */
    public ControlMinApoyos(HomeAdmin<Notificacion, ElementoColectivo> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getMinApoyos();
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
