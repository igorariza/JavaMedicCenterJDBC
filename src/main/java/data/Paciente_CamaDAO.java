package data;

import static data.Conexion.*;
import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Paciente_CamaDAO implements IDAO<Paciente_Cama> {
     //para las consultas SQL............
    private PreparedStatement insertar = null;
    private PreparedStatement eliminar = null;
    private PreparedStatement actualizar = null;
    private PreparedStatement buscar = null;
    private PreparedStatement listar = null;
    private Connection conn = null;
    private Connection conexionTransaccional;
    
    
    private static Paciente_CamaDAO instacia;
    public static Paciente_CamaDAO getInstance() {
        if (instacia == null) {
            instacia = new Paciente_CamaDAO();
        }
        return instacia;
    }
    
    
    
    @Override
    public void insertar(Paciente_Cama entidad) throws SQLException {

        String query = "INSERT INTO Paciente_Cama(identificacion_paciente, numero_de_cama, fecha_inicial, fecha_final) VALUES "
                + "(?,?,?,?);";
                

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (insertar == null) {
            insertar = conn.prepareStatement(query);
        }
        
        insertar.setString(1, entidad.getIdentificacion_paciente());
        insertar.setString(2, entidad.getNumero_de_cama());
        insertar.setString(3, entidad.getFecha_inicial());
        insertar.setString(4, entidad.getFecha_final());
        insertar.executeUpdate();

    }
    
    
    @Override
    public void eliminar(String id) throws SQLException {
        String query = "DELETE FROM Paciente_Cama WHERE identificacion_paciente= ? ;";
//-------------------  error llave compuesta
       
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (eliminar == null) {
            eliminar = conn.prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Paciente_Cama cargar(ResultSet set) throws SQLException {

        Paciente_Cama Paciente_Cama = new Paciente_Cama();
        Paciente_Cama.setIdentificacion_paciente(set.getString("identificacion_paciente"));
        Paciente_Cama.setNumero_de_cama(set.getString("numero_de_cama"));
        Paciente_Cama.setFecha_inicial(set.getString("fecha_inicial"));
        Paciente_Cama.setFecha_final(set.getString("fecha_final"));
        
        return Paciente_Cama;
    }

    @Override
    public List<Paciente_Cama> listar() throws SQLException {
        String query = "SELECT *\n"
                + "FROM Paciente_Cama\n";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (listar == null) {
            listar = conn.prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Paciente_Cama> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

    @Override
    public Paciente_Cama buscar(String id) throws SQLException {
        String query = "SELECT * \n" +
                        "FROM Paciente_Cama\n" +
                        "WHERE Paciente_Cama.identificacion_paciente = ? ;";
//-------------------------error llave compuesta
        
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (buscar == null) {
            buscar = conn.prepareStatement(query);
        }
        
        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();
        
        return set != null && set.next() ? cargar(set) : null;  }

    @Override
    public void actualizar(Paciente_Cama entidad) throws SQLException {
        
           String query = "UPDATE Paciente_Cama SET  fecha_inicial = ?, fecha_final = ?"
                   + " WHERE identificacion_paciente = ? AND numero_de_cama = ?);";
        
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (actualizar == null) {
            actualizar = conn.prepareStatement(query);
        }
        
        
        
        actualizar.setString(1, entidad.getFecha_inicial());
        actualizar.setString(2, entidad.getFecha_final());
        
        actualizar.setString(3, entidad.getIdentificacion_paciente());
        actualizar.setString(4, entidad.getNumero_de_cama());
        
        actualizar.executeUpdate();
    }
}
