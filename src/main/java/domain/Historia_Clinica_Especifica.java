package domain;

public class Historia_Clinica_Especifica {

    private Integer historia_serial_hce;
    private String fecha_consulta;
    private String identificacion_medico_hce;
    private double precio;
    private String causas_hce;
    private double descuento;

    public Integer getHistoria_serial_hce() {
        return historia_serial_hce;
    }

    public void setHistoria_serial_hce(Integer historia_serial_hce) {
        this.historia_serial_hce = historia_serial_hce;
    }

    public String getFecha_consulta() {
        return fecha_consulta;
    }

    public void setFecha_consulta(String fecha_consulta) {
        this.fecha_consulta = fecha_consulta;
    }

    public String getIdentificacion_medico_hce() {
        return identificacion_medico_hce;
    }

    public void setIdentificacion_medico_hce(String identificacion_medico_hce) {
        this.identificacion_medico_hce = identificacion_medico_hce;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCausas_hce() {
        return causas_hce;
    }

    public void setCausas_hce(String causas_hce) {
        this.causas_hce = causas_hce;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

}
