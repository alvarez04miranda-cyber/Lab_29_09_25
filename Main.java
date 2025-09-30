public class Main {
    public static void main(String[] args) {
        Cola_Circular cola = new Cola_Circular(3);

        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);

        System.out.println("Peek: " + cola.peek());
        System.out.println("Dequeue: " + cola.dequeue());
        System.out.println("Dequeue: " + cola.dequeue());

        cola.enqueue(4);
        cola.enqueue(5); // debe reutilizar espacio

        System.out.println("Elementos en la cola: " + cola.getTamanio());

        while (!cola.isEmpty()) {
            System.out.println("Atendiendo: " + cola.dequeue());
        }
    }
}
