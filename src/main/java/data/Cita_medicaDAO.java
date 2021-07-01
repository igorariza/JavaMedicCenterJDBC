package data;

import static data.Conexion.*;
import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cita_medicaDAO implements IDAO<Cita_medica> {

    //para las consultas SQL............
    private PreparedStatement insertar = null;
    private PreparedStatement eliminar = null;
    private PreparedStatement actualizar = null;
    private PreparedStatement buscar = null;
    private PreparedStatement listar = null;
    private Connection conn = null;
    private Connection conexionTransaccional;

    private static Cita_medicaDAO instacia;

    public static Cita_medicaDAO getInstance() {
        if (instacia == null) {
            instacia = new Cita_medicaDAO();
        }
        return instacia;
    }

    public void insertar(Cita_medica entidad) throws SQLException {

        String query = "INSERT INTO Cita_medica(fecha_cita, hora, identificacion_medico_cita, estado_cita) VALUES "
                + "(?,?,?,'Programada');";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (insertar == null) {
            insertar = conn.prepareStatement(query);
        }

        insertar.setString(1, entidad.getFecha_cita());
        insertar.setString(2, entidad.getHora());
        insertar.setString(3, entidad.getIdentificacion_medico_cita());
        insertar.executeUpdate();

    }

    public void eliminar(String id) throws SQLException {
        String query = "DELETE FROM Cita_medica WHERE id_cita = ? ;";
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (eliminar == null) {
            eliminar = conn.prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Cita_medica cargar(ResultSet set) throws SQLException {

        Cita_medica Cita_medica = new Cita_medica();
        Cita_medica.setId_cita(set.getInt("id_cita"));
        Cita_medica.setFecha_cita(set.getString("fecha_cita"));
        Cita_medica.setHora(set.getString("hora"));
        Cita_medica.setIdentificacion_medico_cita(set.getString("identificacion_medico_cita"));
        Cita_medica.setNombre_medico(set.getString("nombre_empleado"));
        Cita_medica.setIdentificacion_paciente_cita(set.getString("identificacion_paciente_cita"));
        Cita_medica.setNombre_paciente(set.getString("nombre_paciente"));
        Cita_medica.setEstado_cita(set.getString("estado_cita"));
        Cita_medica.setFormula_medica_cita(set.getInt("formula_medica_cita"));

        return Cita_medica;
    }

    public List<Cita_medica> listar() throws SQLException {
        String query = "SELECT DISTINCT id_cita,fecha_cita,hora,identificacion_medico_cita,nombre_empleado, identificacion_paciente_cita,nombre_paciente ,estado_cita,formula_medica_cita\n"
                + "FROM (cita_medica INNER JOIN   (medico INNER JOIN empleado ON medico.identificacion_medico = empleado.identificacion_empleado) AS c  ON cita_medica.identificacion_medico_cita = c.identificacion_empleado ) as c1\n"
                + "INNER JOIN paciente ON c1.identificacion_paciente_cita = paciente.numero_ss";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (listar == null) {
            listar = conn.prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Cita_medica> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

    public Cita_medica buscar(String id) throws SQLException {
        String query = "SELECT * \n"
                + "FROM Cita_medica\n"
                + "WHERE Cita_medica.id_cita= ? ;";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (buscar == null) {
            buscar = conn.prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;
    }

    public void actualizar(Cita_medica entidad) throws SQLException {

        String query = "UPDATE Cita_medica SET  fecha_cita = ? , hora = ? , identificacion_medico_cita = ? , "
                + "identificacion_paciente_cita = ? , estado_cita = ? , formula_medica_cita = ? WHERE id_cita = ? ;";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (actualizar == null) {
            actualizar = conn.prepareStatement(query);
        }

        actualizar.setString(1, entidad.getFecha_cita());
        actualizar.setString(2, entidad.getHora());
        actualizar.setString(3, entidad.getIdentificacion_medico_cita());
        actualizar.setString(4, entidad.getIdentificacion_paciente_cita());
        actualizar.setString(5, entidad.getEstado_cita());
        actualizar.setInt(6, entidad.getFormula_medica_cita());

        actualizar.setInt(7, entidad.getId_cita());

        actualizar.executeUpdate();
    }
}
