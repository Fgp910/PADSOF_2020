package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.notificacion.NotificacionProy;
import vecindApp.clases.notificacion.NotificacionReg;
import vecindApp.clases.proyecto.EstadoProyecto;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.vistas.Notificaciones;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlNotificaciones implements ListSelectionListener, ActionListener {
    public static int MAXRECHAZO = 50;

    private Notificaciones<Notificacion> vista;
    private Aplicacion modelo;

    public ControlNotificaciones(Notificaciones<Notificacion> vista, Aplicacion modelo) {
        this.vista = vista;
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
    public void actionPerformed(ActionEvent e) {
        int index = vista.getLista().getSelectedIndex();
        if (index > -1) {
            Notificacion noti = vista.getItem(index);
            if (modelo.getUsuarioActual().equals(modelo.getAdmin())) {
                String [] op = {"Admitir", "Rechazar", "Cancelar"};
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
            } else {
                int ret = JOptionPane.showConfirmDialog(vista,
                        noti.descripcion(),
                        "Nuevo mensaje",
                        JOptionPane.OK_CANCEL_OPTION);
                if (ret == JOptionPane.OK_OPTION) {
                    modelo.getUsuarioActual().eliminarNotificacion(noti);
                    vista.remove(noti);
                }
            }
        }
    }
}
