package vecindApp.vistas;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

public class VentanaArbol<T> extends JPanel {
    private JPanel bot = new JPanel();
    private JPanel title = new JPanel();
    private DefaultMutableTreeNode root = new DefaultMutableTreeNode();
    private JTree arbol = new JTree(root);
    private JScrollPane scroll = new JScrollPane(arbol);

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
}
