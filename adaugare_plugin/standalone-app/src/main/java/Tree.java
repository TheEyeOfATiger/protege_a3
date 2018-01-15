import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class Tree extends JFrame {

    public Tree() throws HeadlessException {
        initializeUI();
    }

    ChildParent childparent = new ChildParent();
    private void initializeUI() {
        setSize(200, 400);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Custom Ontology");
        DefaultMutableTreeNode classNode = new DefaultMutableTreeNode("Class");

        DefaultMutableTreeNode subClassNode = new DefaultMutableTreeNode("SubClass");
        ArrayList<String> classList = ModifyOntology.getClassList();
        for (String classIter : classList) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(classIter);
            subClassNode.add(node);
        }

        DefaultMutableTreeNode individualNode = new DefaultMutableTreeNode("InstanceClass");
        for (String classIter : classList) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(classIter);
            individualNode.add(node);
        }

        DefaultMutableTreeNode objectPropertyNode = new DefaultMutableTreeNode("ObjectProperty");
        for (String classIter : classList) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(classIter);
            objectPropertyNode.add(node);
        }

        DefaultMutableTreeNode dataPropertyNode = new DefaultMutableTreeNode("DataProperty");
        for (String classIter : classList) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(classIter);
            dataPropertyNode.add(node);
        }

        root.add(classNode);
        root.add(subClassNode);
        root.add(individualNode);
        root.add(objectPropertyNode);
        root.add(dataPropertyNode);

        final JTree tree = new JTree(root);
        JScrollPane pane = new JScrollPane(tree);
        pane.setPreferredSize(new Dimension(200, 400));

        JButton button = new JButton("Get Selected");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String wordSelected = Proiect.getNameSelected();
                wordSelected = wordSelected.trim();

                TreePath[] paths = tree.getSelectionPaths();
                String lastWord = null;
                String[] middle = null;

                for (TreePath path : paths) {
                    lastWord = "";

                    String word = path.toString();
                    middle = word.split(",");
                    lastWord = word.substring(word.lastIndexOf(" ") + 1);
                    lastWord = lastWord.substring(0, lastWord.length() - 1);
                    childparent.setFather(lastWord);
                }

                if (!lastWord.equals(null)) {
                    if (lastWord.equals("Class")) {
                        ModifyOntology.addClassToOntology(wordSelected.trim());
                    }else if (middle[1].trim().equals("SubClass") && !lastWord.equals(null)) {
                        ModifyOntology.addSubClassInOntology(lastWord.trim(), wordSelected.trim());
                    }else if(middle[1].trim().equals("InstanceClass") && !lastWord.equals(null)) {
                        ModifyOntology.addIndividualToOntology(wordSelected.trim(), lastWord.trim());
                    }
                    else if (middle[1].trim().equals("ObjectProperty") && !lastWord.equals(null)) {
                        ModifyOntology.assignedObjectPropertyToClass(wordSelected.trim(), lastWord.trim());
                    }else if (middle[1].trim().equals("DataProperty") && !lastWord.equals(null)) {
                        ModifyOntology.assignedDataPropertyToClass(wordSelected.trim(), lastWord.trim());
                    }
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