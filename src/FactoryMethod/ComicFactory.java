package FactoryMethod;

public class ComicFactory extends ProductoFactory {
    /**
     * Crea una instancia de la clase Comic con el precio especificado.
     */
    @Override
    public Producto createProducto(double precio) {
        return new Comic(precio);
    }
}