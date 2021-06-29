package domain;

public class Participante_Campana {

    private String codigo_de_campana;
    private String identificacion_paciente;
    private String nombre_campana;
    private String nombre_paciente;
    private String direccion_paciente;
    private String  telefono_pacietne;

    public String getDireccion_paciente() {
        return direccion_paciente;
    }

    public void setDireccion_paciente(String direccion_paciente) {
        this.direccion_paciente = direccion_paciente;
    }

    public String getTelefono_pacietne() {
        return telefono_pacietne;
    }

    public void setTelefono_pacietne(String telefono_pacietne) {
        this.telefono_pacietne = telefono_pacietne;
    }
    
    

    public String getNombre_campana() {
        return nombre_campana;
    }

    public void setNombre_campana(String nombre_campana) {
        this.nombre_campana = nombre_campana;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }
    
    

    public String getCodigo_de_campana() {
        return codigo_de_campana;
    }

    public void setCodigo_de_campana(String codigo_de_campana) {
        this.codigo_de_campana = codigo_de_campana;
    }

    public String getIdentificacion_paciente() {
        return identificacion_paciente;
    }

    public void setIdentificacion_paciente(String identificacion_paciente) {
        this.identificacion_paciente = identificacion_paciente;
    }

}
