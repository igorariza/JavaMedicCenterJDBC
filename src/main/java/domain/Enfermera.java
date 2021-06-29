package domain;

public class Enfermera {

    private String identificacion_enfermera;
    private String nombre_empleado;
    private String anos_de_experiencia;
    private String salario;
    private String telefono_empleado;
    private String e_mail;
    private String direccion_empleado;

    public String getDireccion_empleado() {
        return direccion_empleado;
    }

    public void setDireccion_empleado(String direccion_empleado) {
        this.direccion_empleado = direccion_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getTelefono_empleado() {
        return telefono_empleado;
    }

    public void setTelefono_empleado(String telefono_empleado) {
        this.telefono_empleado = telefono_empleado;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getAnos_de_experiencia() {
        return anos_de_experiencia;
    }

    public void setAnos_de_experiencia(String anos_de_experiencia) {
        this.anos_de_experiencia = anos_de_experiencia;
    }

    public String getIdentificacion_enfermera() {
        return identificacion_enfermera;
    }

    public void setIdentificacion_enfermera(String identificacion_enfermera) {
        this.identificacion_enfermera = identificacion_enfermera;
    }

}
