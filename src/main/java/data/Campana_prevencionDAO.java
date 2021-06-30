package data;

import static data.Conexion.*;
import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Campana_prevencionDAO implements IDAO<Campana_prevencion> {

    //para las consultas SQL............
    private PreparedStatement insertar = null;
    private PreparedStatement eliminar = null;
    private PreparedStatement actualizar = null;
    private PreparedStatement buscar = null;
    private PreparedStatement listar = null;
    private Connection conn = null;
    private Connection conexionTransaccional;

    private static Campana_prevencionDAO instacia;

    private Campana_prevencionDAO() {
    }//constructor

    public static Campana_prevencionDAO getInstance() {
        if (instacia == null) {
            instacia = new Campana_prevencionDAO();
        }
        return instacia;
    }//crea una instancia del objeto.

    public void insertar(Campana_prevencion entidad) throws SQLException {

        String query = "INSERT INTO Campana_prevencion (codigo_de_campana, nombre_campana, objetivo_campana, "
                + "fecha_realizacion, identificacion_medico_campana) VALUES(?,?,?,?,?);";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (insertar == null) {
            insertar = conn.prepareStatement(query);
        }

        insertar.setInt(1, entidad.getCodigo_campana());
        insertar.setString(2, entidad.getNombre_campana());
        insertar.setString(3, entidad.getObjetivo_campana());
        insertar.setString(4, entidad.getFecha_campana());
        insertar.setString(5, entidad.getId_medico_campana());
        insertar.executeUpdate();

    }

    public void eliminar(String id) throws SQLException {
        String query = "DELETE FROM Campana_prevencion WHERE codigo_de_campana = ?;";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (eliminar == null) {
            eliminar = conn.prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Campana_prevencion cargar(ResultSet set) throws SQLException {

        Campana_prevencion cama = new Campana_prevencion();
        cama.setCodigo_de_campana(set.getInt("codigo_de_campana"));
        cama.setNombre_campana(set.getString("nombre_campana"));
        cama.setObjetivo_campana(set.getString("objetivo_campana"));
        cama.setFecha_campana(set.getString("fecha_realizacion"));
        cama.setId_medico_campana(set.getString("identificacion_medico_campana"));
        cama.setNombre_medico_campana(set.getString("nombre_empleado"));

        return cama;
    }

    public List<Campana_prevencion> listar() throws SQLException {
        String query = "SELECT DISTINCT codigo_de_campana, nombre_campana, objetivo_campana, fecha_realizacion, identificacion_medico_campana, nombre_empleado\n"
                + "FROM campana_prevencion INNER JOIN (medico INNER JOIN empleado ON medico.identificacion_medico = empleado.identificacion_empleado) AS c \n"
                + "ON campana_prevencion.identificacion_medico_campana = c.identificacion_medico";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (listar == null) {
            listar = conn.prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Campana_prevencion> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;

    }

    public Campana_prevencion buscar(String id) throws SQLException {
        String query = "SELECT * \n"
                + "FROM Campana_prevencion\n"
                + "WHERE codigo_de_campana = ?;";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (buscar == null) {
            buscar = conn.prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;

    }

    public void actualizar(Campana_prevencion entidad) throws SQLException {
        String query = "UPDATE Campana_prevencion SET  nombre_campana = ?, objetivo_campana = ?, "
                + "fecha_realizacion = ?, identificacion_medico_campana = ?"
                + " WHERE codigo_de_campana = ? ;";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (actualizar == null) {
            actualizar = conn.prepareStatement(query);
        }

        actualizar.setString(1, entidad.getNombre_campana());
        actualizar.setString(2, entidad.getObjetivo_campana());
        actualizar.setString(3, entidad.getFecha_campana());
        actualizar.setString(4, entidad.getId_medico_campana());
        actualizar.setInt(5, entidad.getCodigo_campana());

        actualizar.executeUpdate();
    }

}
