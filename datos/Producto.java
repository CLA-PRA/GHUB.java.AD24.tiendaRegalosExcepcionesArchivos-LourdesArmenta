package datos;
import negocio.Vendible;
public abstract class Producto implements Vendible{
    private String idProducto;
    private String nombre;
    private double precio;
    private String descripcion;
    private  String familia;

    public Producto() {

    }
    public Producto(String idProducto, String nombre,  double precio,  
                    String descripcion, String familia) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.familia = familia;
    }

   

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

   
    @Override
    public String toString() {
        return idProducto + "," + nombre + "," + precio + "," + descripcion+","+familia;
    }

    
    public  String obtenerDetalles(){
        return "Producto : "+ idProducto + ", " + nombre + ", $" + precio + ", " + descripcion+", "+familia;

    }
    

    public abstract boolean aplicarDescuento(double porcentaje);

    public abstract boolean esVendible();

}