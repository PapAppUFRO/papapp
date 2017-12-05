package GUIs;




import DominioProblema.Login;
import GUIs.guiProfesor;
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
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;

public class guiLogin extends JFrame implements ActionListener {

    public static JTextField txtUser;
    public static JButton btnEnviar;
    JButton btnSalir;
    JLabel labelUser;
    JLabel labelTitulo;
    JLabel labelSubtitulo;
    JLabel labelPwd;
    public static JPasswordField pwdField;
    
    //Fuente a utilizar en el JFrame
    Font fuenteTitulo  = new Font("Agency FB", Font.BOLD, 30);
    Font fuenteCuerpo  = new Font("Agency FB", Font.BOLD, 14);
    Font fuenteBotones = new Font("Agency FB", Font.BOLD, 18);
    

    public guiLogin() {
       
        
       
        
        //Label para título de aplicación
        labelTitulo = new JLabel();
        labelTitulo.setFont(fuenteTitulo);
        labelTitulo.setText("Bienvenido a PapApp");
        labelTitulo.setBounds(100,20,400,35);
        add(labelTitulo);
        //Label subtítulo
        labelSubtitulo = new JLabel();
        labelSubtitulo.setFont(fuenteCuerpo);
        labelSubtitulo.setText("Por favor, escriba su nombre de usuario y contraseña");
        labelSubtitulo.setBounds(55,50,400,35);
        add(labelSubtitulo);
        
        //Label "Nombre de usuario"
        labelUser = new JLabel();
        labelUser.setFont(fuenteCuerpo);
        labelUser.setText("Nombre de usuario");
        labelUser.setBounds(140,100,100,20);
        add(labelUser);
        //Campo para escribir el nombre de usuario
        txtUser = new JTextField();
        txtUser.setBounds(100,120,200,40);
        add(txtUser);
        
        //Label "Contraseña"
        labelPwd = new JLabel();
        labelPwd.setFont(fuenteCuerpo);
        labelPwd.setText("Contraseña");
        labelPwd.setBounds(165,170,100,20);
        add(labelPwd);
        //Campo para escribir contraseña
        pwdField = new JPasswordField();
        pwdField.setBounds(100,190,200,40);
        add(pwdField);
        
        //Botón salir
        btnSalir = new JButton();
        btnSalir.setFont(fuenteBotones);
        btnSalir.setText("Salir");
        btnSalir.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        btnSalir.setBounds(200, 270, 100, 50);
        btnSalir.addActionListener(this);
        add(btnSalir);

        //Botón Ingresar
        btnEnviar = new JButton();
        btnEnviar.setFont(fuenteBotones);
        btnEnviar.setText("Ingresar");
        btnEnviar.setBounds(100, 270, 100, 50);
        btnEnviar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        btnEnviar.addActionListener(this);
        add(btnEnviar);
        
        setLocation(750, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("PapApp");
        setLayout(null);
        setSize(400, 400);
        getContentPane().setBackground(Color.cyan);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEnviar) { //preguntando si el boton esta presionado
            try {
                if(Login.revisaLogin()=="1"){
                    guiApoderado apoderado = new guiApoderado(txtUser.getText());
                    apoderado.setVisible(true);
                    this.setVisible(false);
                    System.out.println(Login.revisaLogin());
                }else if(Login.revisaLogin()=="2"){
                    guiProfesor profesor = new guiProfesor(txtUser.getText());
                    profesor.setVisible(true);
                    this.setVisible(false);
                    System.out.println("Es 2");
                }else{
                    System.out.println(Login.revisaLogin());
                    JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }
        if (e.getSource() == btnSalir) { //preguntando si el boton esta presionado
            System.exit(0);
        }
    }

}
