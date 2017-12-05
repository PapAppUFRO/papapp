package DominioProblema;



import Datos.EliminarArchivo;
import Datos.Escribir;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Profesor {
    
   

    public void enviarMnsg(String msg, String autor) {
        try {

            Socket cli = new Socket("192.168.137.1", 5050); // en esta linea va a a ip del cliente
            DataOutputStream flujo = new DataOutputStream(cli.getOutputStream());
            flujo.writeUTF(msg);
            Escribir archivo = new Escribir("Enviados", autor);
            archivo.crear(msg);
            JOptionPane.showMessageDialog(null, "Mensaje enviado.");
            cli.close();

        } catch (Exception ex) {
            System.out.println("Error en cliente " + ex.getMessage());
        }
    }
    public void eliminarMensajes(String operacion, String autor){
        new EliminarArchivo(operacion, autor);
    }
}
