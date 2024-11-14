package datos;

public abstract class ProductoElectroDomestico extends Producto{
    private String marca;
    private String modelo;
    private String color;
    private int garantia;
    private String voltaje;
    final String familia = "ProductoElectrodomestico";

    public ProductoElectroDomestico() {
        super();
    }
    
    public ProductoElectroDomestico(String idProducto, String nombre, double precio
                        ,String descripcion,String familia
                        ,String marca, String modelo, String color, int garantia, String voltaje) {
        super(idProducto, nombre, precio, descripcion,familia);
        this.marca = marca;
        this.modelo = modelo;  
        this.color = color;
        this.garantia = garantia;
        this.voltaje = voltaje;

    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getGarantia() {
        return garantia;
    }
    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }
    public String getVoltaje() {
        return voltaje;
    }
    public void setVoltaje(String voltaje) {
        this.voltaje = voltaje;
    }

    @Override
    public String obtenerDetalles() {
        return super.toString()+", Color=" + color + ", garantia=" + garantia + ", marca=" + marca + ", modelo=" + modelo
                + ", voltaje=" + voltaje;
    }

    @Override
    public String toString() {
        return super.toString()+"," + marca + "," + modelo + "," + color + "," + garantia
                + "," + voltaje ;
    }

    //a un producto electrodomestico se le puede aplicar un descuento de hasta el 50%
    @Override
    public boolean aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <=50)
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
        return "ProductoElectrodomestico";
    }



    
    
}
