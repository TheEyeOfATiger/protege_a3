/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect;

import java.io.*;
import javax.swing.*;

/**
 *
 * @author Eduardo
 */
public class Functions {
    public void TextFromFile(JTextPane tp)
     {
         File ff;
         FileReader fff=null;
        JFileChooser jf=new JFileChooser();
       int aa=jf.showOpenDialog(null);
       
       if(aa==JFileChooser.APPROVE_OPTION)
       {
        try {
             
            ff=jf.getSelectedFile();
               //System.out.println(ff);
            File file = new File(ff.getAbsolutePath());
            FileReader fr = new FileReader(file);
            while(fr.read() != -1){
              tp.read(fr,null);
            }
            fr.close();
        } catch(Exception ex){
          ex.printStackTrace();
        }
     }
     }
    

}
