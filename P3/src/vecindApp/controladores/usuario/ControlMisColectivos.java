package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.Colectivo;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.clases.usuario.Administrador;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.MisColectivos;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

/**
 * Define el controlador para la vista de gestion de los colectivos del ciudadano.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ControlMisColectivos implements ActionListener, TreeSelectionListener {
    private Ventana<Notificacion, Proyecto, ElementoColectivo> frame;
    private MisColectivos<ElementoColectivo> vista;
    private Aplicacion modelo;

    /**
     * Crea el controlador para la vista de gestion de los colectivos del ciudadano
     * @param frame la ventana principal del sistema
     * @param modelo la aplicacion fuente
     */
    public ControlMisColectivos(Ventana<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getMisColectivos();
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getInfAfinidad())) {
            ElementoColectivo c1 = (ElementoColectivo) ((DefaultMutableTreeNode)vista.getArbol().getLastSelectedPathComponent()).getUserObject();

            frame.setLocationRelativeTo(null);
            frame.getAfinidad().updateCols(((Ciudadano) modelo.getUsuarioActual()).getTree(), c1);
            frame.mostrarPanel("afinidad");
        }
        else if (e.getSource().equals(vista.getNuevoColectivo())){
            String ret = JOptionPane.showInputDialog("Nombre del colectivo");
            Colectivo c = new Colectivo(ret, (Ciudadano) modelo.getUsuarioActual());

            if (ret == null || !modelo.addElemCol((ElementoColectivo) c)) {
                JOptionPane.showMessageDialog(vista, "Colectivo no válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                vista.updateCols(((Ciudadano) modelo.getUsuarioActual()).getTree());
                frame.getHomeUsuario().getBuscarColectivos().updateCols(modelo.getTree());
            }
        }
        else if (e.getSource().equals(vista.getNuevoSubcolectivo())) {
            Colectivo padre = (Colectivo)((DefaultMutableTreeNode)vista.getArbol().getLastSelectedPathComponent()).getUserObject();
            String ret = JOptionPane.showInputDialog("Nombre del subcolectivo");
            Colectivo c = new Colectivo(ret, padre);

            if (ret == null || !modelo.addElemCol(c)) {
                JOptionPane.showMessageDialog(vista, "Subcolectivo no válido", "Error", JOptionPane.ERROR_MESSAGE);
                ((Ciudadano) modelo.getUsuarioActual()).getColectivos().remove(c);
                ((Ciudadano) modelo.getUsuarioActual()).getColectivosRepresentados().remove(c);
            }
            else {
                vista.updateCols(((Ciudadano)modelo.getUsuarioActual()).getTree());
                frame.getHomeUsuario().getBuscarColectivos().updateCols(modelo.getTree());
            }
        }
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        Object col = ((DefaultMutableTreeNode)vista.getArbol().getLastSelectedPathComponent()).getUserObject();

        if (!(col instanceof Colectivo)) {
            vista.getInfAfinidad().setEnabled(false);
            vista.getNuevoSubcolectivo().setEnabled(false);
        }
        else {
            vista.getInfAfinidad().setEnabled(true);
            if (((Colectivo)col).getRepresentante().equals(modelo.getUsuarioActual())) {
                vista.getNuevoSubcolectivo().setEnabled(true);
            }
            else {
                vista.getNuevoSubcolectivo().setEnabled(false);
            }
        }
    }
}
