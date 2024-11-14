
package datos;


public class Celular extends ProductoElectronico {
    private int numCamaras;
    private String sistemaOperativo;
    private int capacidadAlmacenamiento;
    private int ram;
    private String tipoPantalla;
    final String familia = super.getFamilia();

    public Celular(String idProducto, String nombre, double precio, String descripcion, String familia
                    ,String marca, String modelo, String color, int garantia, String voltaje
                    ,int numCamaras, String sistemaOperativo, int capacidadAlmacenamiento, int ram, String tipoPantalla)
    {
        super(idProducto, nombre, precio, descripcion, familia, marca, modelo, color, garantia, voltaje);
        this.numCamaras = numCamaras;
        this.sistemaOperativo = sistemaOperativo;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
        this.ram = ram;
        this.tipoPantalla = tipoPantalla;
    }

    public static Celular fromString(String[] partes) {
        if (partes.length < 15) {
            throw new IllegalArgumentException("Datos incompletos para crear un Celular");
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
            int numCamaras = Integer.parseInt(partes[10].trim());
            String sistemaOperativo = partes[11].trim();
            int capacidadAlmacenamiento = Integer.parseInt(partes[12].trim());
            int ram = Integer.parseInt(partes[13].trim());
            String tipoPantalla = partes[14].trim();
            return new Celular(idProducto, nombre, precio, descripcion, familia, marca, 
                    modelo, color, garantia, voltaje, numCamaras, sistemaOperativo, capacidadAlmacenamiento, ram, tipoPantalla);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir número: " + e.getMessage());
            throw e; // Re-lanzar la excepción para que pueda ser manejada en un nivel superior
        }
    }

    public int getNumCamaras() {
        return numCamaras;
    }

    public void setNumCamaras(int numCamaras) {
        this.numCamaras = numCamaras;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public int getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    public void setCapacidadAlmacenamiento(int capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public void setTipoPantalla(String tipoPantalla) {
        this.tipoPantalla = tipoPantalla;
    }

    @Override
    public String getFamilia(){
        return super.getFamilia();
    }

    //sobreescritura del metodo obtenerDetalles de la clase ProductoElectronico y
    //agregando los atributos numCamaras, sistemaOperativo, capacidadAlmacenamiento, ram y tipoPantalla
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles()+"Celular [capacidadAlmacenamiento=" + capacidadAlmacenamiento + ", numCamaras=" + numCamaras + ", ram=" + ram + ", sistemaOperativo=" + sistemaOperativo + ", tipoPantalla=" + tipoPantalla + "]";
    }

    @Override
    //se le puede aplicar un descuento de hasta el 20%
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

        return super.toString()+"," + numCamaras + "," + sistemaOperativo +
                                "," + capacidadAlmacenamiento + "," + ram +  ", " + tipoPantalla;
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
        return true; //es vendible
    }
    
    

    
}