package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Colectivo;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.Afinidad;
import vecindApp.vistas.usuario.MisColectivos;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlAfinidad implements ActionListener, TreeSelectionListener {
    private Ventana<Notificacion, Proyecto, ElementoColectivo> frame;
    private Afinidad<ElementoColectivo> vista;
    private Aplicacion modelo;

    public ControlAfinidad(Ventana<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getAfinidad();
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getConsultar())) {
            String infAfinidad;
            Colectivo c1 = (Colectivo) vista.getC1();
            Colectivo c2 = (Colectivo) ((DefaultMutableTreeNode)vista.getArbol().getLastSelectedPathComponent()).getUserObject();

            infAfinidad = "Afinidad entre " + c1 + " y " + c2 +":\n" + c1.generarInformeAfinidad(c2);
            JOptionPane.showMessageDialog(vista, infAfinidad, "Informe de afinidad", JOptionPane.PLAIN_MESSAGE);
        }
        else if (e.getSource().equals(vista.getVolver())) {
            frame.setLocationRelativeTo(null);
            frame.mostrarPanel("home");
        }
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        Object col = ((DefaultMutableTreeNode)vista.getArbol().getLastSelectedPathComponent()).getUserObject();

        if (!(col instanceof Colectivo)) {
            vista.getConsultar().setEnabled(false);
        }
        else {
            vista.getConsultar().setEnabled(true);
        }
    }
}
