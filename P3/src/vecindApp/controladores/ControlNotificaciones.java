package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.notificacion.NotificacionProy;
import vecindApp.clases.notificacion.NotificacionReg;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.clases.proyecto.ProyectoInfraestructura;
import vecindApp.clases.proyecto.ProyectoSocial;
import vecindApp.vistas.Notificaciones;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ControlNotificaciones implements ListSelectionListener, ActionListener {
    protected Notificaciones<Notificacion> vista;
    protected Aplicacion modelo;

    public ControlNotificaciones(Notificaciones<Notificacion> vista, Aplicacion modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (vista.getLista().getSelectedValue() == null) {
                vista.getOpenButton().setEnabled(false);
                vista.getInfoButton().setEnabled(false);
            } else {
                vista.getOpenButton().setEnabled(true);
                if (vista.getLista().getSelectedValue() instanceof NotificacionProy) {
                    vista.getInfoButton().setEnabled(true);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getOpenButton())) {
            Notificacion noti = vista.getLista().getSelectedValue();
            if (noti == null) {
                return;
            }
            int ret = JOptionPane.showConfirmDialog(vista,
                    noti.descripcion(),
                    "Nuevo mensaje",
                    JOptionPane.OK_CANCEL_OPTION);
            if (ret == JOptionPane.OK_OPTION) {
                modelo.getUsuarioActual().eliminarNotificacion(noti);
                vista.remove(noti);
            }
        } else if (e.getSource().equals(vista.getInfoButton())) {
            Notificacion noti = vista.getLista().getSelectedValue();
            if (noti instanceof NotificacionProy) {
                Proyecto proy = ((NotificacionProy) noti).getSujeto();
                if (proy instanceof ProyectoSocial) {
                    String nac;
                    if (((ProyectoSocial) proy).isNacional())
                        nac = "\nProyecto nacional";
                    else
                        nac = "\nProyecto internacional";
                    JOptionPane.showMessageDialog(vista, "Titulo: " + proy.getTitulo() +
                            "\nDescripcion: " + proy.getDescripcion() +
                            "\nImporte solicitado: " + new DecimalFormat("#.00").format(proy.getImporteSolicitado()) +
                            "\nTipo de proyecto: Social" +
                            "\nGrupo Social: " + ((ProyectoSocial) proy).getGrupoSocial() +
                            nac, "Info", JOptionPane.INFORMATION_MESSAGE);
                } else if (proy instanceof ProyectoInfraestructura) {
                    ImageIcon img = new ImageIcon(getClass().getResource(((ProyectoInfraestructura) proy).getImagen()));
                    JOptionPane.showMessageDialog(vista, "Titulo: " + proy.getTitulo() +
                                    "\nDescripcion: " + proy.getDescripcion() +
                                    "\nImporte solicitado: " + proy.getImporteSolicitado() +
                                    "\nTipo de proyecto: Infraestructura" +
                                    "\nDistritos Afectados: " + ((ProyectoInfraestructura) proy).getAfectados(),
                            "Info", JOptionPane.INFORMATION_MESSAGE, img);
                }
            }
        }
    }
}
