public class Cola_Circular {
    public void setElementos(int[] elementos) {
        this.elementos = elementos;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    private int[] elementos;
    private int frente;
    private int fin;
    private int capacidad;

    public Cola_Circular(int capacidad) {
        this.capacidad = capacidad + 1; // Un espacio extra para diferenciar lleno de vacío
        this.elementos = new int[this.capacidad];
        this.frente = 0;
        this.fin = 0;
    }

    // Insertar elemento
    public boolean enqueue(int elemento) {
        if (isFull()) {
            System.out.println("Cola circular llena");
            return false;
        }
        elementos[fin] = elemento;
        fin = (fin + 1) % capacidad;
        return true;
    }

    // Eliminar elemento
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Cola circular vacía");
            return -1;
        }
        int elemento = elementos[frente];
        frente = (frente + 1) % capacidad;
        return elemento;
    }

    // Ver frente
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return elementos[frente];
    }

    public boolean isEmpty() {
        return frente == fin;
    }

    public boolean isFull() {
        return (fin + 1) % capacidad == frente;
    }

    public int getTamanio() {
        return (fin - frente + capacidad) % capacidad;
    }
}
