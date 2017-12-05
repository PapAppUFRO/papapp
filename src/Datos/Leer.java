package Datos;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Leer extends JFrame {
 
    
    public Leer(String operacion, String autor) {
        
        try {
        Scanner user_input = new Scanner(System.in);
        JFrame window = new JFrame("Mensajes");
        String all; 
        all = new Scanner(new File("Mensajes"+operacion+autor+".txt")).useDelimiter("\\A").next();
        final JTextArea textArea = new JTextArea(10, 20);
        JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textArea.setText(all);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true); 
        window.add(scroll);
        window.setSize(500, 500);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No hay mensajes.");
    }
    }
}