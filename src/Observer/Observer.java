package Observer;

public interface Observer {
    /**
     * Método que debe ser implementado por las clases observers para reaccionar a los cambios en el pedido.
     */
    void update(PedidoObservable pedidoObservable);
}
