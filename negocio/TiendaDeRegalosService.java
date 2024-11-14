package negocio;
import datos.ProductoDAO;
import datos.Producto;
import datos.Libro;
import datos.Celular;
import datos.Television;
import datos.Licuadora;
import datos.Tostadora;
import datos.Calculadora;
import datos.Camisetapromocional;
import datos.ProductoElectronico;
import datos.ProductoElectroDomestico;
import datos.ProductoLiterario;
import datos.ProductoPromocional;
public class TiendaDeRegalosService {
    private ProductoDAO productoDAO;
    private int numProductos;

    /**
     * Constructor de la clase TiendaDeRegalosService
     * @param productoDAO
     */
    public TiendaDeRegalosService(int capacidad, String ruta) {
        this.productoDAO = new ProductoDAO(capacidad,ruta);
        

    }


    public int getRegistros() {
        return productoDAO.getRegistros();

    }


    /**
     * Método que imprime un mensaje de bienvenida
     */

    public void presentarse() {
        System.out.println("Bienvenido a la Tienda de Regalos");
    }

    /**
     * Método que muestra los productos de una familia
     * @param familia
     */
    public void mostrarFamiliaProducto(String familia) {
        this.productoDAO.mostrarFamiliaProducto(familia);
        
    }

    /**
     * Método que obtiene la familia de un producto
     * @return
     * @param producto
     *
     */

    public String obtenerFamiliaProductoElectrodomestico() {
        ProductoElectroDomestico producto = new Licuadora("id", "nombre",
                                                         0.0, "descripcion", "familia", "marca", "modelo", "color", 0, "voltaje", 0, 0);   
        return producto.getFamilia();
    }

    public String obtenerFamiliaProductoLiterario() {
        ProductoLiterario producto = new Libro("id", "nombre",
                                                         0.0, "descripcion", "familia", "autor", "editorial", 0, "genero", 0, "isbn");   
        return producto.getFamilia();
    }

    public String obtenerFamiliaProductoElectronico() {
        ProductoElectronico producto = new Celular("id", "nombre",
                                                         0.0, "descripcion", "familia", "marca", "modelo", "color", 0, "voltaje", 0, "sistemaOperativo", 0, 0, "tipoPantalla");
        return producto.getFamilia();
    }

    public String obtenerFamiliaProductoPromocional() {
        ProductoPromocional producto = new Camisetapromocional(null, null, 0, null, null, null, null);
        return producto.getFamilia();
    }


    public void agregarProducto(Producto producto) {
        productoDAO.agregarProducto(producto);
    }

    public void eliminarProducto(String nombreProducto) {
        productoDAO.eliminarProducto(nombreProducto);
    }

    public Producto buscarProducto(String nombreProducto) {
        return productoDAO.buscarProducto(nombreProducto);
    }

    public Producto[] getProductos() {
        return productoDAO.getProductos();

    }

    public void listarProductos() {
        Producto[] productos = productoDAO.getProductos();
        System.out.println("Productos en inventario:");
        for (Producto producto : productos) {
            if (producto != null) {
               
                System.out.println(producto);
            }
        }
    }

    public void venderProducto(String nombreProducto) {
        Producto producto = productoDAO.buscarProducto(nombreProducto);
        if (producto == null) {
            System.out.println("Producto no encontrado: " + nombreProducto);
            return;
        } 

        if ( producto instanceof Vendible) {
            if (((Vendible) producto).esVendible()) {      
                productoDAO.eliminarProducto(nombreProducto);
                System.out.println("Producto vendido: " + nombreProducto);
            }
            else
               System.out.println("Producto no es Vendible: " + nombreProducto);
            
        }
        else
            System.out.println("Producto no es Vendible: " + nombreProducto);
        
    }

    public void actualizarPrecio(String nombreProducto, double nuevoPrecio) {
        Producto producto = productoDAO.buscarProducto(nombreProducto);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
            productoDAO.actualizarProducto(producto);
            System.out.println("Precio actualizado para " + nombreProducto + ": $" + nuevoPrecio);
        } else {
            System.out.println("Producto no encontrado: " + nombreProducto);
        }
    }
    public void aplicarDescuento(String nombreProducto, double porcentaje) {
        Producto producto = productoDAO.buscarProducto(nombreProducto);
        if (producto != null) {
            producto.aplicarDescuento(porcentaje);
            productoDAO.actualizarProducto(producto);
            System.out.println("Descuento aplicado a " + nombreProducto + ": " + porcentaje + "%");
        } else {
            System.out.println("Producto no encontrado: " + nombreProducto);
        }
    }

    public void aplicarDescuentoATodos(double porcentaje) {
        Producto[] productos = productoDAO.getProductos();
        for (int i = 0; i < productoDAO.getRegistros(); i++) {
            productos[i].aplicarDescuento(porcentaje);
        }
       
        
    }

    public double calcularValorTotalProductos() {
        Producto[] productos = productoDAO.getProductos();
        double total = 0;
        for (Producto producto : productos) {
            if (producto != null) {
               
                total += producto.getPrecio();
            }
        }
        return total;
    }

    public void mostrarInventario() {
        Producto[] productos = productoDAO.getProductos();
        for (int i = 0; i < productos.length; i++) {
            System.out.println(productos[i]);
        }
    }

    public void agregarLibro(String idProducto, String nombre, double precio, String descripcion 
                            ,String familia
                            ,String autor, String editorial, int anioPublicacion, String genero, 
                            int numeroPaginas, String isbn)  {
        Libro libro = new Libro(idProducto, nombre, precio, descripcion, familia,autor, editorial, 
                                anioPublicacion, genero, numeroPaginas, isbn) ;
         
        productoDAO.agregarProducto(libro);
    }

    public void agregarCelular(String idProducto, String nombre, double precio, String descripcion
                              ,String familia                          
                              ,String marca, String modelo, String color, int garantia, String voltaje
                              ,int numCamaras, String sistemaOperativo, int capacidadAlmacenamiento
                              ,int ram, String tipoPantalla) {
        Celular celular = new Celular(idProducto, nombre, precio, descripcion,familia
                                    ,marca, modelo, color, garantia, voltaje
                                    ,numCamaras, sistemaOperativo, capacidadAlmacenamiento
                                    ,ram, tipoPantalla);
        productoDAO.agregarProducto(celular);
    }

    public void agregarTelevision(String idProducto, String nombre, double precio, String descripcion
                                ,String familia
                                ,String marca, String modelo, String color, int garantia, String voltaje
                                ,String tamanio, String resolucion, String tipoPantalla) {
        Producto producto = new Television(idProducto, nombre, precio, descripcion,familia
                                            ,marca, modelo, color, garantia, voltaje
                                            ,tamanio,  resolucion, tipoPantalla);
        productoDAO.agregarProducto(producto);
    }

    public void agregarLicuadora(String idProducto, String nombre, double precio, String descripcion,
                                String familia, 
                                String marca, String modelo, String color, int garantia, String voltaje,
                                 int potencia, int capacidad) {  
        Producto producto = new Licuadora(idProducto, nombre, precio, descripcion, familia, marca, modelo, color, 
                                         garantia, voltaje, potencia, capacidad);
        productoDAO.agregarProducto(producto);
    }

   

    public void agregarTostadora(String idProducto, String nombre, double precio, String descripcion
                                ,String familia
                                ,String marca, String modelo, String color, int garantia, String voltaje
                                ,int numRanuras) {
        Producto producto = new Tostadora(idProducto, nombre, precio,  descripcion,familia
                                        ,marca, modelo, color, garantia, voltaje
                                        ,numRanuras);
        productoDAO.agregarProducto(producto);
    }

    public void agregarCalculadora(String idProducto, String nombre, double precio, String descripcion
                                    ,String familia
                                    ,String marca, String modelo, String color, int garantia
                                    ,String voltaje ,String tipo) {
        Producto producto = new Calculadora(idProducto, nombre, precio, descripcion,familia
                                            ,marca, modelo, color, garantia
                                            ,voltaje ,tipo);
        productoDAO.agregarProducto(producto);
    }

    public void agregarProductoPromocional(String idProducto, String nombre, double precio, String descripcion
                                        ,String familia
                                        ,String talla, String color) {
        Producto producto = new Camisetapromocional(idProducto, nombre, precio, descripcion,familia
                                                    ,talla,color);
        productoDAO.agregarProducto(producto);
    }

}