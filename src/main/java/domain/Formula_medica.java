package domain;

public class Formula_medica {

    private Integer codigo_formula;
    private String fecha_formula;
    private String id_medico_formula;
    private String nombre_medico_formula;
    private String id_paciente__consulta;
    private String nombre_paciente__formula;
//--Formula_medica(id_formula, identificacion_medico_formula, identificacion_paciente_formula, fecha)

    public Integer getCodigo_formula() {
        return codigo_formula;
    }

    public void setId_formula(Integer codigo_formula) {
        this.codigo_formula = codigo_formula;
    }

    public String getFecha_formula() {
        return fecha_formula;
    }

    public void setFecha_formula(String fecha_formula) {
        this.fecha_formula = fecha_formula;
    }

    public String getId_medico_formula() {
        return id_medico_formula;
    }

    public void setId_medico_formula(String id_medico_formula) {
        this.id_medico_formula = id_medico_formula;
    }

    public String getNombre_medico_formula() {
        return nombre_medico_formula;
    }

    public void setNombre_medico_formula(String nombre_medico_formula) {
        this.nombre_medico_formula = nombre_medico_formula;
    }

    public String getId_paciente__consulta() {
        return id_paciente__consulta;
    }

    public void setId_paciente__consulta(String id_paciente__consulta) {
        this.id_paciente__consulta = id_paciente__consulta;
    }

    public String getNombre_paciente__formula() {
        return nombre_paciente__formula;
    }

    public void setNombre_paciente__formula(String nombre_paciente__formula) {
        this.nombre_paciente__formula = nombre_paciente__formula;
    }

}
