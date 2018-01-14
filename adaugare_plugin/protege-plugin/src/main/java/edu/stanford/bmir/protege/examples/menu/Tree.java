package edu.stanford.bmir.protege.examples.menu;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static edu.stanford.bmir.protege.examples.menu.GetItemsFromOntology.getOntologyClass;


public class Tree extends JFrame {
    public Tree() throws HeadlessException {
        initializeUI();
    }
    ChildParent childparent = new ChildParent();
    private void initializeUI() {
        setSize(200, 400);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Custom Ontology");
        DefaultMutableTreeNode classNode = new DefaultMutableTreeNode("Class");


        DefaultMutableTreeNode subClassNode = new DefaultMutableTreeNode("Subclass");
        ArrayList<String> classList = getOntologyClass();
        for (String classIt : classList) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(classIt);
            subClassNode.add(node);
        }

        DefaultMutableTreeNode instanceNode = new DefaultMutableTreeNode("Instance");
        //ArrayList<String> instanceList = getClassList();
        for (String classIt : classList) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(classIt);
            instanceNode.add(node);
        }

        DefaultMutableTreeNode objectPropertyNode = new DefaultMutableTreeNode("ObjectProperty");
        for (String classIt : classList) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(classIt);
            objectPropertyNode.add(node);
        }

        DefaultMutableTreeNode dataPropertyNode = new DefaultMutableTreeNode("DataProperty");

        for (String classIt : classList) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(classIt);
            dataPropertyNode.add(node);
        }
        root.add(classNode);
        root.add(subClassNode);
        root.add(instanceNode);
        root.add(objectPropertyNode);
        root.add(dataPropertyNode);

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