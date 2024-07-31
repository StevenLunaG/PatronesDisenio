package FactoryMethod;

public interface Producto {
    /**
     * Retorna el precio del producto.
     */
    String obtenerTipo();

    /**
     * Retorna el tipo de producto como una cadena.
     */
    double obtenerPrecio();
}
