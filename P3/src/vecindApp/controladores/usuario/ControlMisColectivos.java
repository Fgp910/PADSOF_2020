package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Colectivo;
import vecindApp.vistas.usuario.MisColectivos;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMisColectivos implements ActionListener, TreeSelectionListener {
    private MisColectivos<Colectivo> vista;
    private Aplicacion modelo;

    public ControlMisColectivos(MisColectivos<Colectivo> vista, Aplicacion modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Colectivo col = (Colectivo)vista.getArbol().getLastSelectedPathComponent();

        if (e.getSource().equals(vista.getInfAfinidad())) {
            //Jeje
        }
        else if (e.getSource().equals(vista.getNuevoColectivo())){

        }
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        Colectivo col = (Colectivo)vista.getArbol().getLastSelectedPathComponent();

        if (col == null) {
            vista.getInfAfinidad().setEnabled(false);
        }
        else {
            vista.getInfAfinidad().setEnabled(true);
        }
    }
}
