package datos;


public class ProductoLiterario extends Producto {
    private String autor;
    private String editorial;
    private int anioPublicacion;
    private String genero;
    private int numeroPaginas;
    final String familia = "ProductoLiterario";
    public ProductoLiterario(String idProducto, String nombre, double precio, String descripcion
                        ,String familia
                        ,String autor, String editorial, int anioPublicacion, String genero, int numeroPaginas) {
        super(idProducto, nombre, precio, descripcion,familia);
        this.autor = autor;
        this.editorial = editorial;  
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.numeroPaginas = numeroPaginas;

    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String obtenerDetalles() {
        return super.toString()+", autor=" + autor + ", editorial=" + editorial+ ", anioPublicacion=" + anioPublicacion +  ", genero=" + genero
                + ", numeroPaginas=" + numeroPaginas;
    }

    @Override
    public String toString() {
        return super.toString()+"," + autor + "," +editorial+ ","+anioPublicacion + ","  + genero
                + "," + numeroPaginas;
    }

    @Override
    //a un producto literario se le puede aplicar un descuento de hasta el 80%
    public boolean aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <=80)
          return true;
        else
          return false;
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
        return true;
    }
    public String getFamilia(){
        return "ProductoLiterario";
    }
    
}
