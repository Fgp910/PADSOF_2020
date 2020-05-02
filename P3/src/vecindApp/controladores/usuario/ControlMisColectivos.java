package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.Colectivo;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
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

public class ControlMisColectivos implements ActionListener, TreeSelectionListener {
    private Ventana<Notificacion, Proyecto, ElementoColectivo> frame;
    private MisColectivos<ElementoColectivo> vista;
    private Aplicacion modelo;

    public ControlMisColectivos(Ventana<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getMisColectivos();
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getInfAfinidad())) {
            //Jeje
        }
        else if (e.getSource().equals(vista.getNuevoColectivo())){
            String ret = JOptionPane.showInputDialog("Nombre del colectivo");
            Colectivo c = new Colectivo(ret, (Ciudadano) modelo.getUsuarioActual());

            if (ret == null || !modelo.addElemCol((ElementoColectivo) c)) {
                JOptionPane.showMessageDialog(vista, "Colectivo no válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                vista.updateCols(((Ciudadano) modelo.getUsuarioActual()).getTree());
            }
        }
        else if (e.getSource().equals(vista.getNuevoSubcolectivo())) {
            String ret = JOptionPane.showInputDialog("Nombre del subcolectivo");
            Colectivo padre = (Colectivo)((DefaultMutableTreeNode)vista.getArbol().getLastSelectedPathComponent()).getUserObject();
            Colectivo c = new Colectivo(ret, padre);

            if (ret == null || !modelo.addElemCol(c)) {
                JOptionPane.showMessageDialog(vista, "Subcolectivo no válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                vista.updateCols(((Ciudadano)modelo.getUsuarioActual()).getTree());
            }
        }
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        Object col = ((DefaultMutableTreeNode)vista.getArbol().getLastSelectedPathComponent()).getUserObject();

        if (col == null || !(col instanceof Colectivo)) {
            vista.getInfAfinidad().setEnabled(false);
            vista.getNuevoSubcolectivo().setEnabled(false);
        }
        else {
            vista.getInfAfinidad().setEnabled(true);
            vista.getNuevoSubcolectivo().setEnabled(true);
        }
    }
}
