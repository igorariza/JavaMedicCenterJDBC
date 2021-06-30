package data;

import static data.Conexion.*;
import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CausasDAO implements IDAO<Causas> {

    //para las consultas SQL............
    private PreparedStatement insertar = null;
    private PreparedStatement eliminar = null;
    private PreparedStatement actualizar = null;
    private PreparedStatement buscar = null;
    private PreparedStatement listar = null;
    private Connection conn = null;
    private Connection conexionTransaccional;

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

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (insertar == null) {
            insertar = conn.prepareStatement(query);
        }

        insertar.setString(1, entidad.getCodigo());
        insertar.setString(2, entidad.getNombre());
        insertar.setString(3, entidad.getDescripcion());
        insertar.executeUpdate();

    }

    public void eliminar(String id) throws SQLException {
        String query = "DELETE FROM Causas WHERE codigo = ? ;";
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (eliminar == null) {
            eliminar = conn.prepareStatement(query);
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

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (listar == null) {
            listar = conn.prepareStatement(query);
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

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (buscar == null) {
            buscar = conn.prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;
    }

    public void actualizar(Causas entidad) throws SQLException {

        String query = "UPDATE Causas SET  nombre = ?, descripcion = ? WHERE codigo = ?;";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (actualizar == null) {
            actualizar = conn.prepareStatement(query);
        }

        actualizar.setString(1, entidad.getNombre());
        actualizar.setString(2, entidad.getDescripcion());
        actualizar.setString(3, entidad.getCodigo());

        actualizar.executeUpdate();
    }
}
