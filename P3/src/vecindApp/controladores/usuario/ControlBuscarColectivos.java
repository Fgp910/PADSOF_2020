package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.Colectivo;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.clases.usuario.Administrador;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.BuscarColectivos;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlBuscarColectivos implements ActionListener, TreeSelectionListener {
    private BuscarColectivos vista;
    private Ventana<Notificacion, Proyecto, ElementoColectivo> frame;
    private Aplicacion modelo;

    public ControlBuscarColectivos(Ventana<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getBuscarColectivos();
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getUnirse())) {
            ((Ciudadano) modelo.getUsuarioActual())
                    .addColectivo((Colectivo) ((DefaultMutableTreeNode)vista.getArbol()
                            .getLastSelectedPathComponent()).getUserObject());
        }
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        Object o = ((DefaultMutableTreeNode)vista.getArbol().getLastSelectedPathComponent()).getUserObject();

        if (!(o instanceof Colectivo)) {
            vista.getUnirse().setEnabled(false);
        }
        else {
            Colectivo col = (Colectivo) o;
            if (col.perteneceHijos(((Ciudadano) modelo.getUsuarioActual()))) {
                vista.getUnirse().setEnabled(false);
            }
            else {
                vista.getUnirse().setEnabled(true);
            }
        }
    }
}
