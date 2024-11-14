package datos;

public class Tostadora extends ProductoElectroDomestico {
    private int numRanuras;
    final String familia = super.getFamilia();
    
    public Tostadora(String idProducto, String nombre, double precio, String descripcion, String familia
                        ,String marca, String modelo, String color, int garantia, String voltaje
                        ,int numRanuras) {
        super(idProducto, nombre, precio, descripcion, familia, marca, modelo, color, garantia, voltaje);
        this.numRanuras = numRanuras;
    }

    public static Tostadora fromString(String[] partes) {
        if (partes.length < 11) {
            //lanza una excepción de tipo IllegalArgumentException con el mensaje "Datos incompletos para crear una Tostadora"
            
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
            int numRanuras = Integer.parseInt(partes[10].trim());
            return new Tostadora(idProducto, nombre, precio, descripcion, familia, marca,
                    modelo, color, garantia, voltaje, numRanuras);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir número: " + e.getMessage());
            throw e; // Re-lanzar la excepción para que pueda ser manejada en un nivel superior
        }
    }

    public int getNumRanuras() {
        return numRanuras;
    }

    public void setNumRanuras(int numRanuras) {
        this.numRanuras = numRanuras;
    }

    //metodo getFamilia sobreescrito de la clase ProductoElectronico
    @Override
    public String getFamilia(){
        return super.getFamilia();
    }

    //sobreescritura del metodo obtenerDetalles de la clase ProductoElectronico y
    //agregando el atributo numRanuras
    @Override
    public String obtenerDetalles() {
        
        return super.obtenerDetalles()+"Tostadora numRanuras=" + numRanuras;
    }


    @Override
    //a un producto electrodomestico se le puede aplicar un descuento de hasta el 50%
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
        return super.toString()+"," + numRanuras;
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