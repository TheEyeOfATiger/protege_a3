import java.io.*;
import javax.swing.*;


public class Functions {

    public void TextFromFile(JTextPane textPanel) {
        File fisier;
        FileReader fisierSec = null;
        JFileChooser fileChooser = new JFileChooser();
        int component  = fileChooser.showOpenDialog(null);

        if(component == JFileChooser.APPROVE_OPTION) {
            try {
                fisier = fileChooser.getSelectedFile();
                //System.out.println(fisier);
                File file = new File(fisier.getAbsolutePath());
                FileReader fileReader = new FileReader(file);

                while(fileReader.read() != -1){
                    textPanel.read(fileReader,null);
                }
                fileReader.close();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

}