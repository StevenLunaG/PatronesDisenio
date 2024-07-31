package Observer;

import FactoryMethod.Producto;

import java.util.ArrayList;
import java.util.List;

public class PedidoObservable {
    private List<Producto> productos;
    private List<Observer> observers;

    public PedidoObservable() {
        this.productos = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    /**
     * Agrega un observador a la lista de observadores del pedido.
     */
    public void suscribeObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Elimina un observador de la lista de observadores del pedido.
     */
    public void unsuscribeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifica a todos los observadores sobre cambios en el pedido.
     */
    public void notificarObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    /**
     * Agrega un producto al pedido y notifica a los observadores.
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        notificarObservers();
    }

    /**
     * Calcula el costo total de los productos en el pedido.
     */
    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.obtenerPrecio();
        }
        return total;
    }

    /**
     * Muestra el detalle de los productos en el pedido y el total.
     */
    public void mostrarPedido() {
        for (Producto producto : productos) {
            System.out.println(producto.obtenerTipo() + ": $" + producto.obtenerPrecio());
        }
        System.out.println(" TOTAL: $" + calcularTotal());
    }
}
