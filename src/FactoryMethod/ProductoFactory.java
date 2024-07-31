package FactoryMethod;

public abstract class ProductoFactory {
    /**
     * Método abstracto que debe ser implementado por las subclases para crear instancias de productos específicos.
     */
    public abstract Producto createProducto(double precio);
    public Producto registrarProducto(double precio) {
        return createProducto(precio);
    }
}