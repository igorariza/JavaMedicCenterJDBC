package data;

import static data.Conexion.*;
import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO implements IDAOBUSCAR1<Agenda> {

    private static AgendaDAO instacia;
    private Connection conexionTransaccional;

    public static AgendaDAO getInstance() {
        if (instacia == null) {
            instacia = new AgendaDAO();
        }
        return instacia;
    }

    private PreparedStatement buscar;

    public Agenda cargar(ResultSet set) throws SQLException {
        Agenda Agenda = new Agenda();
        Agenda.setFecha_cita(set.getString("fecha_cita"));
        Agenda.setNombre_paciente(set.getString("nombre_paciente"));
        Agenda.setEstado_cita(set.getString("estado_cita"));
        return Agenda;
    }

    public List<Agenda> buscar(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement smtm = null;
        ResultSet rs = null;
        Agenda agenda = null;
        List<Agenda> result = new ArrayList<>();
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
}
