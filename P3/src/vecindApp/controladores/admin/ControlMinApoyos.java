package vecindApp.controladores.admin;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.admin.MinApoyos;

public class ControlMinApoyos {
    private MinApoyos vista;
    private Ventana frame;
    private Aplicacion modelo;

    public ControlMinApoyos(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeAdmin().getpMinApoyos();
        this.modelo = modelo;
    }
}
