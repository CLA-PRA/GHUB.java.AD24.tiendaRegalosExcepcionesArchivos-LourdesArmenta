package ui;
import datos.Usuario;
import java.io.FileInputStream;
import java.util.Properties;
public class Aplicacion{
    public Usuario login(String userName, String password) throws ErrorFisicoException{ 

        FileInputStream fis=null;

        try{
            //abrimos el archivo de propiedades para lectura
            fis = new FileInputStream("usuario.properties");
            //cargamos el archivo de propiedades en un objeto
            Properties p = new Properties();
            p.load(fis);
            //leemos el valor de la propiedad usrname
            String usr = p.getProperty("usrname");

            //leemos el valor de la propiedad password
            String pwd = p.getProperty("password");

            //definimos la variable de retorno
            Usuario u =null;

            //si considen los datos
            if(usr.equals(userName) && pwd.equals(password)){
                //instanciamos y setteamos todos datos
                u=new Usuario();
                u.setContrasena(pwd);
                u.setNombreUsuario(p.getProperty("nombre"));
                u.setEmail(p.getProperty("email"));

            }
            return u;

        }catch (Exception ex){
            //throw new RuntimeException("Error verificando datos",ex);
            throw  new ErrorFisicoException(ex);
            

        }
        finally{
            try{
                if(fis !=null)
                    fis.close();
            }catch (Exception ex){
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }


    }
}