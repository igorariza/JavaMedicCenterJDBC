package data;

import static data.Conexion.*;
import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO implements IDAO<Medico> {

     //para las consultas SQL............
    private PreparedStatement insertar = null;
    private PreparedStatement eliminar = null;
    private PreparedStatement actualizar = null;
    private PreparedStatement buscar = null;
    private PreparedStatement listar = null;
    private Connection conn = null;
    private Connection conexionTransaccional;

    private static MedicoDAO instacia;

    private MedicoDAO() {
    }//constructor

    public static MedicoDAO getInstance() {
        if (instacia == null) {
            instacia = new MedicoDAO();
        }
        return instacia;
    }//crea una instancia del objeto.

    @Override
    public void insertar(Medico entidad) throws SQLException {

        String query = "INSERT INTO Medico (identificacion_medico, especialidad, numero_licencia, universidad) VALUES(?,?,?,?);";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (insertar == null) {
            insertar = conn.prepareStatement(query);
        }

        insertar.setString(1, entidad.getIdentificacion_medico());
        insertar.setString(2, entidad.getEspecialidad());
        insertar.setString(3, entidad.getNumero_licencia());
        insertar.setString(4, entidad.getUniversidad());
        insertar.executeUpdate();

    }

    @Override
    public void eliminar(String id) throws SQLException {
        String query = "DELETE FROM Medico WHERE identificacion_medico = ?;";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (eliminar == null) {
            eliminar = conn.prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Medico cargar(ResultSet set) throws SQLException {

        Medico cama = new Medico();
        cama.setIdentificacion_medico(set.getString("identificacion_medico"));
        cama.setNumero_licencia(set.getString("numero_licencia"));
        cama.setNombre_empleado(set.getString("nombre_empleado"));
        cama.setEspecialidad(set.getString("especialidad"));
        cama.setUniversidad(set.getString("universidad"));
        cama.setE_mail(set.getString("e_mail"));
        return cama;
    }

    @Override
    public List<Medico> listar() throws SQLException {
        String query = "SELECT identificacion_empleado, numero_licencia ,nombre_empleado, "
                + "especialidad, universidad, e_mail \n"
                + "FROM (empleado INNER JOIN medico ON "
                + "empleado.identificacion_empleado = medico.identificacion_medico) "
                + "WHERE Empleado.estado_empleado='1' ";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (listar == null) {
            listar = conn.prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Medico> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;

    }

    @Override
    public Medico buscar(String id) throws SQLException {
        String query = "SELECT * \n"
                + "FROM Medico\n"
                + "WHERE identificacion_medico = ?;";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (buscar == null) {
            buscar = conn.prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;

    }

    @Override
    public void actualizar(Medico entidad) throws SQLException {
        String query = "UPDATE Medico SET  especialidad = ?, numero_licencia = ?, universidad = ? WHERE identificacion_medico = ? ;";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (actualizar == null) {
            actualizar = conn.prepareStatement(query);
        }

        actualizar.setString(1, entidad.getEspecialidad());
        actualizar.setString(2, entidad.getNumero_licencia());
        actualizar.setString(3, entidad.getUniversidad());
        actualizar.setString(4, entidad.getIdentificacion_medico());
        actualizar.executeUpdate();
    }

}
