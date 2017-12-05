package Datos;


import java.io.File;
import java.io.FileWriter;

public class Escribir {

    private String mensaje;

    private File archivo;
    private FileWriter escribir;

    public Escribir(String operacion, String autor) {

        archivo = new File("Mensajes" + operacion + autor + ".txt");

    }

    public void crear(String mensaje) {
        this.mensaje = mensaje;
        try {
            escribir = new FileWriter(archivo, true);
            escribir.write(mensaje);
            escribir.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

    public void delete() {
        archivo.delete();
    }
}
