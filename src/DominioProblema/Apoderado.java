package DominioProblema;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chris
 */
import Datos.Escribir;
import DominioProblema.Notificacion;
import DominioProblema.SonidoNotificacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;


public class Apoderado extends JFrame implements Runnable {

    private String msg;
    private String emisor;
    ServerSocket servidor;
    

    public Apoderado(String emisor) {
        this.emisor = emisor;
        

        Thread hilo = new Thread(this);
        hilo.start();

    }

    @Override
    public void run() {

        try {
            servidor = new ServerSocket(5050);
            Socket cli;
            while (true) {
                
                cli = servidor.accept();
                DataInputStream flujo = new DataInputStream(cli.getInputStream());
                msg = flujo.readUTF();

                if (msg.equalsIgnoreCase("FIN")) {
                    servidor.close();
                    break;
                } else {
                    new Notificacion().setVisible(true);
                    new SonidoNotificacion();
                    Escribir archivo = new Escribir("Recibidos", emisor);
                    archivo.crear(msg);
                    cli.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Apoderado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getMsg() {
        return msg;
    }
    public void closePort(){
        try {
            servidor.close();
        } catch (SocketException ex) {
            System.out.println("Puerto cerrado");
        } catch (IOException ex) {
            Logger.getLogger(Apoderado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
