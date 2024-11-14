package miPrincipal;
import ui.Menu;
import ui.Aplicacion;
import datos.Usuario;

public class Principal {
    
    public static void main(String[] args) {
        try{
            //instanciamos la clase Aplicacion
            Aplicacion app = new Aplicacion();
            //intentamos  con el login
            Usuario u = app.login("LourdesA", "123");
            //si los datos no son correctos
            System.out.println("Bienvenido(a)!!!!!");
            System.out.println("Nombre: "+u.getNombreUsuario());
            System.out.println("Email: "+u.getEmail());

            Menu menu = new Menu();
            menu.iniciar();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        /*
        if (u==null){
            System.out.println("usario y/o password incorrecto");
        }else{
            System.out.println("Felicidades, login exitoso");
            System.out.println("Nombre: "+u.getNombreUsuario());
            System.out.println("Email: "+u.getEmail());
            Menu menu = new Menu();
            menu.iniciar();
        }
        */
       
    }
}