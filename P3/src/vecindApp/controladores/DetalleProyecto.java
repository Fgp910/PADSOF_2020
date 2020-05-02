package vecindApp.controladores;

import vecindApp.clases.proyecto.Proyecto;
import vecindApp.clases.proyecto.ProyectoInfraestructura;
import vecindApp.clases.proyecto.ProyectoSocial;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class DetalleProyecto {
    public static void mostrarProyecto(Proyecto proy, JComponent parent) {
        if (proy instanceof ProyectoInfraestructura) {
            mostrarProyecto((ProyectoInfraestructura) proy, parent);
        } else if (proy instanceof ProyectoSocial) {
            mostrarProyecto((ProyectoSocial) proy, parent);
        }
    }

    private static void mostrarProyecto(ProyectoInfraestructura proy, JComponent parent) {
        try {
            String path = proy.getImagen();
            BufferedImage img = ImageIO.read(new File(path));
            JOptionPane.showMessageDialog(parent,
                    "Titulo: " + proy.getTitulo() +
                            "\nDescripcion: " + proy.getDescripcion() +
                            "\nImporte solicitado: " + String.format("%.2f", proy.getImporteSolicitado()) +
                            "\nTipo de proyecto: Infraestructura" +
                            "\nDistritos Afectados: " + proy.getAfectados(),
                    "Proyecto",
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(img));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parent,
                    "No se pudo cargar " + proy.getImagen(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void mostrarProyecto(ProyectoSocial proy, JComponent parent) {
        String nac;
        if (proy.isNacional()) {
            nac = "\nProyecto nacional";
        } else {
            nac = "\nProyecto internacional";
        }
        JOptionPane.showMessageDialog(parent, "Titulo: " + proy.getTitulo() +
                "\nDescripcion: " + proy.getDescripcion() +
                "\nImporte solicitado: " + String.format("%.2f", proy.getImporteSolicitado()) +
                "\nTipo de proyecto: Social" +
                "\nGrupo Social: " + proy.getGrupoSocial() +
                nac,
                "Proyecto",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
