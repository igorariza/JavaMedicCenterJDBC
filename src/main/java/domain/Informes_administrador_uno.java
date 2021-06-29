package domain;

public class Informes_administrador_uno {

    private String nombre_empleado;
    private String identificacion_medico_cita;
    private String citas_atendidas;
    private String fecha_inicial;
    private String fecha_final;

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getIdentificacion_medico_cita() {
        return identificacion_medico_cita;
    }

    public void setIdentificacion_medico_cita(String identificacion_medico_cita) {
        this.identificacion_medico_cita = identificacion_medico_cita;
    }

    public String getCitas_atendidas() {
        return citas_atendidas;
    }

    public void setCitas_atendidas(String citas_atendidas) {
        this.citas_atendidas = citas_atendidas;
    }

    public String getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(String fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }
}
