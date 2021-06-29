package data;

import static data.Conexion.*;
import domain.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Formula_medicaDAO implements IDAO<Formula_medica> {

    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;

    private static Formula_medicaDAO instacia;

    public static Formula_medicaDAO getInstance() {
        if (instacia == null) {
            instacia = new Formula_medicaDAO();
        }
        return instacia;
    }

    public void insertar(Formula_medica entidad) throws SQLException {
//--Formula_medica(id_formula, identificacion_medico_formula, identificacion_paciente_formula, fecha)

        String query = "INSERT INTO Formula_medica(id_formula, identificacion_medico_formula, identificacion_paciente_formula, fecha) VALUES "
                + "(?,?,?,?);";

        if (insertar == null) {
            insertar = getConnection().prepareStatement(query);
        }

        insertar.setInt(1, entidad.getCodigo_formula());
        insertar.setString(2, entidad.getId_medico_formula());
        insertar.setString(3, entidad.getId_paciente__consulta());
        insertar.setString(4, entidad.getFecha_formula());

        insertar.executeUpdate();

    }

    public void eliminar(String id) throws SQLException {
        String query = "DELETE FROM Formula_medica WHERE id_formula = ? ;";
        if (eliminar == null) {
            eliminar = getConnection().prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Formula_medica cargar(ResultSet set) throws SQLException {

        Formula_medica Formula_medica = new Formula_medica();
        Formula_medica.setId_formula(set.getInt("id_formula"));
        Formula_medica.setFecha_formula(set.getString("fecha"));
        Formula_medica.setId_medico_formula(set.getString("identificacion_empleado"));
        Formula_medica.setNombre_medico_formula(set.getString("nombre_empleado"));
        Formula_medica.setId_paciente__consulta(set.getString("numero_ss"));
        Formula_medica.setNombre_paciente__formula(set.getString("nombre_paciente"));

        return Formula_medica;
    }

    public List<Formula_medica> listar() throws SQLException {
        String query = "SELECT id_formula, fecha, identificacion_empleado, nombre_empleado, numero_ss,nombre_paciente \n"
                + "FROM (  (medico INNER JOIN empleado ON medico.identificacion_medico = empleado.identificacion_empleado) AS t1 \n"
                + "        INNER JOIN \n"
                + "        (formula_medica INNER JOIN paciente ON formula_medica.identificacion_paciente_formula = paciente.numero_ss) AS t2\n"
                + "        ON t1.identificacion_medico = t2.identificacion_medico_formula \n"
                + "     ) AS tabla";

        if (listar == null) {
            listar = getConnection().prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Formula_medica> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

    public Formula_medica buscar(String id) throws SQLException {
        String query = "SELECT * \n"
                + "FROM Formula_medica\n"
                + "WHERE Formula_medica.id_formula= ?;";

        if (buscar == null) {
            buscar = getConnection().prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;
    }

    public void actualizar(Formula_medica entidad) throws SQLException {

        String query = "UPDATE Formula_medica SET  identificacion_medico_formula = ?,"
                + " identificacion_paciente_formula = ?, fecha =? WHERE id_formula= ?;";

        if (actualizar == null) {
            actualizar = getConnection().prepareStatement(query);
        }

        actualizar.setString(1, entidad.getId_medico_formula());
        actualizar.setString(2, entidad.getId_paciente__consulta());
        actualizar.setString(3, entidad.getFecha_formula());
        actualizar.setInt(4, entidad.getCodigo_formula());

        actualizar.executeUpdate();
    }
}
