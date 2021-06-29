package domain;

public class Area {

    private String codigo_area;
    private String nombre_area;
    private String descripcion_area;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo_area() {
        return codigo_area;
    }

    public String getNombre_area() {
        return nombre_area;
    }

    public String getDescripcion_area() {
        return descripcion_area;
    }

    public void setCodigo_area(String codigo_area) {
        this.codigo_area = codigo_area;
    }

    public void setNombre_area(String nombre) {
        this.nombre_area = nombre;
    }

    public void setDescripcion_area(String descripcion_area) {
        this.descripcion_area = descripcion_area;
    }

}
