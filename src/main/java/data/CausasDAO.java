package data;

import static data.Conexion.*;
import domain.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CausasDAO implements IDAO<Causas> {

    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;

    private static CausasDAO instacia;

    public static CausasDAO getInstance() {
        if (instacia == null) {
            instacia = new CausasDAO();
        }
        return instacia;
    }

    public void insertar(Causas entidad) throws SQLException {

        String query = "INSERT INTO Causas(codigo, nombre, descripcion) VALUES "
                + "(?,?,?);";

        if (insertar == null) {
            insertar = getConnection().prepareStatement(query);
        }

        insertar.setString(1, entidad.getCodigo());
        insertar.setString(2, entidad.getNombre());
        insertar.setString(3, entidad.getDescripcion());
        insertar.executeUpdate();

    }

    public void eliminar(String id) throws SQLException {
        String query = "DELETE FROM Causas WHERE codigo = ? ;";
        if (eliminar == null) {
            eliminar = getConnection().prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Causas cargar(ResultSet set) throws SQLException {

        Causas Causas = new Causas();
        Causas.setCodigo(set.getString("codigo"));
        Causas.setNombre(set.getString("nombre"));
        Causas.setDescripcion(set.getString("descripcion"));

        return Causas;
    }

    public List<Causas> listar() throws SQLException {
        String query = "SELECT *\n"
                + "FROM Causas\n";

        if (listar == null) {
            listar = getConnection().prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Causas> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

    public Causas buscar(String id) throws SQLException {
        String query = "SELECT * \n"
                + "FROM Causas\n"
                + "WHERE Causas.codigo= ? ;";

        if (buscar == null) {
            buscar = getConnection().prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;
    }

    public void actualizar(Causas entidad) throws SQLException {

        String query = "UPDATE Causas SET  nombre = ?, descripcion = ? WHERE codigo = ?;";

        if (actualizar == null) {
            actualizar = getConnection().prepareStatement(query);
        }

        actualizar.setString(1, entidad.getNombre());
        actualizar.setString(2, entidad.getDescripcion());
        actualizar.setString(3, entidad.getCodigo());

        actualizar.executeUpdate();
    }
}
