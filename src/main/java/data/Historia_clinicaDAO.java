package data;

import static data.Conexion.*;
import domain.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Historia_clinicaDAO implements IDAO<Historia_clinica> {

    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;

    private static Historia_clinicaDAO instacia;

    public static Historia_clinicaDAO getInstance() {
        if (instacia == null) {
            instacia = new Historia_clinicaDAO();
        }
        return instacia;
    }

    public void insertar(Historia_clinica entidad) throws SQLException {

        String query = "INSERT INTO Historia_clinica(numero_historia, fecha_apertura, identificacion_paciente) VALUES "
                + "(?,?,?);";

        if (insertar == null) {
            insertar = getConnection().prepareStatement(query);
        }

        insertar.setString(1, entidad.getNumero_historia());
        insertar.setString(2, entidad.getFecha_apertura());
        insertar.setString(3, entidad.getIdentificacion_paciente());
        insertar.executeUpdate();

    }

    public void eliminar(String id) throws SQLException {
        String query = "DELETE FROM Historia_clinica WHERE historia_serial = ? ;";
        if (eliminar == null) {
            eliminar = getConnection().prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Historia_clinica cargar(ResultSet set) throws SQLException {

        Historia_clinica Historia_clinica = new Historia_clinica();
        Historia_clinica.setHistoria_serial(set.getInt("historia_serial"));
        Historia_clinica.setNumero_historiaAg(set.getString("numero_historia"));
        Historia_clinica.setNumero_historia(set.getString("numero_historia"));
        Historia_clinica.setFecha_apertura(set.getString("fecha_apertura"));
        Historia_clinica.setIdentificacion_paciente(set.getString("identificacion_paciente"));
        Historia_clinica.setNombre_paciente(set.getString("nombre_paciente"));

        return Historia_clinica;
    }

    public List<Historia_clinica> listar() throws SQLException {
        String query = "SELECT DISTINCT historia_clinica_serial,numero_historia,numero_ss, fecha_apertura, identificacion_paciente,  nombre_paciente\n"
                + "FROM (  (Historia_clinica INNER JOIN paciente ON Historia_clinica.identificacion_paciente = paciente.numero_ss) AS t1 \n"
                + "        INNER JOIN \n"
                + "        (Historia_clinica_especifica INNER JOIN (medico INNER JOIN empleado ON medico.identificacion_medico = empleado.identificacion_empleado) ON Historia_clinica_especifica.identificacion_medico_hce = medico.identificacion_medico) AS t2\n"
                + "        ON t1.historia_clinica_serial = t2.historia_serial_hce \n"
                + "     ) AS tabla";

        if (listar == null) {
            listar = getConnection().prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Historia_clinica> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

    public Historia_clinica buscar(String id) throws SQLException {
        String query = "SELECT * \n"
                + "FROM Historia_clinica\n"
                + "WHERE Historia_clinica.historia_serial= ? ;";

        if (buscar == null) {
            buscar = getConnection().prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;
    }

    public void actualizar(Historia_clinica entidad) throws SQLException {

        String query = "UPDATE Historia_clinica SET  numero_historia = ?, fecha_apertura = ?,"
                + " identificacion_paciente = ? WHERE historia_serial= ? ;";

        if (actualizar == null) {
            actualizar = getConnection().prepareStatement(query);
        }

        actualizar.setString(1, entidad.getNumero_historia());
        actualizar.setString(2, entidad.getFecha_apertura());
        actualizar.setString(3, entidad.getIdentificacion_paciente());
        actualizar.setInt(4, entidad.getCodigo_historia());

        actualizar.executeUpdate();
    }
}
