package datos;

public class ProductoPromocional extends Producto {
    final String familia = "ProductoPromocional";
    public ProductoPromocional(String idProducto, String nombre, double precio, String descripcion,
                               String familia) {
        super(idProducto, nombre, precio, descripcion,familia);
    }

    public String getFamilia(){
        return "Producto Promocional";
    }


    @Override
    public boolean esVendible() {
        return false; // Este producto no es vendible al público
    }

    @Override
    public double calcularPrecio() {
        return 0;
    }

    // Calcula el precio con un descuento valido
    @Override
    public double calcularPrecio(double porcentaje) {
        return 0;
        
    }

   
    //a un producto promocional se le puede aplicar un descuento de hasta el 100%
    @Override
    public boolean aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 100) {
            
            return true;
        }
        return false;
    }


    @Override
    public String obtenerDetalles() {
        return "Nombre: " + getNombre() + ", Precio: " + getPrecio() + ", Descripción: " +
                 getDescripcion()+ ", Familia: " + getFamilia();
    }

    @Override
    public String toString() { 
        return super.toString();
    }

 
    
}
