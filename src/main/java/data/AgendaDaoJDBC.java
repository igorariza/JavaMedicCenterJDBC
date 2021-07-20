package data;

import static data.Conexion.*;
import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendaDaoJDBC implements IDAOBUSCAR1<AgendaDTO> {

    //para las consultas SQL............
    private PreparedStatement insertar = null;
    private PreparedStatement eliminar = null;
    private PreparedStatement actualizar = null;
    private PreparedStatement buscar = null;
    private PreparedStatement listar = null;
    private Connection conn = null;
    private static AgendaDaoJDBC instacia;
    private Connection conexionTransaccional;
    
    public AgendaDaoJDBC(){
    }
    
    public AgendaDaoJDBC(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;        
    }

    public static AgendaDaoJDBC getInstance() {
        if (instacia == null) {
            instacia = new AgendaDaoJDBC();
        }
        return instacia;
    }

    public AgendaDTO cargar(ResultSet set) throws SQLException {
        AgendaDTO Agenda = new AgendaDTO();
        Agenda.setHora(set.getString("fecha_cita"));
        Agenda.setIdentificacion_paciente_cita(set.getString("identificacion_paciente_cita"));
        Agenda.setEstado_cita(set.getString("estado_cita"));
        return Agenda;
    }
    
    public List<AgendaDTO> select() throws SQLException {
        String query = "SELECT * FROM Cita_medica ";
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (listar == null) {
            listar = conn.prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<AgendaDTO> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;

    }

    public List<AgendaDTO> buscar(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement smtm = null;
        ResultSet rs = null;
        AgendaDTO agenda = null;
        List<AgendaDTO> result = new ArrayList<>();
        String query = "SELECT  \n"
                + "FROM Cita_medica INNER JOIN Paciente ON Cita_medica.identificacion_paciente_cita = Paciente.numero_ss\n"
                + "WHERE Cita_medica.identificacion_medico_cita = ? ;";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        smtm = conn.prepareStatement(query);
        smtm.setString(1, id);
        rs = smtm.executeQuery();
        while (rs.next()) {
            result.add(cargar(rs));
        }
        return result;
    }

    public List<AgendaDTO> listar() throws SQLException {
        String query = "SELECT * FROM Cita_medica ";
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (listar == null) {
            listar = conn.prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<AgendaDTO> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }
}
