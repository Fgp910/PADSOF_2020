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
        int nm = Integer.parseInt(newMin);
        modelo.setMinApoyos(nm);
        vista.update(newMin);
    }
}
