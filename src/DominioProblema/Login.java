package DominioProblema;




import GUIs.guiLogin;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author fazunigan
 */
public class Login {

    private static String salida;

    
    public static String revisaLogin() {
        
    File Login = new File ("Usuarios.txt");
    try{


        Scanner leer = new Scanner (Login);
        leer.useDelimiter("(/|\\r\\n|\\n\\r|\\r|\\n)");
        String line;
        while (leer.hasNextLine() && !isBlank(line = leer.nextLine())) {

             String[] accountData = line.split("/");
             String user = accountData[0];
             String password = accountData[1];
             String rol = accountData[2];

             if(guiLogin.txtUser.getText().equals(user) && guiLogin.pwdField.getText().equals(password)){
                 if(rol.equals("1")){
                     return salida="1";
                 }else{
                     salida="2";
                 }
                 break;
             }else{
                 salida="0";
             }
        }
    }catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Archivo de usuarios no encontrado.");
    }
        return salida;
    }
    private static boolean isBlank(String s) {
     return s == null || s.isEmpty();
}
    
}
