package Datos;


import java.io.File;



public class EliminarArchivo {
    
    public EliminarArchivo(String operacion, String autor){
        File fichero = new File("Mensajes"+operacion+autor+".txt");
        System.out.println("Mensajes"+operacion+autor);
        eliminarFichero(fichero);
    }
    public static void eliminarFichero(File fichero) {

    if (!fichero.exists()) {
        System.out.println("El archivo no existe.");
    } else {
        fichero.delete();
        System.out.println("El archivo fue eliminado.");
    }

}
}
