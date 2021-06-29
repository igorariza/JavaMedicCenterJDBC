package domain;

public class Formula_especifica {

    private Integer id_formula_especifica;
    private Integer id_formula_medica;
    private Integer cantidad;
    private String codigo_medicamento;
    private String nombre_medicamento;
    private String descripcion;
    private double precio;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

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

//--Formula_especifica(id_formula_especifica, id_formula_medica,codigo_medicamento,cantidad)
    public Integer getId_formula_especifica() {
        return id_formula_especifica;
    }

    public void setId_formula_especifica(Integer id_formula_especifica) {
        this.id_formula_especifica = id_formula_especifica;
    }

    public Integer getId_formula_medica() {
        return id_formula_medica;
    }

    public void setId_formula_medica(Integer id_formula_medica) {
        this.id_formula_medica = id_formula_medica;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
