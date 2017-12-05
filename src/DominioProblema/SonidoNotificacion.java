package DominioProblema;


import java.io.*;
import sun.audio.*;

public class SonidoNotificacion {

    public SonidoNotificacion() throws Exception {
        
            String sonido = "Mnsg.wav";

            InputStream in = new FileInputStream(sonido);

            AudioStream audio = new AudioStream(in);
            AudioPlayer.player.start(audio);
        
    }
}