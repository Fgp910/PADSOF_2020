package vecindApp.main;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.controladores.Controlador;
import vecindApp.vistas.Ventana;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventana<Notificacion, Proyecto, Ciudadano> frame = new Ventana<>();
                    Aplicacion modelo = Aplicacion.VecindApp;
                    Controlador controlador = new Controlador(frame, modelo);
                    frame.setControlador(controlador);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
