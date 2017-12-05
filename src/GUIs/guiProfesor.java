package GUIs;


import Datos.EliminarArchivo;
import Datos.Leer;
import DominioProblema.Mensaje;
import DominioProblema.Profesor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class guiProfesor extends JFrame implements ActionListener {
    
    Font fuenteTitulo  = new Font("Agency FB", Font.BOLD, 30);
    Font fuenteCuerpo  = new Font("Agency FB", Font.BOLD, 14);
    Font fuenteBotones = new Font("Agency FB", Font.BOLD, 18);

    private java.util.Date fecha;
    private JTextField txtasunto;
    private JTextArea txtmensaje;
    private JButton btnenviar, btnvolver, btnver, btnborrar;
    private JLabel jlblasunto, jlblmensaje, jlbltitulo;
    private String emisor;
    

    public guiProfesor(String emisor) {
        this.emisor = emisor;

        jlbltitulo = new JLabel("Profesor " + emisor);
        jlbltitulo.setFont(fuenteTitulo);
        jlbltitulo.setBounds(100, 40, 400, 35);
        add(jlbltitulo);

        txtasunto = new JTextField();
        txtasunto.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        txtasunto.setBounds(100, 80, 400, 20);
        add(txtasunto);

        txtmensaje = new JTextArea();
        txtmensaje.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        txtmensaje.setBounds(100, 120, 400, 200);
        txtmensaje.setLineWrap(true);
        txtmensaje.setWrapStyleWord(true);
        add(txtmensaje);

        jlblasunto = new JLabel("Asunto");
        jlblasunto.setFont(fuenteCuerpo);
        jlblasunto.setBounds(10, 75, 100, 30);
        add(jlblasunto);

        jlblmensaje = new JLabel("Mensaje");
        jlblmensaje.setFont(fuenteCuerpo);
        jlblmensaje.setBounds(10, 115, 100, 30);
        add(jlblmensaje);

        btnver = new JButton();
        btnver.setText("Ver enviados");
        btnver.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        btnver.setFont(fuenteBotones);
        btnver.setBounds(530, 130, 100, 40);
        btnver.addActionListener(this);
        add(btnver);
        
        btnborrar = new JButton();
        btnborrar.setText("Borrar enviados");
        btnborrar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        btnborrar.setFont(fuenteBotones);
        btnborrar.setBounds(530, 180, 100, 40);
        btnborrar.addActionListener(this);
        add(btnborrar);
        
        btnenviar = new JButton();
        btnenviar.setText("Enviar");
        btnenviar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        btnenviar.setFont(fuenteBotones);
        btnenviar.setBounds(530, 80, 100, 40);
        btnenviar.addActionListener(this);
        add(btnenviar);

        btnvolver = new JButton();
        btnvolver.setText("Salir");
        btnvolver.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        btnvolver.setFont(fuenteBotones);
        btnvolver.setBounds(530, 230, 100, 40);
        btnvolver.addActionListener(this);
        add(btnvolver);

        setLayout(null);
        setSize(700, 400);
        setLocation(750, 300);
        setTitle("Profesor");
        setVisible(true);
        getContentPane().setBackground(Color.cyan);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnenviar) {
            if (vAsunto() == true && vMnsg() == true) {
                Mensaje mensaje = new Mensaje();
                mensaje.setAsunto(txtasunto.getText());
                mensaje.setMensaje(txtmensaje.getText());
                mensaje.setEmisor(emisor);
                Profesor profe = new Profesor();
                profe.enviarMnsg(mensaje.toString(), emisor);

                reset();

            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");

            }
        }

        if (e.getSource() == btnvolver) {
            System.exit(0);
            
        }
        if (e.getSource() == btnver) {
            new Leer("Enviados",emisor);
        }

        if (e.getSource() == btnborrar) {
            EliminarArchivo eliminar = new EliminarArchivo("Enviados",emisor);
            

        }
    }

    public boolean vAsunto() {
        if (txtasunto.getText().length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean vMnsg() {
        if (txtmensaje.getText().length() == 0) {
            return false;
        } else {
            return true;
        }

    }
    public void reset(){
        txtasunto.setText("");
        txtmensaje.setText("");
    }

}
