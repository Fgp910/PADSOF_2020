package vecindApp.controladores.admin;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.vistas.admin.Bloquear;
import vecindApp.vistas.home.HomeAdmin;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Define el controlador para la vista de ciudadanos no bloqueados.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ControlBloquear implements ListSelectionListener, ActionListener {
    private Bloquear<ElementoColectivo> vista;
    private HomeAdmin<Notificacion, ElementoColectivo> frame;
    private Aplicacion modelo;

    /**
     * Crea el controlador para la vista de ciudadanos no bloqueados
     * @param frame el componente padre (la vista principal del administrador)
     * @param modelo la aplicacion fuente
     */
    public ControlBloquear(HomeAdmin<Notificacion, ElementoColectivo> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getBloquear();
        this.modelo = modelo;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (vista.getLista().getSelectedValue() == null) {
                vista.getBlockButton().setEnabled(false);
            } else {
                vista.getBlockButton().setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int index = vista.getLista().getSelectedIndex();
        if (index > -1) {
            Ciudadano c = (Ciudadano) vista.getItem(index);
            c.bloquear();
            vista.remove(c);
            frame.getDesbloquear().add(c);
            modelo.addBloqueado(c);
        }
    }
}
