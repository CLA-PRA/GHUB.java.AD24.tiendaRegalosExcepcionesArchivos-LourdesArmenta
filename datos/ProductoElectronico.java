package datos;

public abstract class ProductoElectronico  extends Producto {
    private String marca;
    private String modelo;
    private String color;
    private int garantia;
    private String voltaje;
    final String familia = "ProductoElectronico";
    public ProductoElectronico(String idProducto, String nombre, double precio, String descripcion
                        ,String familia
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
        return super.toString()+",color=" + color + ", garantia=" + garantia + ", marca=" + marca + ", modelo=" + modelo
                + ", voltaje=" + voltaje ;
    }

    @Override
    public String toString() {
        return super.toString()+"," + marca + "," + modelo+","+color+","+ garantia + "," + voltaje;
    }

    @Override
    //a un producto electronico se le puede aplicar un descuento de hasta el 20%
    public boolean aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <=20)
          return true;
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
        return "ProductoElectronico";
    }
    
}
