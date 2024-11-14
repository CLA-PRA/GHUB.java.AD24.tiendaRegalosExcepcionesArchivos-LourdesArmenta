package datos;

public class Inventario{
    
    private Producto[] productos;
    private int contador;
    private String ruta;
    private String nombre;
    private String direccion;


    public Inventario(int capacidad, String ruta, String nombre, String direccion) {
        this.productos = new Producto[capacidad];
        this.contador = 0;
        this.ruta = ruta;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Producto[] getProductos() {
        return productos;
    }


    public void agregarProducto(Producto producto) {
        if (contador < productos.length) {
            productos[contador++] = producto;
        } else {
            System.out.println("Inventario lleno. No se puede agregar más productos.");
        }
    }

    public boolean eliminarProducto(String nombre) {
        
        for (int i = 0; i < contador; i++) {
            
            if (productos[i].getNombre().equals(nombre)) {
               
                if (i < contador - 1) {
                    
                    for (int j = i; j < contador - 1; j++) {
                        productos[j] = productos[j + 1];
                    }
                }else{
                    productos[i] = null;
                }
                contador--;
                
                return true;
            }
        }
        return false;
            
    }

    public boolean eliminarProducto(Producto producto) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].equals(producto)) {
                for (int j = i; j < contador - 1; j++) {
                    productos[j] = productos[j + 1];
                }    
                contador--;
                //break;
                return true;
            }
           
        }
        return false;
    }

    public Producto buscarProducto(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].getNombre().equals(nombre)) {
                return productos[i];
            }
        }
        return null;
    }

    public double calcularValorTotalProductos() {
        double total = 0;
        for (int i = 0; i < contador; i++) {
            total += productos[i].getPrecio();
        }
        return total;
    }

    public void aplicarDescuentoATodos(double porcentaje) {
        for (int i = 0; i < contador; i++) {
            productos[i].aplicarDescuento(porcentaje);
        }
    }

    public void mostrarInventario() {
        for (int i = 0; i < contador; i++) {
            System.out.println(productos[i]);
        }
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
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
    


}