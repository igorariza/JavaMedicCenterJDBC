package data;

import static data.Conexion.*;
import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Historia_Clinica_EspecificaDAO implements IDAO<Historia_Clinica_Especifica> {

     //para las consultas SQL............
    private PreparedStatement insertar = null;
    private PreparedStatement eliminar = null;
    private PreparedStatement actualizar = null;
    private PreparedStatement buscar = null;
    private PreparedStatement listar = null;
    private Connection conn = null;
    private Connection conexionTransaccional;


    private static Historia_Clinica_EspecificaDAO instacia;

    public static Historia_Clinica_EspecificaDAO getInstance() {
        if (instacia == null) {
            instacia = new Historia_Clinica_EspecificaDAO();
        }
        return instacia;
    }

    public void insertar(Historia_Clinica_Especifica entidad) throws SQLException {

        String query = "INSERT INTO Historia_Clinica_Especifica(historia_serial_hce, fecha_consulta, "
                + "identificacion_medico_hce, precio, causas_hce, descuento) VALUES "
                + "(?,?,?,?,?,?);";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (insertar == null) {
            insertar = conn.prepareStatement(query);
        }

        insertar.setInt(1, entidad.getHistoria_serial_hce());
        insertar.setString(2, entidad.getFecha_consulta());
        insertar.setString(3, entidad.getIdentificacion_medico_hce());
        insertar.setDouble(4, entidad.getPrecio());
        insertar.setString(5, entidad.getCausas_hce());
        insertar.setDouble(6, entidad.getDescuento());
        insertar.executeUpdate();

    }

    public void eliminar(String id) throws SQLException {
        String query = "DELETE FROM Historia_Clinica_Especifica WHERE historia_serial_hce= ?;";
//--------------------------------------------Hay error ya que es llave compuesta, corregir
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (eliminar == null) {
            eliminar = conn.prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Historia_Clinica_Especifica cargar(ResultSet set) throws SQLException {

        Historia_Clinica_Especifica Historia_Clinica_Especifica = new Historia_Clinica_Especifica();
        Historia_Clinica_Especifica.setHistoria_serial_hce(set.getInt("historia_serial_hce"));
        Historia_Clinica_Especifica.setFecha_consulta(set.getString("fecha_consulta"));
        Historia_Clinica_Especifica.setIdentificacion_medico_hce(set.getString("identificacion_medico_hce"));
        Historia_Clinica_Especifica.setPrecio(set.getDouble("precio"));
        Historia_Clinica_Especifica.setCausas_hce(set.getString("causas_hce"));
        Historia_Clinica_Especifica.setDescuento(set.getDouble("descuento"));
        return Historia_Clinica_Especifica;
    }

    public List<Historia_Clinica_Especifica> listar() throws SQLException {
        String query = "SELECT *\n"
                + "FROM Historia_Clinica_Especifica\n";

       conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (listar == null) {
            listar = conn.prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Historia_Clinica_Especifica> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

    public Historia_Clinica_Especifica buscar(String id) throws SQLException {
        String query = "SELECT * \n"
                + "FROM Historia_Clinica_Especifica\n"
                + "WHERE Historia_Clinica_Especifica.historia_serial_hce= ? ;";
        //-------------------Error llave compuesta

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (buscar == null) {
            buscar = conn.prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;
    }

    public void actualizar(Historia_Clinica_Especifica entidad) throws SQLException {

        String query = "UPDATE Historia_Clinica_Especifica SET  identificacion_medico_hce = ?, precio = ?, "
                + "causas_hce = ?, descuento = ? WHERE historia_serial_hce = ?, AND fecha_consulta = ?);";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (actualizar == null) {
            actualizar = conn.prepareStatement(query);
        }

        actualizar.setString(1, entidad.getIdentificacion_medico_hce());
        actualizar.setDouble(2, entidad.getPrecio());
        actualizar.setString(3, entidad.getCausas_hce());
        actualizar.setDouble(4, entidad.getDescuento());

        actualizar.setDouble(5, entidad.getHistoria_serial_hce());
        actualizar.setString(6, entidad.getFecha_consulta());

        actualizar.executeUpdate();
    }
}
