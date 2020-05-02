package vecindApp.vistas.usuario.nuevoProyecto;

import layout.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NuevoProyectoInfraestructura extends JPanel {
    private JRadioButton opc = new JRadioButton("Proyecto de infraestructura");
    private JPanel textPanel = new JPanel(new SpringLayout());
    private JTextField imPath = new JTextField();
    private JPanel distritosPanel = new JPanel();
    private JLabel distritosLabel;
    private List<JCheckBox> distritos = new ArrayList<>();

    public NuevoProyectoInfraestructura() {
        JLabel l = new JLabel("Imagen:");
        l.setLabelFor(imPath);
        textPanel.add(l);
        textPanel.add(imPath);
        SpringUtilities.makeCompactGrid(textPanel, 1, 2, 6, 6, 6, 6);

        distritosLabel = new JLabel("Distritos afectados:", JLabel.LEADING);
        distritosLabel.setLabelFor(distritosPanel);
        distritosPanel.add(l);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(opc);
        this.add(textPanel);
        this.add(distritosPanel);
    }

    public JRadioButton getButton() {
        return opc;
    }

    public boolean isSelected() {
        return opc.isSelected();
    }

    public String getImagePath() {
        return imPath.getText();
    }

    public void setList(Collection<String> list) {
        int size = list.size();
        JPanel buttons = new JPanel(new GridLayout(size, 1));
        distritos.clear();
        distritosPanel.removeAll();
        distritosPanel.add(distritosLabel);
        for (String dist : list) {
            JCheckBox box = new JCheckBox(dist);
            distritos.add(box);
            buttons.add(box);
        }
        distritosPanel.add(buttons);
    }

    public List<String> getDistritos() {
        return distritos.stream().
                filter(AbstractButton::isSelected).
                map(AbstractButton::getText).
                collect(Collectors.toList());
    }

    public void update() {
        opc.setSelected(false);
        imPath.setText("");
        this.distritos.forEach(dist -> dist.setSelected(false));
    }
}
