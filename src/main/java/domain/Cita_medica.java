package domain;

public class Cita_medica {

    private Integer id_cita;
    private String fecha_cita;
    private String hora;
    private String identificacion_medico_cita;
    private String identificacion_paciente_cita;
    private String estado_cita;
    private Integer formula_medica_cita;
    private String nombre_paciente;
    private String nombre_medico;

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getNombre_medico() {
        return nombre_medico;
    }

    public void setNombre_medico(String nombre_medico) {
        this.nombre_medico = nombre_medico;
    }

    public Integer getId_cita() {
        return id_cita;
    }

    public void setId_cita(Integer id_cita) {
        this.id_cita = id_cita;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getIdentificacion_medico_cita() {
        return identificacion_medico_cita;
    }

    public void setIdentificacion_medico_cita(String identificacion_medico_cita) {
        this.identificacion_medico_cita = identificacion_medico_cita;
    }

    public String getIdentificacion_paciente_cita() {
        return identificacion_paciente_cita;
    }

    public void setIdentificacion_paciente_cita(String identificacion_paciente_cita) {
        this.identificacion_paciente_cita = identificacion_paciente_cita;
    }

    public String getEstado_cita() {
        return estado_cita;
    }

    public void setEstado_cita(String estado_cita) {
        this.estado_cita = estado_cita;
    }

    public Integer getFormula_medica_cita() {
        return formula_medica_cita;
    }

    public void setFormula_medica_cita(Integer formula_medica_cita) {
        this.formula_medica_cita = formula_medica_cita;
    }

}
