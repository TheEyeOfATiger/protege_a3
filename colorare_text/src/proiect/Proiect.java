/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect;

/**
 *
 * @author Eduardo
 */
//from   ww  w. ja va  2s.  co m
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.*;
public class Proiect{
  Tree tree = new Tree();
  List<ChildParent> objects = new ArrayList<>();
  ArrayList list = new ArrayList();
  String selectedWord;
  String child;
  String father;
    
  public static void main(String[] args) throws BadLocationException {
    Proiect proiect = new Proiect();
    proiect.start();
    
  }
  public void start() throws BadLocationException{
      String words = "drugs companies";

        String[] arr = words.split(" ");
 
      JTextPane jTextPane = new JTextPane();
    JButton selectFile = new JButton("Open File"); 
    JButton colorare = new JButton("Coloring");
    JFrame frame = new JFrame("Test");
    JButton selectButton = new JButton("Select");
    selectButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jTextPane.getSelectedText() != null) { 
        selectedWord = jTextPane.getSelectedText();
        child = selectedWord;
    }
       tree.setVisible(true);
        
    }
    });
    colorare.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        StyleContext sc = new StyleContext();
    DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    Style cwStyle = sc.addStyle("ConstantWidth", null);
    StyleConstants.setFontFamily(cwStyle, "monospaced");
    StyleConstants.setForeground(cwStyle, Color.red);
    String text = jTextPane.getText();
        try {
            doc.insertString(0, text, null);
        } catch (BadLocationException ex) {
            Logger.getLogger(Proiect.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    for (String word : arr) {
        if (jTextPane.getText().contains(word)){
            int position = jTextPane.getText().indexOf(word);
            int length = word.length();
            doc.setCharacterAttributes(position, length, cwStyle, false);
        }
    }
    jTextPane.setDocument(doc);
    }
    });
    selectFile.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Functions function = new Functions();
    function.TextFromFile(jTextPane);
    
    }
    });
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel contentPane = new JPanel(new BorderLayout());
    JPanel buttonPanel = new JPanel(new FlowLayout());
    JScrollPane sp = new JScrollPane(jTextPane);
    buttonPanel.add(selectButton);
    buttonPanel.add(selectFile);
    buttonPanel.add(colorare);
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
    }
});
  }
}