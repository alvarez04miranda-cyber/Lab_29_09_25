import java.util.Scanner;

public class Sistema_Pedidos {
    private Cola_Simple colaPedidos;
    private Pedido[] pedidos;
    private int siguienteId;

    public Sistema_Pedidos(int capacidadMaxima) {
        this.colaPedidos = new Cola_Simple(capacidadMaxima);
        this.pedidos = new Pedido[capacidadMaxima];
        this.siguienteId = 1;
    }

    // Nuevo pedido
    public void nuevoPedido(String descripcion) {
        Pedido pedido = new Pedido(siguienteId, descripcion);
        if (colaPedidos.enqueue(siguienteId)) {
            pedidos[siguienteId - 1] = pedido;
            System.out.println("Pedido #" + pedido.getId() + " agregado: " + pedido.getDescripcion());
            siguienteId++;
        }
    }

    // Preparar el siguiente
    public void prepararSiguiente() {
        if (colaPedidos.isEmpty()) {
            System.out.println("No hay pedidos para preparar");
            return;
        }
        int idPedido = colaPedidos.peek();
        Pedido pedido = pedidos[idPedido - 1];
        pedido.setPreparado(true);
        System.out.println("Pedido #" + pedido.getId() + " preparado: " + pedido.getDescripcion());
    }

    // Entregar
    public void entregarPedido() {
        if (colaPedidos.isEmpty()) {
            System.out.println("No hay pedidos para entregar");
            return;
        }
        int idPedido = colaPedidos.peek();
        Pedido pedido = pedidos[idPedido - 1];
        if (!pedido.isPreparado()) {
            System.out.println("ADVERTENCIA: El pedido #" + pedido.getId() + " no está preparado");
            return;
        }
        colaPedidos.dequeue();
        System.out.println("Pedido #" + pedido.getId() + " entregado: " + pedido.getDescripcion());
    }

    // Mostrar pendientes
    public void mostrarPedidosPendientes() {
        if (colaPedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
            return;
        }
        System.out.println("PEDIDOS PENDIENTES:");
        for (int i = 0; i < siguienteId - 1; i++) {
            Pedido p = pedidos[i];
            if (p != null && !colaPedidos.isEmpty()) {
                if (p.getId() >= colaPedidos.peek()) { // dentro de la cola
                    System.out.println(p);
                }
            }
        }
    }

    // MAIN: menú interactivo
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sistema_Pedidos sistema = new Sistema_Pedidos(5);

        int opcion;
        do {
            System.out.println("\n--- MENÚ SISTEMA DE PEDIDOS ---");
            System.out.println("1. Nuevo pedido");
            System.out.println("2. Preparar siguiente");
            System.out.println("3. Entregar pedido");
            System.out.println("4. Mostrar pedidos pendientes");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Descripción del pedido: ");
                    String desc = sc.nextLine();
                    sistema.nuevoPedido(desc);
                    break;
                case 2:
                    sistema.prepararSiguiente();
                    break;
                case 3:
                    sistema.entregarPedido();
                    break;
                case 4:
                    sistema.mostrarPedidosPendientes();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}