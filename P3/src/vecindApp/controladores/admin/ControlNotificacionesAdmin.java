package vecindApp.controladores.admin;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.notificacion.NotificacionProy;
import vecindApp.clases.notificacion.NotificacionReg;
import vecindApp.clases.proyecto.EstadoProyecto;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.controladores.ControlNotificaciones;
import vecindApp.vistas.InfoProyecto;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.home.HomeAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ControlNotificacionesAdmin extends ControlNotificaciones {
    public static int MAXRECHAZO = 50;

    private Ventana<Notificacion, Proyecto, ElementoColectivo> ventana;
    private HomeAdmin<Notificacion, Proyecto, ElementoColectivo> frame;

    public ControlNotificacionesAdmin(Ventana<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo) {
        super(frame.getHomeAdmin().getNotificaciones(), modelo);
        this.ventana = frame;
        this.frame = frame.getHomeAdmin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Notificacion noti = vista.getLista().getSelectedValue();
        if (e.getSource().equals(vista.getOpenButton())) {
            if (noti == null) {
                return;
            }
            if (modelo.getUsuarioActual().equals(modelo.getAdmin())) {
                String[] op = {"Admitir", "Rechazar", "Cancelar"};
                boolean save = false;
                int ret = JOptionPane.showOptionDialog(vista,
                        noti.descripcion(),
                        "Nuevo mensaje",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        op,
                        op[2]);
                if (ret == JOptionPane.YES_OPTION) {
                    if (noti instanceof NotificacionReg) {
                        ((NotificacionReg) noti).getSujeto().setAdmitido(true);
                        frame.getpBloquear().add(((NotificacionReg) noti).getSujeto());
                    } else if (noti instanceof NotificacionProy) {
                        ((NotificacionProy) noti).getSujeto().setEstado(EstadoProyecto.ACEPTADO);
                    }
                } else if (ret == JOptionPane.NO_OPTION) {
                    boolean flag;
                    do {
                        flag = true;
                        String input = JOptionPane.showInputDialog(vista,
                                "Motivo de rechazo (max " + MAXRECHAZO + " caracteres):",
                                "Rechazo",
                                JOptionPane.PLAIN_MESSAGE);
                        if (input == null) {
                            save = true;
                        } else if (input.length() > MAXRECHAZO) {
                            JOptionPane.showMessageDialog(vista,
                                    "El motivo de rechazo no puede exceder " + MAXRECHAZO + " caracteres.",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            flag = false;
                        } else {
                            if (noti instanceof NotificacionReg) {
                                NotificacionReg cast = (NotificacionReg) noti;
                                cast.getSujeto().setAdmitido(false);
                                cast.getSujeto().setMotivoRechazo(input);
                            } else if (noti instanceof NotificacionProy) {
                                Proyecto proy = ((NotificacionProy) noti).getSujeto();
                                proy.setEstado(EstadoProyecto.RECHAZADO);
                                proy.setMotivoRechazo(input);
                                modelo.removeProyecto(proy);
                                proy.getPropulsor().removeProyecto(proy);
                            }
                        }
                    } while (!flag);
                }
                if (ret != JOptionPane.CANCEL_OPTION && !save) {
                    modelo.getUsuarioActual().eliminarNotificacion(noti);
                    vista.remove(noti);
                }
            }
        }

        else {
            if (noti instanceof NotificacionProy) {
                InfoProyecto<Proyecto> ip = new InfoProyecto<Proyecto>(ventana, ((NotificacionProy) noti).getSujeto());
                ip.setVisible(true);
                ip.setLocationRelativeTo(null);
            }
        }
    }
}
