package FactoryMethod;

public class Comic implements Producto {

    private double precio;

    public Comic(double precio) {
        this.precio = precio;
    }

    /**
     * Retorna el tipo "Comic".
     */
    @Override
    public String obtenerTipo() {
        return " FactoryMethod.Comic";
    }

    /**
     * Implementación específica de Producto para retornar el precio del comic.
     */
    @Override
    public double obtenerPrecio() {
        return precio;
    }
}