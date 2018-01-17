package proiect;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

public class Tree extends JFrame {
    public Tree() throws HeadlessException {
        initializeUI();
    }
    ChildParent childparent = new ChildParent();
    private void initializeUI() {
        setSize(200, 400);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Countries");
        DefaultMutableTreeNode asia = new DefaultMutableTreeNode("Asia");
        String[] countries = new String[] {"India", "Singapore", "Indonesia", "Vietnam"};
        for (String country : countries) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(country);
            asia.add(node);
        }

        DefaultMutableTreeNode northAmerica = new DefaultMutableTreeNode("North America");
        countries = new String[] {"United States", "Canada"};
        for (String country : countries) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(country);
            northAmerica.add(node);
        }

        DefaultMutableTreeNode southAmerica = new DefaultMutableTreeNode("South America");
        countries = new String[] {"Brazil", "Argetina", "Uruguay"};
        for (String country : countries) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(country);
            southAmerica.add(node);
        }

        DefaultMutableTreeNode europe = new DefaultMutableTreeNode("Europe");
        countries = new String[] {"United_Kingdom", "Germany", "Spain", "France", "Italy"};
        for (String country : countries) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(country);
            europe.add(node);
        }

        root.add(asia);
        root.add(northAmerica);
        root.add(southAmerica);
        root.add(europe);
       
        final JTree tree = new JTree(root);
        JScrollPane pane = new JScrollPane(tree);
        pane.setPreferredSize(new Dimension(200, 400));


        JButton button = new JButton("Get Selected");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TreePath[] paths = tree.getSelectionPaths();

                for (TreePath path : paths) {
                    String word = path.toString();
                    String lastWord = word.substring(word.lastIndexOf(" ")+1);
                    lastWord = lastWord.substring(0, lastWord.length() - 1);
                    childparent.setFather(lastWord);
                }
                
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pane, BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Tree().setVisible(false);
            }
        });
    }
}