package negocio;

public interface Vendible {
        boolean esVendible();
        double calcularPrecio();
        double calcularPrecio(double porcentaje);
}
