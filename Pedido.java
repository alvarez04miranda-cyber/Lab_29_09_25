public class Pedido {
    private int id;
    private String descripcion;
    private boolean preparado;

    public Pedido(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.preparado = false;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isPreparado() {
        return preparado;
    }

    public void setPreparado(boolean preparado) {
        this.preparado = preparado;
    }

    @Override
    public String toString() {
        return "#" + id + " [" + (preparado ? "Preparado" : "Pendiente") + "] - " + descripcion;
    }
}