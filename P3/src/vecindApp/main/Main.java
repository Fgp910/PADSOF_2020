package vecindApp.main;

import es.uam.eps.sadp.grants.CCGG;
import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.controladores.Controlador;
import vecindApp.pruebas.FechaSimulada;
import vecindApp.vistas.Ventana;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    /*Simulacion temporal*/
                    CCGG proxy = CCGG.getGateway();
                    proxy.setDate(FechaSimulada.getHoy());

                    Ventana<Notificacion, Proyecto, ElementoColectivo> frame = new Ventana<>();
                    try {
                        Aplicacion.cargar(Aplicacion.PATH);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,
                                "Fichero de carga inexistente o corrompido.\nCreando sistema en blanco.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    Aplicacion.setNow(FechaSimulada.getHoy());
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
