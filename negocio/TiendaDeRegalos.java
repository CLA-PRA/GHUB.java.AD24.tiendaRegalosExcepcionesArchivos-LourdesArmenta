package negocio;

import datos.Inventario;
import datos.Producto;
public class TiendaDeRegalos{
    private String nombre;
    private String direccion;
    private Inventario inventario;

    public TiendaDeRegalos(int capacidadInventario, String ruta, String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.inventario = new Inventario(capacidadInventario,ruta,nombre,direccion);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public void presentarse() {
        System.out.println("Bienvenido a " + nombre + " ubicada en " + direccion);
    }

    public void cumplirAños() {
        System.out.println(nombre + " está celebrando su aniversario!");
    }

    public void agregarProducto(Producto producto) {
        inventario.agregarProducto(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    public void eliminarProducto(String nombreProducto) {
        Producto producto = buscarProducto(nombreProducto);
        if (producto != null) {
            inventario.eliminarProducto(producto);
            System.out.println("Producto eliminado: " + nombreProducto);
        } else {
            System.out.println("Producto no encontrado: " + nombreProducto);
        }
    }

    public Producto buscarProducto(String nombreProducto) {
        Producto[] productos = inventario.getProductos();
        for (int i = 0; i < productos.length; i++) {
           if (productos[i] != null && productos[i].getNombre().equals(nombreProducto)) {
            return productos[i];
           }
        }
        return null; // Devuelve null si no se encuentra el producto
    }

    public void listarProductos() {
        
        Producto[] productos = inventario.getProductos();
        
        System.out.println("Productos en inventario:");
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                System.out.println("- " + productos[i].getNombre() + ": $" + productos[i].getPrecio());
            }
        }
            
    }

    public void venderProducto(String nombreProducto) {
        Producto producto = buscarProducto(nombreProducto);
        
        
        if (producto != null) {
            if(!producto.esVendible()){
                System.out.println("No se puede vender el producto: " + nombreProducto);
                return;
            }
            
            if( inventario.eliminarProducto(nombreProducto))
                System.out.println("Producto vendido: " + nombreProducto);
            else
                System.out.println("Por algun extrano motivo no se puedo vender: " + nombreProducto);

        } else {
            System.out.println("Producto no encontrado: " + nombreProducto);
        }
        

        
    }

    public void actualizarPrecio(String nombreProducto, double nuevoPrecio) {
        Producto producto = buscarProducto(nombreProducto);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
            System.out.println("Precio actualizado para " + nombreProducto + ": $" + nuevoPrecio);
        } else {
            System.out.println("Producto no encontrado: " + nombreProducto);
        }
    }

    public void calcularValorTotalProductos() {
        double valorTotal = inventario.calcularValorTotalProductos();
        System.out.println("Valor total de los productos en inventario: $" + valorTotal);
    }
} 