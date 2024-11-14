package datos;

public class Libro extends ProductoLiterario {
    private String isbn;
    final String familia = super.getFamilia();
    
    public Libro(String idProducto, String nombre, double precio, String descripcion, String familia
                        ,String autor, String editorial, int anioPublicacion, String genero, int numeroPaginas, String isbn) 
    {
                super(idProducto, nombre, precio, descripcion, familia, autor, editorial, anioPublicacion, genero, numeroPaginas);
                this.isbn = isbn;

    }

    public static Libro fromString(String[] partes) {
        if (partes.length < 11) {
            throw new IllegalArgumentException("Datos incompletos para crear un Libro");
        }
        try{
            String idProducto = partes[0].trim();
            String nombre = partes[1].trim();
            double precio = Double.parseDouble(partes[2].trim());
            String descripcion = partes[3].trim();
            String familia = partes[4].trim();
            String autor = partes[5].trim();
            String editorial = partes[6].trim();
            int anioPublicacion = Integer.parseInt(partes[7].trim());
            String genero = partes[8].trim();
            int numeroPaginas = Integer.parseInt(partes[9].trim());
            String isbn = partes[10].trim();
            return new Libro(idProducto, nombre, precio, descripcion, familia, autor,
                    editorial, anioPublicacion, genero, numeroPaginas, isbn);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir número: " + e.getMessage());
            throw e; // Re-lanzar la excepción para que pueda ser manejada en un nivel superior
        }

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    //metodo getFamilia sobreescrito de la clase ProductoLiterario
    public String getFamilia(){
        return super.getFamilia();
    }


    //sobreescritura del metodo obtenerDetalles de la clase ProductoLiterario y
    //agregando el atributo isbn
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles()+"Libro [isbn=" + isbn + "]";
    }

    @Override
    //a un producto literario se le puede aplicar un descuento de hasta el 80%
    public boolean aplicarDescuento(double porcentaje) {
        if (super.aplicarDescuento(porcentaje)){
           this.setPrecio(this.getPrecio()-this.getPrecio()*(porcentaje/100));
           return true;
        }
        else
            return false;  
         
    }

    @Override
    public String toString() {
        return super.toString()+","+ isbn ;
    }

    @Override
    public double calcularPrecio() {
        return 0;
    }

    @Override
    public double calcularPrecio(double porcentaje) {
        return 0;
    }

    @Override
    public boolean esVendible() {
       
        return true;//este producto es vendible al público
    }

    
    
    


}