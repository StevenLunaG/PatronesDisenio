package Observer;

public class ClienteObserver implements Observer {
    private String nombre;

    public ClienteObserver(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Implementación del método para notificar al cliente sobre cambios en su pedido.
     */
    @Override
    public void update(PedidoObservable pedidoObservable) {
        System.out.println("\n"+ nombre + " ha sido notificado. Nuevo estado del pedido:");
        pedidoObservable.mostrarPedido();
    }
}