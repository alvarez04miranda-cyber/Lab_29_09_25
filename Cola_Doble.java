public class Cola_Doble {
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

    public Cola_Doble(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new int[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.tam = 0;
    }

    // Agregar al final
    public boolean agregarFinal(int elemento) {
        if (isFull()) {
            System.out.println("Cola llena, no se puede insertar al final.");
            return false;
        }
        fin = (fin + 1) % capacidad;
        elementos[fin] = elemento;
        tam++;
        return true;
    }

    // Agregar al frente
    public boolean agregarFrente(int elemento) {
        if (isFull()) {
            System.out.println("Cola llena, no se puede insertar al frente.");
            return false;
        }
        frente = (frente - 1 + capacidad) % capacidad;
        elementos[frente] = elemento;
        tam++;
        return true;
    }

    // Eliminar del frente
    public int eliminarFrente() {
        if (isEmpty()) {
            System.out.println("Cola vacía, no se puede eliminar del frente.");
            return -1;
        }
        int elemento = elementos[frente];
        frente = (frente + 1) % capacidad;
        tam--;
        return elemento;
    }

    // Eliminar del final
    public int eliminarFinal() {
        if (isEmpty()) {
            System.out.println("Cola vacía, no se puede eliminar del final.");
            return -1;
        }
        int elemento = elementos[fin];
        fin = (fin - 1 + capacidad) % capacidad;
        tam--;
        return elemento;
    }

    public int peekFrente() {
        if (isEmpty()) {
            return -1;
        }
        return elementos[frente];
    }

    public int peekFinal() {
        if (isEmpty()) {
            return -1;
        }
        return elementos[fin];
    }

    public boolean isEmpty() {
        return tam == 0;
    }

    public boolean isFull() {
        return tam == capacidad;
    }

    public int getTamanio() {
        return tam;
    }
}