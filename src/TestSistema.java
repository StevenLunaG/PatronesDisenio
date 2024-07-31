import FactoryMethod.*;
import Observer.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class TestSistema {
    public static void main(String[] args) {
        SimpleDateFormat formato = new SimpleDateFormat("d 'de' MMMM, yyyy", new Locale("es", "ES"));
        Scanner scanner = new Scanner(System.in);
        Map<String, PedidoObservable> pedidos = new HashMap<>();
        Map<String, Observer> observadores = new HashMap<>();

        ProductoFactory comicFactory = new ComicFactory();
        ProductoFactory figuraFactory = new FiguraFactory();

        System.out.println("\nSISTEMA DE REGISTRO DE PEDIDOS. " + String.format(formato.format(new Date())));
        while (true) {
            try {
                System.out.println("\nSeleccione una opción:");
                System.out.println("1. Agregar nuevo cliente");
                System.out.println("2. Añadir comic al pedido de un cliente");
                System.out.println("3. Añadir figura al pedido de un cliente");
                System.out.println("4. Mostrar pedido de un cliente");
                System.out.println("5. Anular notificaciones a un cliente");
                System.out.println("6. Salir");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion == 6) {
                    System.out.println("||Gracias por utilizar el sistema. ¡Hasta luego!||");
                    break;
                }

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nombre del nuevo cliente:");
                        String nombreCliente = scanner.nextLine();
                        if (!pedidos.containsKey(nombreCliente)) {
                            PedidoObservable pedidoObservable = new PedidoObservable();
                            Observer clienteObserver = new ClienteObserver(nombreCliente);
                            Observer notificacionServicio = new PedidoObserver();
                            pedidoObservable.suscribeObserver(clienteObserver);
                            pedidoObservable.suscribeObserver(notificacionServicio);
                            pedidos.put(nombreCliente, pedidoObservable);
                            observadores.put(nombreCliente, clienteObserver);  // Mapear observadores
                            System.out.println("|Cliente agregado: " + nombreCliente + '|');
                        } else {
                            System.out.println("|El cliente ya existe.|");
                        }
                        break;
                    case 2:
                    case 3:
                        System.out.println("Ingrese el nombre del cliente:");
                        nombreCliente = scanner.nextLine();
                        PedidoObservable pedidoObservable = pedidos.get(nombreCliente);
                        if (pedidoObservable != null) {
                            System.out.println("Ingrese el precio del producto:");
                            double precio = scanner.nextDouble();
                            scanner.nextLine();

                            if (opcion == 2) {
                                Producto comic = comicFactory.registrarProducto(precio);
                                pedidoObservable.agregarProducto(comic);
                            } else {
                                Producto figura = figuraFactory.registrarProducto(precio);
                                pedidoObservable.agregarProducto(figura);
                            }
                        } else {
                            System.out.println("|Cliente no encontrado.|");
                        }
                        break;
                    case 4:
                        System.out.println("Ingrese el nombre del cliente:");
                        nombreCliente = scanner.nextLine();
                        pedidoObservable = pedidos.get(nombreCliente);
                        if (pedidoObservable != null) {
                            pedidoObservable.mostrarPedido();
                        } else {
                            System.out.println("|Cliente no encontrado.|");
                        }
                        break;
                    case 5:
                        System.out.println("Ingrese el nombre del cliente al que desea detener su notificación:");
                        nombreCliente = scanner.nextLine();
                        pedidoObservable = pedidos.get(nombreCliente);
                        Observer observer = observadores.get(nombreCliente);
                        if (pedidoObservable != null && observer != null) {
                            pedidoObservable.unsuscribeObserver(observer);
                            observadores.remove(nombreCliente);
                            System.out.println("|Notificaciones del cliente " + nombreCliente + " detenidas.|");
                        } else {
                            System.out.println("|Cliente u observador no encontrado.|");
                        }
                        break;
                    default:
                        System.out.println("||Opción no válida. Por favor intente de nuevo.||");
                }
            } catch (InputMismatchException e) {
                System.out.println("||ENTRADA NO VALIDA. Por favor, ingrese el número de la opcion que desea.||");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
