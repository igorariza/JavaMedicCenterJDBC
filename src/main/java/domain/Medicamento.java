package domain;

public class Medicamento {

    private String codigo_medicamento;
    private String nombre_medicamento;
    private String descripcion_medicamento;
    private double costo;

    public String getCodigo_medicamento() {
        return codigo_medicamento;
    }

    public void setCodigo_medicamento(String codigo_medicamento) {
        this.codigo_medicamento = codigo_medicamento;
    }

    public String getNombre_medicamento() {
        return nombre_medicamento;
    }

    public void setNombre_medicamento(String nombre_medicamento) {
        this.nombre_medicamento = nombre_medicamento;
    }

    public String getDescripcion_medicamento() {
        return descripcion_medicamento;
    }

    public void setDescripcion_medicamento(String descripcion_medicamento) {
        this.descripcion_medicamento = descripcion_medicamento;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

}
