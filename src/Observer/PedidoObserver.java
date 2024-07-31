package Observer;

public class PedidoObserver implements Observer {
    /**
     * Implementación del método para enviar notificaciones del sistema cuando hay cambios en el pedido.
     */
    @Override
    public void update(PedidoObservable pedidoObservable) {
        System.out.println("\nNOTIFICACIÓN SISTEMA: El pedido ha sido actualizado.");
    }
}