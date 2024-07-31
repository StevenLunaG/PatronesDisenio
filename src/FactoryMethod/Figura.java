package FactoryMethod;

public class Figura implements Producto {
    private double precio;

    public Figura(double precio) {
        this.precio = precio;
    }

    /**
     * Retorna el tipo "Figura".
     */
    @Override
    public String obtenerTipo() {
        return " FactoryMethod.Figura";
    }

    /**
     * Implementación específica de Producto para retornar el precio de la figura.
     */
    @Override
    public double obtenerPrecio() {
        return precio;
    }
}