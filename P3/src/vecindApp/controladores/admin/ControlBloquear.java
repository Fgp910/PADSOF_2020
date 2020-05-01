package vecindApp.controladores.admin;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.notificacion.NotificacionProy;
import vecindApp.clases.notificacion.NotificacionReg;
import vecindApp.clases.proyecto.EstadoProyecto;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.clases.usuario.Usuario;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.admin.Bloquear;
import vecindApp.vistas.home.HomeAdmin;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlBloquear implements ListSelectionListener, ActionListener {
    private Bloquear<ElementoColectivo> vista;
    private HomeAdmin<Notificacion, Proyecto, ElementoColectivo> frame;
    private Aplicacion modelo;

    public ControlBloquear(HomeAdmin<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getpBloquear();
        this.modelo = modelo;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (vista.getLista().getSelectedValue() == null) {
                vista.getOpenButton().setEnabled(false);
            } else {
                vista.getOpenButton().setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int index = vista.getLista().getSelectedIndex();
        if (index > -1) {
            Ciudadano c = (Ciudadano) vista.getItem(index);
            c.setBloqueado(true);
            vista.remove(c);
            frame.getpDesbloquear().add(c);
        }
    }
}
