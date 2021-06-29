package data;

import static data.Conexion.*;
import domain.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CamaDAO implements IDAO<Cama> {

    //para las consultas SQL............
    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;

    private static CamaDAO instacia;

    private CamaDAO() {
    }//constructor

    public static CamaDAO getInstance() {
        if (instacia == null) {
            instacia = new CamaDAO();
        }
        return instacia;
    }//crea una instancia del objeto.

    public void insertar(Cama entidad) throws SQLException {

        String query = "INSERT INTO Cama (numero_de_cama, descripcion_cama, area_cama, estado_cama) VALUES(?,?,?,?);";

        if (insertar == null) {
            insertar = getConnection().prepareStatement(query);
        }

        insertar.setString(1, entidad.getNumero_de_cama());
        insertar.setString(2, entidad.getDescripcion_cama());
        insertar.setString(3, entidad.getArea_cama());
        insertar.setString(4, entidad.getEstado_cama());
        insertar.executeUpdate();

    }

    public void eliminar(String id) throws SQLException {
        String query = "DELETE  FROM Cama WHERE numero_de_cama = ?;";

        if (eliminar == null) {
            eliminar = getConnection().prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Cama cargar(ResultSet set) throws SQLException {

        Cama cama = new Cama();
        cama.setNumero_de_cama(set.getString("numero_de_cama"));
        cama.setDescripcion_cama(set.getString("descripcion_cama"));
        cama.setArea_cama(set.getString("area_cama"));
        cama.setEstado_cama(set.getString("estado_cama"));
        return cama;
    }

    public List<Cama> listar() throws SQLException {
        String query = "SELECT *\n"
                + "FROM Cama \n";

        if (listar == null) {
            listar = getConnection().prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Cama> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;

    }

    public Cama buscar(String id) throws SQLException {
        String query = "SELECT * \n"
                + "FROM Cama\n"
                + "WHERE numero_de_cama = ?;";

        if (buscar == null) {
            buscar = getConnection().prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;

    }

    public void actualizar(Cama entidad) throws SQLException {
        String query = "UPDATE Cama SET  descripcion_cama = ?, area_cama = ?, estado_cama = ? WHERE numero_de_cama = ? ;";

        if (actualizar == null) {
            actualizar = getConnection().prepareStatement(query);
        }

        actualizar.setString(1, entidad.getDescripcion_cama());
        actualizar.setString(2, entidad.getArea_cama());
        actualizar.setString(3, entidad.getEstado_cama());
        actualizar.setString(4, entidad.getNumero_de_cama());

        actualizar.executeUpdate();
    }

}
