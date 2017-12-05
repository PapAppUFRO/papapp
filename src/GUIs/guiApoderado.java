package GUIs;


import DominioProblema.Apoderado;
import Datos.EliminarArchivo;
import Datos.Leer;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;


public class guiApoderado extends JFrame implements ActionListener {

    JTextArea txtmensajes;
    JButton btnvolver , btnver , btnborrar;
    String emisor;
    JLabel jlbltitulo, bienvenida, etiquetaGif;
    ImageIcon imagen;
    
    
    Font fuenteTitulo  = new Font("Agency FB", Font.BOLD, 30);
    Font fuenteCuerpo  = new Font("Agency FB", Font.BOLD, 14);
    Font fuenteBotones = new Font("Agency FB", Font.BOLD, 18);
    Apoderado apoderado;

    public guiApoderado(String emisor) {
        this.emisor = emisor;
        
        apoderado = new Apoderado(emisor);
        
        jlbltitulo = new JLabel("Apoderado " + emisor);
        jlbltitulo.setFont(fuenteTitulo);
        jlbltitulo.setBounds(200, 40, 400, 35);
        add(jlbltitulo);
        
        bienvenida = new JLabel("Bienvenido a PapApp");
        bienvenida.setFont(fuenteCuerpo);
        bienvenida.setBounds(225, 70, 400, 35);
        add(bienvenida);
        
        
        btnver = new JButton();
        btnver.setText("Ver recibidos");
        btnver.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        btnver.setFont(fuenteBotones);
        btnver.setBounds(215, 180, 120, 40);
        btnver.addActionListener(this);
        add(btnver);
        
        btnborrar = new JButton();
        btnborrar.setText("Borrar recibidos");
        btnborrar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        btnborrar.setFont(fuenteBotones);
        btnborrar.setBounds(215, 230, 120, 40);
        btnborrar.addActionListener(this);
        add(btnborrar);
        
        

        btnvolver = new JButton();
        btnvolver.setText("Salir");
        btnvolver.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        btnvolver.setFont(fuenteBotones);
        btnvolver.setBounds(215, 280, 120, 40);
        btnvolver.addActionListener(this);
        add(btnvolver);
        
        imagen = new ImageIcon("Online.gif");
        etiquetaGif = new JLabel(imagen);
        etiquetaGif.setBounds(400,0,500,200);
        add(etiquetaGif);

        setLayout(null);
        setSize(600, 400);
        setLocation(500, 300);
        setTitle("Apoderado");
        setVisible(true);
        getContentPane().setBackground(Color.cyan);

    }

  

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnver) {
            new Leer("Recibidos",emisor);
        }
        if (e.getSource() == btnborrar) {
            EliminarArchivo eliminar = new EliminarArchivo("Recibidos",emisor);
        }
        if (e.getSource() == btnvolver) {
            apoderado.closePort();
            System.exit(0);
            
        }
    }
}
