package data;

import static data.Conexion.*;
import domain.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO implements IDAO<Paciente> {

    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;

    private static PacienteDAO instacia;

    public static PacienteDAO getInstance() {
        if (instacia == null) {
            instacia = new PacienteDAO();
        }
        return instacia;
    }

    @Override
    public void insertar(Paciente entidad) throws SQLException {

        String query = "INSERT INTO Paciente(numero_ss, nombre_paciente, direccion_paciente, telefono_paciente, "
                + "fecha_nacimiento, actividad_economica, estado_paciente) VALUES (?, ?, ?, ?, ?, ?, '1')";

        if (insertar == null) {
            insertar = getConnection().prepareStatement(query);
        }

        insertar.setString(1, entidad.getNumero_ss());
        insertar.setString(2, entidad.getNombre_paciente());
        insertar.setString(3, entidad.getDireccion_paciente());
        insertar.setString(4, entidad.getTelefono_paciente());
        insertar.setString(5, entidad.getFecha_nacimiento());
        insertar.setString(6, entidad.getActividad_economica());
        insertar.executeUpdate();

    }

    @Override
    public void eliminar(String id) throws SQLException {
        String query = "UPDATE PAciente SET estado_paciente = '0' WHERE numero_ss = ?";
        if (eliminar == null) {
            eliminar = getConnection().prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Paciente cargar(ResultSet set) throws SQLException {

        Paciente Paciente = new Paciente();
        Paciente.setNumero_ss(set.getString("numero_ss"));
        Paciente.setNombre_paciente(set.getString("nombre_paciente"));
        Paciente.setDireccion_paciente(set.getString("direccion_paciente"));
        Paciente.setTelefono_paciente(set.getString("telefono_paciente"));
        Paciente.setFecha_nacimiento(set.getString("fecha_nacimiento"));
        Paciente.setActividad_economica(set.getString("actividad_economica"));

        return Paciente;
    }

    @Override
    public List<Paciente> listar() throws SQLException {
        String query = "SELECT * FROM Paciente WHERE estado_paciente = '1' \n";

        if (listar == null) {
            listar = getConnection().prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Paciente> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

    @Override
    public Paciente buscar(String id) throws SQLException {
        String query = "SELECT * \n"
                + "FROM Paciente \n"
                + "WHERE Paciente.numero_ss= ?";

        if (buscar == null) {
            buscar = getConnection().prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;
    }

    @Override
    public void actualizar(Paciente entidad) throws SQLException {

        String query = "UPDATE Paciente SET  nombre_paciente = ?, direccion_paciente = ? "
                + ", telefono_paciente = ? , fecha_nacimiento = ?"
                + ", actividad_economica = ? "
                + " WHERE numero_ss = ?";

        if (actualizar == null) {
            actualizar = getConnection().prepareStatement(query);
        }

        actualizar.setString(1, entidad.getNombre_paciente());
        actualizar.setString(2, entidad.getDireccion_paciente());
        actualizar.setString(3, entidad.getTelefono_paciente());
        actualizar.setString(4, entidad.getFecha_nacimiento());
        actualizar.setString(5, entidad.getActividad_economica());

        actualizar.setString(6, entidad.getNumero_ss());

        actualizar.executeUpdate();
    }
}
