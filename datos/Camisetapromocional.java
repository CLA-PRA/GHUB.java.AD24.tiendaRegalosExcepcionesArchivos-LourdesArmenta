package datos;

public class Camisetapromocional extends ProductoPromocional {
    private String talla;
    private String color;
    final String familia = super.getFamilia();

    public Camisetapromocional(String idProducto, String nombre, double precio, 
                                String descripcion, String familia,
                               String talla, String color) {
        super(idProducto, nombre, precio, descripcion,familia);
        this.talla = talla;
        this.color = color;
    }

    public static Camisetapromocional fromString(String[] partes) {
        if (partes.length < 7) {
            throw new IllegalArgumentException("Datos incompletos para crear una CamisetaPromocional");
        }
        try{
            String idProducto = partes[0].trim();
            String nombre = partes[1].trim();
            double precio = Double.parseDouble(partes[2].trim());
            String descripcion = partes[3].trim();
            String familia = partes[4].trim();
            String talla = partes[5].trim();
            String color = partes[6].trim();
            return new Camisetapromocional(idProducto, nombre, precio, descripcion, familia, 
                    talla, color);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir número: " + e.getMessage());
            throw e; // Re-lanzar la excepción para que pueda ser manejada en un nivel superior
        }
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    

    //metodo getFamilia sobreescrito de la clase ProductoPromocional
    @Override
    public String getFamilia(){
        return super.getFamilia();
    }


    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + ", Talla: " + talla + ", Color: " + color;
    }

    @Override
    public String toString() {
        return super.toString() + "," + talla + "," + color;
    }

    
}
