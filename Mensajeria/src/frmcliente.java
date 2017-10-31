

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class frmcliente extends JFrame implements ActionListener {

    JTextField txtmensaje;
    JButton btnenviar;

    public frmcliente() {
        txtmensaje = new JTextField();
        txtmensaje.setBounds(10, 10, 200, 20);
        add(txtmensaje);

        btnenviar = new JButton();
        btnenviar.setText("Enviar");
        btnenviar.setBounds(10, 40, 150, 20);
        btnenviar.addActionListener(this);
        add(btnenviar);

        setLayout(null);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new frmcliente();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnenviar) { //preguntando si el boton esta presionado
            try {
                Socket cli = new Socket("10.0.0.146", 9090); // en esta linea va a a ip del cliente
                DataOutputStream flujo = new DataOutputStream(cli.getOutputStream());
                flujo.writeUTF(txtmensaje.getText());
                cli.close();
            } catch (Exception ex) {
                System.out.println("Error en cliente" + ex.getMessage());
            }

        }
    }

}
