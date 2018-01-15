import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import java.util.List;
import javax.swing.*;


public class Proiect{
    private static String dataSelected;
    Tree tree = new Tree();
    List<ChildParent> objects = new ArrayList<ChildParent>();
    ArrayList list = new ArrayList();
    String selectedWord;
    String child;
    String father;

    public static void main(String[] args) {
        Proiect proiect = new Proiect();
        proiect.start();

    }

    public static String getNameSelected() {
        return dataSelected;
    }

    public void setDataSelectedFromText(String data) {
        dataSelected = data;
    }

    public void start(){
        String words = "drugs companies";

        String[] arr = words.split(" ");

        final JTextPane jTextPane = new JTextPane();
        JButton selectFile = new JButton("Open File");
        JFrame frame = new JFrame("Test");
        JButton selectButton = new JButton("Select");

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextPane.getSelectedText() != null) {
                    selectedWord = jTextPane.getSelectedText();
                    child = selectedWord;

                    setDataSelectedFromText(child);
                }
                tree.setVisible(true);
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