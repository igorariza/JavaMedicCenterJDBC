package domain;

public class AgendaDTO {

    private String id_cita;				
    private String hora;				
    private String identificacion_medico_cita;			
    private String identificacion_paciente_cita;	
    private String estado_cita;
    private String formula_medica_cita;

    public String getId_cita() {
        return id_cita;
    }

    public void setId_cita(String id_cita) {
        this.id_cita = id_cita;
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

    public String getFormula_medica_cita() {
        return formula_medica_cita;
    }

    public void setFormula_medica_cita(String formula_medica_cita) {
        this.formula_medica_cita = formula_medica_cita;
    }
    
    
    

    
}
