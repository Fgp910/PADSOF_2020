package vecindApp.controladores.admin;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.admin.Bloquear;

public class ControlBloquear {
    private Bloquear vista;
    private Ventana frame;
    private Aplicacion modelo;

    public ControlBloquear(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeAdmin().getpBloquear();
        this.modelo = modelo;
    }
}
