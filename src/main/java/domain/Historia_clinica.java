package domain;

public class Historia_clinica {

    private Integer codigo_historia;
    private String numero_historia;
    private String fecha_apertura;
    private String identificacion_paciente;
    protected String nombre_paciente;
    private String numero_historiaAg;

    public String getNumero_historiaAg() {
        return numero_historiaAg;
    }

    public void setNumero_historiaAg(String numero_historiaAg) {
        this.numero_historiaAg = numero_historiaAg;
    }

    public Integer getCodigo_historia() {
        return codigo_historia;
    }

    public void setHistoria_serial(Integer codigo_historia) {
        this.codigo_historia = codigo_historia;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getNumero_historia() {
        return numero_historia;
    }

    public void setNumero_historia(String numero_historia) {
        this.numero_historia = numero_historia;
    }

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public String getIdentificacion_paciente() {
        return identificacion_paciente;
    }

    public void setIdentificacion_paciente(String identificacion_paciente) {
        this.identificacion_paciente = identificacion_paciente;
    }

}
