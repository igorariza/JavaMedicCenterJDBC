package data;

import static data.Conexion.*;
import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Enfermera_HabilidadDAO implements IDAO<Enfermera_Habilidad> {
     //para las consultas SQL............
    private PreparedStatement insertar = null;
    private PreparedStatement eliminar = null;
    private PreparedStatement actualizar = null;
    private PreparedStatement buscar = null;
    private PreparedStatement listar = null;
    private Connection conn = null;
    private Connection conexionTransaccional;
    
    private static Enfermera_HabilidadDAO instacia;
    public static Enfermera_HabilidadDAO getInstance() {
        if (instacia == null) {
            instacia = new Enfermera_HabilidadDAO();
        }
        return instacia;
    }
    
    
    
    public void insertar(Enfermera_Habilidad entidad) throws SQLException {

        String query = "INSERT INTO Enfermera_Habilidad(identificacion_enfermera_habilidad, habilidad) VALUES "
                + "(?,?);";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (insertar == null) {
            insertar = conn.prepareStatement(query);
        }
        insertar.setString(1, entidad.getIdentificacion_enfermera_habilidad());
        insertar.setString(2, entidad.getHabilidad());
        insertar.executeUpdate();

    }
    
    
    
    public void eliminar(String id) throws SQLException {
        String query = "DELETE FROM Enfermera_Habilidad WHERE identificacion_enfermera_habilidad = '" + id + "';";
//--------------------------------------------ESPECIFICAR QUE HABILIDAD SE VA A BORRAR, NO SE SI SE PUEDE AGREGAR UN CAMPO NECESARIO A ELIMINAR
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (eliminar == null) {
            eliminar = conn.prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Enfermera_Habilidad cargar(ResultSet set) throws SQLException {

        Enfermera_Habilidad Enfermera_Habilidad = new Enfermera_Habilidad();
        Enfermera_Habilidad.setIdentificacion_enfermera_habilidad(set.getString("identificacion_enfermera_habilidad"));
        Enfermera_Habilidad.setHabilidad(set.getString("habilidad"));
        

        return Enfermera_Habilidad;
    }

    
    public List<Enfermera_Habilidad> listar() throws SQLException {
        String query = "SELECT *\n"
                + "FROM Enfermera_Habilidad INNER JOIN Empleados ON Empleados.identificacion:empleados = Enfermera_Habilidad.identificacion_enfermera_habilidad \n";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (listar == null) {
            listar = conn.prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Enfermera_Habilidad> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

    
    public Enfermera_Habilidad buscar(String id) throws SQLException {
        String query = "SELECT * \n" +
                        "FROM Enfermera_Habilidad INNER JOIN Empleados ON Empleados.identificacion_empleado = Enfermera_Habilidad.identificacion_enfermera_habilidad \n" +
                        "WHERE Enfermera_Habilidad.identificacion_enfermera_habilidad = ?;";
               
        
       conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (buscar == null) {
            buscar = conn.prepareStatement(query);
        }
        
        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();
        
        return set != null && set.next() ? cargar(set) : null;  }

    
    public void actualizar(Enfermera_Habilidad entidad) throws SQLException {
    //-------No se debe actualizar
           String query = "UPDATE Enfermera_Habilidad SET  habilidad = ?"
                   + "WHERE identificacion_enfermera_habilidad = ? ;";
        
       conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (actualizar == null) {
            actualizar = conn.prepareStatement(query);
        }
        
        actualizar.setString(1, entidad.getIdentificacion_enfermera_habilidad());
        actualizar.setString(2, entidad.getHabilidad());
        actualizar.executeUpdate();
    }
}
