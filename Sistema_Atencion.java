import java.util.Scanner;

public class Sistema_Atencion {
    private Cola_Simple colaClientes;

    public void setColaClientes(Cola_Simple colaClientes) {
        this.colaClientes = colaClientes;
    }

    private int siguienteTicket;
    private Integer clienteActual; // null si no hay cliente en atención

    public Sistema_Atencion(int capacidadMaxima) {
        this.colaClientes = new Cola_Simple(capacidadMaxima);
        this.siguienteTicket = 1;
        this.clienteActual = null;
    }

    // Cliente toma un ticket
    public void tomarTicket() {
        if (colaClientes.enqueue(siguienteTicket)) {
            System.out.println("Ticket #" + siguienteTicket +
                    " - Hay " + colaClientes.getTam() + " clientes esperando");
            siguienteTicket++;
        }
    }

    // Atender al siguiente cliente
    public void atenderCliente() {
        if (colaClientes.isEmpty()) {
            System.out.println("No hay clientes para atender");
            clienteActual = null;
            return;
        }
        clienteActual = colaClientes.dequeue();
        System.out.println("Atendiendo al cliente con ticket #" + clienteActual);
    }

    // Mostrar estado actual del sistema
    public void mostrarEstado() {
        System.out.println("=== Estado del Sistema ===");
        if (clienteActual != null) {
            System.out.println("Cliente actual en atención: #" + clienteActual);
        } else {
            System.out.println("No hay cliente en atención");
        }
        System.out.println("Clientes esperando: " + colaClientes.getTam());
        System.out.println("Próximo ticket a asignar: #" + siguienteTicket);
        System.out.println("==========================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sistema_Atencion sistema = new Sistema_Atencion(10);

        int opcion;
        do {
            System.out.println("\n--- MENÚ SISTEMA DE ATENCIÓN ---");
            System.out.println("1. Tomar ticket");
            System.out.println("2. Atender cliente");
            System.out.println("3. Mostrar estado");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    sistema.tomarTicket();
                    break;
                case 2:
                    sistema.atenderCliente();
                    break;
                case 3:
                    sistema.mostrarEstado();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
