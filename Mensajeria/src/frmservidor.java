
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class frmservidor extends JFrame implements Runnable {

    JTextArea txtmensajes;
    String emisor = "Chris";
    String asunto = "Bienvenido";

    public frmservidor() {
        txtmensajes = new JTextArea();
        txtmensajes.setBounds(10, 10, 400, 400);
        add(txtmensajes);

        setLayout(null);
        setSize(500, 500);
        setVisible(true);
        Thread hilo = new Thread(this);
        hilo.start();

    }

    public static void main(String[] args) {
        new frmservidor();
    }

    @Override
    public void run() {

        try {
            ServerSocket servidor = new ServerSocket(9090);
            Socket cli;
            while (true) {
                cli = servidor.accept();
                DataInputStream flujo = new DataInputStream(cli.getInputStream());
                String msg = flujo.readUTF();
                Escribir archivo = new Escribir(msg, emisor, asunto);
                txtmensajes.append(archivo.toString());
                cli.close();
                if (msg.equalsIgnoreCase("FIN")) {
                    servidor.close();
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

