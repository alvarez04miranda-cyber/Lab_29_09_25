public class Cola_Simple {
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
    private int tam;

    public Cola_Simple(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new int[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.tam = 0;
    }

    // Agregar elemento a la cola
    public boolean enqueue(int elemento) {
        if (isFull()) {
            System.out.println("Cola llena. No se puede agregar: " + elemento);
            return false;
        }
        fin = (fin + 1) % capacidad;
        elementos[fin] = elemento;
        tam++;
        return true;
    }

    // Eliminar y retornar el primer elemento
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Cola vacía");
            return -1;
        }
        int elemento = elementos[frente];
        frente = (frente + 1) % capacidad;
        tam--;
        return elemento;
    }

    // Ver el primer elemento sin eliminarlo
    public int peek() {
        if (isEmpty()) {
            System.out.println("Cola vacía");
            return -1;
        }
        return elementos[frente];
    }

    public boolean isEmpty() {
        return tam == 0;
    }

    public boolean isFull() {
        return tam == capacidad;
    }

    public int getTam() {
        return tam;
    }
}