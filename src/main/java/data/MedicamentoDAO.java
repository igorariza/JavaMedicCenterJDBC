package data;

import static data.Conexion.*;
import domain.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDAO implements IDAO<Medicamento> {

    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;

    private static MedicamentoDAO instacia;

    public static MedicamentoDAO getInstance() {
        if (instacia == null) {
            instacia = new MedicamentoDAO();
        }
        return instacia;
    }

    @Override
    public void insertar(Medicamento entidad) throws SQLException {

        String query = "INSERT INTO Medicamento(codigo_medicamento, nombre_medicamento, descripcion_medicamento, costo) VALUES "
                + "(?,?,?,?);";

        if (insertar == null) {
            insertar = getConnection().prepareStatement(query);
        }

        insertar.setString(1, entidad.getCodigo_medicamento());
        insertar.setString(2, entidad.getNombre_medicamento());
        insertar.setString(3, entidad.getDescripcion_medicamento());
        insertar.setDouble(4, entidad.getCosto());
        insertar.executeUpdate();

    }

    @Override
    public void eliminar(String id) throws SQLException {
        String query = "DELETE FROM Medicamento WHERE codigo_medicamento = ? ;";
        if (eliminar == null) {
            eliminar = getConnection().prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Medicamento cargar(ResultSet set) throws SQLException {

        Medicamento Medicamento = new Medicamento();
        Medicamento.setCodigo_medicamento(set.getString("codigo_medicamento"));
        Medicamento.setNombre_medicamento(set.getString("nombre_medicamento"));
        Medicamento.setDescripcion_medicamento(set.getString("descripcion_medicamento"));
        Medicamento.setCosto(set.getDouble("costo"));

        return Medicamento;
    }

    @Override
    public List<Medicamento> listar() throws SQLException {
        String query = "SELECT *\n"
                + "FROM Medicamento\n";

        if (listar == null) {
            listar = getConnection().prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Medicamento> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

    @Override
    public Medicamento buscar(String id) throws SQLException {
        String query = "SELECT * \n"
                + "FROM Medicamento\n"
                + "WHERE Medicamento.codigo_medicamento= ?;";

        if (buscar == null) {
            buscar = getConnection().prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;
    }

    @Override
    public void actualizar(Medicamento entidad) throws SQLException {

        String query = "UPDATE Medicamento SET  nombre_medicamento = ?, descripcion_medicamento = ?, costo = ? WHERE codigo_medicamento = ?;";

        if (actualizar == null) {
            actualizar = getConnection().prepareStatement(query);
        }

        actualizar.setString(1, entidad.getNombre_medicamento());
        actualizar.setString(2, entidad.getDescripcion_medicamento());
        actualizar.setDouble(3, entidad.getCosto());

        actualizar.setString(4, entidad.getCodigo_medicamento());

        actualizar.executeUpdate();
    }
}
