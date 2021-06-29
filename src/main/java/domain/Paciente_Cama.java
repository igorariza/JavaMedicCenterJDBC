package domain;

public class Paciente_Cama {

    private String identificacion_paciente;
    private String numero_de_cama;
    private String fecha_inicial;
    private String fecha_final;

    public String getIdentificacion_paciente() {
        return identificacion_paciente;
    }

    public void setIdentificacion_paciente(String identificacion_paciente) {
        this.identificacion_paciente = identificacion_paciente;
    }

    public String getNumero_de_cama() {
        return numero_de_cama;
    }

    public void setNumero_de_cama(String numero_de_cama) {
        this.numero_de_cama = numero_de_cama;
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
