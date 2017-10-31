
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class Escribir {

    private String mensaje;
    private String asunto;
    private String emisor;
    private java.util.Date fecha;

    private File archivo;
    private FileWriter escribir;

    public Escribir(String mensaje, String emisor, String asunto) {

        this.mensaje = mensaje;
        this.asunto = asunto;
        this.emisor = emisor;
        archivo = new File("Mensajes.txt");
        fecha = new Date();
        toString();
        crear();

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nEmisor: ");
        sb.append(emisor);
        sb.append("\nAsunto: ");
        sb.append(asunto);
        sb.append("\nMensaje: ");
        sb.append(mensaje);
        sb.append("\nFecha: ");
        sb.append(fecha);
        return sb.toString();
    }

    public void crear() {
        try {
            escribir = new FileWriter(archivo, true);
            escribir.write(toString());
            escribir.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

    public void delete() {
        archivo.delete();
    }
}
