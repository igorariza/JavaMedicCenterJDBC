package domain;

public class Persona {
   private String idEmpleado;
   private String nombre;				
   private String cargo;				
   private String salario;				
   private String direccion;
   private String e_mail;				
   private String telefono;			
   private String area;				
   private String idJefe;		
   private String estado;	

    public Persona() {
    }

    public Persona(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Persona(String idEmpleado, String nombre, String cargo, String salario, String direccion, String e_mail, String telefono, String area, String idJefe, String estado) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.direccion = direccion;
        this.e_mail = e_mail;
        this.telefono = telefono;
        this.area = area;
        this.idJefe = idJefe;
        this.estado = estado;
    }

    public Persona(String nombre, String cargo, String salario, String direccion, String e_mail, String telefono, String area, String idJefe, String estado) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.direccion = direccion;
        this.e_mail = e_mail;
        this.telefono = telefono;
        this.area = area;
        this.idJefe = idJefe;
        this.estado = estado;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(String idJefe) {
        this.idJefe = idJefe;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Persona{" + "idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", cargo=" + cargo + ", salario=" + salario + ", direccion=" + direccion + ", e_mail=" + e_mail + ", telefono=" + telefono + ", area=" + area + ", idJefe=" + idJefe + ", estado=" + estado + '}';
    }
   
   
}
