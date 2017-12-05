package DominioProblema;


import java.text.SimpleDateFormat;
import java.util.Date;


public class Mensaje {

    private String mensaje;
    private String asunto;
    private String emisor;
    private String fecha;
    
    public Mensaje(){
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH:mm");
fecha = sdf.format(new Date());

    }
    
    
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the emisor
     */
    public String getEmisor() {
        return emisor;
    }

    /**
     * @param emisor the emisor to set
     */
    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }
    
    public String toString(){
        String resumen = "-----------------------------------------------------"+ "\nProfesor: " + emisor + " \nFecha: " + fecha + " \nAsunto: "+ asunto+ " \nMensaje: "+mensaje +"\n";
        return resumen;
        
    }
    
    
            
}
