package ui;
import negocio.TiendaDeRegalosService;
import datos.ProductoDAO;
public class TiendaDeRegalosUI {
    private TiendaDeRegalosService tiendaService;

    public TiendaDeRegalosUI(TiendaDeRegalosService tiendaService) {
        this.tiendaService = tiendaService;
    }

    public void iniciar() {
        // Implementar la lógica de la interfaz de usuario aquí
        tiendaService.presentarse();
        // Más interacciones con el usuario
    }

    public static void main(String[] args) {
        //ProductoDAO productoDAO = new ProductoDAO(100); // Capacidad del inventario
        TiendaDeRegalosService tiendaService = new TiendaDeRegalosService(100,"datos/archivos");
        TiendaDeRegalosUI ui = new TiendaDeRegalosUI(tiendaService);
        ui.iniciar();
    }
}