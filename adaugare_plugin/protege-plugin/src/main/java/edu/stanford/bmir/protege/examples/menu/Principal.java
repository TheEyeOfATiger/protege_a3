package edu.stanford.bmir.protege.examples.menu;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.text.*;

public class Principal{
    Tree tree = new Tree();
    List<ChildParent> objects = new ArrayList<>();
    ArrayList list = new ArrayList();
    String selectedWord;
    String child;
    String father;

    public void start(){
        String words = "drugs companies";

        String[] arr = words.split(" ");

        JTextPane jTextPane = new JTextPane();
        JButton selectFile = new JButton("Open File");
        JFrame frame = new JFrame("Test");
        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(e -> {
            if (jTextPane.getSelectedText() != null) {
                selectedWord = jTextPane.getSelectedText();
                child = selectedWord;
            }
            tree.setVisible(true);

        });
        selectFile.addActionListener(e -> {
            Functions function = new Functions();
            function.TextFromFile(jTextPane);
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JScrollPane sp = new JScrollPane(jTextPane);
        buttonPanel.add(selectButton);
        buttonPanel.add(selectFile);
        contentPane.add(BorderLayout.LINE_START, buttonPanel);
        contentPane.add(BorderLayout.CENTER, sp);
        frame.setContentPane(contentPane);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                for(int i = 0; i< objects.size(); i++)
                    System.out.println(objects.get(i).toString());
            }
        });
        tree.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                father = tree.childparent.getFather();
                ChildParent childParent = new ChildParent(child, father);
                objects.add(childParent);
                tree.dispose();
                for(int i = 0; i< objects.size(); i++)
                    System.out.println(objects.get(i).toString());
            }
        });
    }
}