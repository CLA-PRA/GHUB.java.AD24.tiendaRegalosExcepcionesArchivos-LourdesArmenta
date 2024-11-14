package datos;


public class Television extends ProductoElectronico{
    private String tamanio;
    private String resolucion;
    private String tipoPantalla;
    private final String familia = super.getFamilia();

    public Television(String idProducto, String nombre, double precio, String descripcion, String familia
                    ,String marca, String modelo, String color, int garantia, String voltaje
                    ,String tamanio, String resolucion, String tipoPantalla)
    {
        super(idProducto, nombre, precio, descripcion, familia,marca, modelo, color, garantia, voltaje);
        this.tamanio = tamanio;
        this.resolucion = resolucion;
        this.tipoPantalla = tipoPantalla;
    }

    public static Television fromString(String[] partes) {
        if (partes.length < 13) {
            throw new IllegalArgumentException("Datos incompletos para crear una Television");
        }
        try{
        String idProducto = partes[0].trim();
        String nombre = partes[1].trim();
        double precio = Double.parseDouble(partes[2].trim());
        String descripcion = partes[3].trim();
        String familia = partes[4].trim();
        String marca = partes[5].trim();
        String modelo = partes[6].trim();
        String color = partes[7].trim();
        int garantia = Integer.parseInt(partes[8].trim());
        String voltaje = partes[9].trim();
        String tamanio = partes[10].trim();
        String resolucion = partes[11].trim();
        String tipoPantalla = partes[12].trim();
        return new Television(idProducto, nombre, precio, descripcion, familia, marca, 
                modelo, color, garantia, voltaje, tamanio, resolucion, tipoPantalla);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir número: " + e.getMessage());
            throw e; // Re-lanzar la excepción para que pueda ser manejada en un nivel superior
        }
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public void setTipoPantalla(String tipoPantalla) {
        this.tipoPantalla = tipoPantalla;
    }

    //metodo getFamilia sobreescrito de la clase ProductoElectronico
    @Override
    public String getFamilia(){
        return super.getFamilia();
    }


    //sobreescritura del metodo obtenerDetalles de la clase ProductoElectronico y
    //agregando los atributos tamanio, resolucion y tipoPantalla
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles()+"Television 3resolucion=" + resolucion + ", tamanio=" + tamanio + ", tipoPantalla=" + tipoPantalla;
    }

    @Override
    //a un producto electronico se le puede aplicar un descuento de hasta el 20%
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
        return super.toString()+"," + tamanio + "," + resolucion + "," + tipoPantalla;
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
        return true; //este producto es vendible al público
    }
    
    
    
}