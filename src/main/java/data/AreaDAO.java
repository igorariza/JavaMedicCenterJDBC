package data;

import static data.Conexion.*;
import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaDAO implements IDAO<Area> {//clase que retorna o bien un vector o una matriz de 
    //del objeto area.

    //para las consultas SQL............
    private PreparedStatement insertar = null;
    private PreparedStatement eliminar = null;
    private PreparedStatement actualizar = null;
    private PreparedStatement buscar = null;
    private PreparedStatement listar = null;
    private Connection conn = null;
    private Connection conexionTransaccional;
    private static AreaDAO instacia;
    

    private AreaDAO() {
    }//constructor

    public static AreaDAO getInstance() {
        if (instacia == null) {
            instacia = new AreaDAO();
        }
        return instacia;
    }//crea una instancia del objeto.

    public void insertar(Area entidad) throws SQLException {

        String query = "UPDATE Area SET  nombre_area = ?, descripcion_area = ?, estado = ?  WHERE codigo_area = ? ;";
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (insertar == null) {
            insertar = conn.prepareStatement(query);
        }

        insertar.setString(1, entidad.getNombre_area());
        insertar.setString(2, entidad.getDescripcion_area());
        insertar.setString(3, entidad.getEstado());
        insertar.setString(4, entidad.getCodigo_area());
        insertar.executeUpdate();

    }

    public void eliminar(String id) throws SQLException {
        String query = "UPDATE Area SET estado = 0 WHERE codigo_area = ? ;";
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (eliminar == null) {
            eliminar = conn.prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Area cargar(ResultSet set) throws SQLException {

        Area area = new Area();
        area.setCodigo_area(set.getString("codigo_del_area"));
        area.setNombre_area(set.getString("nombre_area"));
        area.setDescripcion_area(set.getString("descripcion_area"));

        return area;
    }

    public List<Area> listar() throws SQLException {
        String query = "SELECT * FROM Area ";
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (listar == null) {
            listar = conn.prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Area> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

    public Area buscar(String id) throws SQLException {
        String query = "SELECT * \n"
                + "FROM Area\n"
                + "WHERE codigo_del_area = ? ;";
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (buscar == null) {
            buscar = conn.prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;
    }

    public void actualizar(Area entidad) throws SQLException {
        String query = "UPDATE Area SET  nombre = ?, descripcion_area = ? WHERE codigo_del_area = ?;";
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (actualizar == null) {
            actualizar = conn.prepareStatement(query);
        }

        actualizar.setString(1, entidad.getNombre_area());
        actualizar.setString(2, entidad.getDescripcion_area());
        actualizar.setString(3, entidad.getCodigo_area());

        actualizar.executeUpdate();
    }

}
