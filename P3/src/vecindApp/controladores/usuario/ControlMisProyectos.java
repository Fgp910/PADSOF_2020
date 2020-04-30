package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.ConsultarProyectos;
import vecindApp.vistas.usuario.MisProyectos;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMisProyectos implements ListSelectionListener, ActionListener {
    private MisProyectos<Proyecto> vista;
    private Ventana<Notificacion> frame;
    private Aplicacion modelo;

    public ControlMisProyectos(Ventana<Notificacion> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getpConsultarProyectos();
        this.modelo = modelo;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            Proyecto selec = vista.getLista().getSelectedValue();
            if (selec == null) {
                vista.getPopularButton().setEnabled(false);
            } else {
                vista.getPopularButton().setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
