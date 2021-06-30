package data;

import static data.Conexion.*;
import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements IDAO<Empleado> {

     //para las consultas SQL............
    private PreparedStatement insertar = null;
    private PreparedStatement eliminar = null;
    private PreparedStatement actualizar = null;
    private PreparedStatement buscar = null;
    private PreparedStatement listar = null;
    private Connection conn = null;
    private Connection conexionTransaccional;

    private static EmpleadoDAO instacia;

    private EmpleadoDAO() {
    }//constructor

    public static EmpleadoDAO getInstance() {
        if (instacia == null) {
            instacia = new EmpleadoDAO();
        }
        return instacia;
    }

    public void insertar(Empleado entidad) throws SQLException {

        String query = "INSERT INTO Empleado (identificacion_empleado, nombre_empleado, cargo_empleado, salario, direccion_empleado, e_mail, telefono_empleado, area_empleado, identificacion_jefe, estado_empleado) VALUES "
                + "(?,?,?,?,?,?,?,?,?,'1');";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (insertar == null) {
            insertar = conn.prepareStatement(query);
        }

        insertar.setString(1, entidad.getIdentificacion_empleado());
        insertar.setString(2, entidad.getNombre_empleado());
        insertar.setString(3, entidad.getCargo_empleado());
        insertar.setString(4, entidad.getSalario());
        insertar.setString(5, entidad.getDireccion_empleado());
        insertar.setString(6, entidad.getE_mail());
        insertar.setString(7, entidad.getTelefono_empleado());
        insertar.setString(8, entidad.getArea_empleado());
        insertar.setString(9, entidad.getIdentificacion_jefe());
        insertar.executeUpdate();

    }

    public void eliminar(String id) throws SQLException {
        String query = "UPDATE Empleado SET estado_empleado = 0 WHERE identificacion_empleado = ? ;";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (eliminar == null) {
            eliminar = conn.prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Empleado cargar(ResultSet set) throws SQLException {

        Empleado Empleado = new Empleado();
        Empleado.setIdentificacion_empleado(set.getString("identificacion_empleado"));
        Empleado.setNombre_empleado(set.getString("nombre_empleado"));
        Empleado.setCargo_empleado(set.getString("cargo_empleado"));
        Empleado.setSalario(set.getString("salario"));
        Empleado.setDireccion_empleado(set.getString("direccion_empleado"));
        Empleado.setE_mail(set.getString("e_mail"));
        Empleado.setTelefono_empleado(set.getString("telefono_empleado"));
        Empleado.setArea_empleado(set.getString("area_empleado"));
        Empleado.setIdentificacion_jefe(set.getString("identificacion_jefe"));
        Empleado.setEstado_empleado(set.getString("estado_empleado"));

        return Empleado;
    }

    public List<Empleado> listar() throws SQLException {
        String query = "SELECT *\n"
                + "FROM Empleado \n";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (listar == null) {
            listar = conn.prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Empleado> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

    public Empleado buscar(String id) throws SQLException {
        String query = "SELECT * \n"
                + "FROM Empleado\n"
                + "WHERE identificacion_empleado = ? ;";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (buscar == null) {
            buscar = conn.prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;
    }

    public void actualizar(Empleado entidad) throws SQLException {

        String query = "UPDATE Empleado SET  nombre_empleado = ?, cargo_empleado = ?, salario = ?, "
                + "direccion_empleado = ?, e_mail = ?, telefono_empleado = ?, area_empleado = ?, identificacion_jefe = ?, estado_empleado = ?"
                + " WHERE identificacion_empleado = ? ;";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (actualizar == null) {
            actualizar = conn.prepareStatement(query);
        }

        actualizar.setString(1, entidad.getNombre_empleado());
        actualizar.setString(2, entidad.getCargo_empleado());
        actualizar.setString(3, entidad.getSalario());
        actualizar.setString(4, entidad.getDireccion_empleado());
        actualizar.setString(5, entidad.getE_mail());
        actualizar.setString(6, entidad.getTelefono_empleado());
        actualizar.setString(7, entidad.getArea_empleado());
        actualizar.setString(8, entidad.getIdentificacion_jefe());
        actualizar.setString(9, entidad.getEstado_empleado());
        actualizar.setString(10, entidad.getIdentificacion_empleado());
        actualizar.executeUpdate();
    }
}
