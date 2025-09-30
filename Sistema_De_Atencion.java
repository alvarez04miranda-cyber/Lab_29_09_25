public class Sistema_De_Atencion {
    private Cola_Simple colaClientes;

    public void setColaClientes(Cola_Simple colaClientes) {
        this.colaClientes = colaClientes;
    }

    private int SiguienteTicket;

    public Sistema_De_Atencion(int capacidadMaxima) {
        this.colaClientes = new Cola_Simple(capacidadMaxima);
        this.SiguienteTicket = 1;
    }

    // Permitir a los clientes tomar un ticket
    public void tomarTicket() {
        boolean agregado = colaClientes.enqueue(SiguienteTicket);
        if (agregado) {
            System.out
                    .println("Ticket #" + SiguienteTicket + " - Hay " + colaClientes.getTam() + " clientes esperando");
            SiguienteTicket++;
        }
    }

    // Atender al siguiente cliente
    public void atenderCliente() {
        int cliente = colaClientes.dequeue();
        if (cliente != -1) {
            System.out.println("Atendiendo al cliente con ticket #" + cliente);
        } else {
            System.out.println("No hay clientes para atender");
        }
    }

    // Mostrar estado del sistema
    public void mostrarEstado() {
        System.out.println("===== Estado del Sistema =====");
        if (!colaClientes.isEmpty()) {
            System.out.println("Cliente actual: Ticket #" + colaClientes.peek());
        } else {
            System.out.println("No hay cliente actual siendo atendido");
        }
        System.out.println("Clientes en espera: " + colaClientes.getTam());
        System.out.println("Proximo ticket a asignar: " + SiguienteTicket);
        System.out.println("==============================");
    }

    public static void main(String[] args) {
        Sistema_De_Atencion sistema = new Sistema_De_Atencion(10);

        // Prueba del sistema
        sistema.tomarTicket(); // Cliente 1
        sistema.tomarTicket(); // Cliente 2
        sistema.tomarTicket(); // Cliente 3

        sistema.mostrarEstado();

        sistema.atenderCliente(); // Atender al 1
        sistema.atenderCliente(); // Atender al 2

        sistema.mostrarEstado();

        sistema.tomarTicket(); // Cliente 4

        sistema.atenderCliente(); // Atender al 3
        sistema.atenderCliente(); // Atender al 4
        sistema.atenderCliente(); // No hay clientes
    }
}