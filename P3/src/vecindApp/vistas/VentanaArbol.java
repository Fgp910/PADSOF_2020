package vecindApp.vistas;

import vecindApp.controladores.usuario.ControlMisColectivos;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

public class VentanaArbol<T> extends JPanel {
    private JPanel bot = new JPanel();
    private JPanel title = new JPanel();
    private DefaultMutableTreeNode root = new DefaultMutableTreeNode();
    private DefaultTreeModel mArbol = new DefaultTreeModel(root);
    private JTree arbol = new JTree(mArbol);
    private JScrollPane scroll = new JScrollPane(arbol);
    private ControlMisColectivos c;

    public VentanaArbol() {
        setLayout(new BorderLayout());

        arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        scroll.setPreferredSize(new Dimension(250,350));
        add(scroll, BorderLayout.CENTER);
        add(bot, BorderLayout.SOUTH);
        add(title, BorderLayout.NORTH);
    }

    public JPanel getBot() {
        return bot;
    }

    public JPanel getTitle() {
        return title;
    }

    public DefaultMutableTreeNode getRoot() {
        return root;
    }

    public void setRoot(DefaultMutableTreeNode root) {
        this.root = root;
    }

    public JTree getArbol() {
        return arbol;
    }

    public void setControlador(ControlMisColectivos c) {
        this.c = c;
        arbol.addTreeSelectionListener(c);
    }

    public void update(JTree arbol) {
        this.removeAll();
        setLayout(new BorderLayout());

        this.arbol = arbol;
        scroll = new JScrollPane(arbol);
        add(scroll, BorderLayout.CENTER);
        bot = new JPanel();
        add(bot, BorderLayout.SOUTH);
        arbol.addTreeSelectionListener(c);
    }
}
