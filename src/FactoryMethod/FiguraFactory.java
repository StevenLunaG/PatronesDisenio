package FactoryMethod;

public class FiguraFactory extends ProductoFactory {
    /**
     * Crea una instancia de la clase Figura con el precio especificado.
     */
    @Override
    public Producto createProducto(double precio) {
        return new Figura(precio);
    }
}