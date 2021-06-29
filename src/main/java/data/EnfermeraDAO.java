package data;

import static data.Conexion.*;
import domain.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnfermeraDAO implements IDAO<Enfermera> {

    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;

    private static EnfermeraDAO instacia;

    public static EnfermeraDAO getInstance() {
        if (instacia == null) {
            instacia = new EnfermeraDAO();
        }
        return instacia;
    }

    public void insertar(Enfermera entidad) throws SQLException {

        String query = "INSERT INTO Enfermera(identificacion_enfermera, anos_experiencia) VALUES "
                + "(?,?);";

        if (insertar == null) {
            insertar = getConnection().prepareStatement(query);
        }

        insertar.setString(1, entidad.getIdentificacion_enfermera());
        insertar.setString(2, entidad.getAnos_de_experiencia());
        insertar.executeUpdate();

    }

    public void eliminar(String id) throws SQLException {
        String query = "DELETE FROM Enfermera WHERE identificacion_enfermera = ? ;";

        if (eliminar == null) {
            eliminar = getConnection().prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Enfermera cargar(ResultSet set) throws SQLException {

        Enfermera cama = new Enfermera();
        cama.setIdentificacion_enfermera(set.getString("identificacion_enfermera"));
        cama.setNombre_empleado(set.getString("nombre_empleado"));
        cama.setAnos_de_experiencia(set.getString("anos_de_experiencia"));
        cama.setSalario(set.getString("salario"));
        cama.setTelefono_empleado(set.getString("telefono_empleado"));
        cama.setE_mail(set.getString("e_mail"));
        cama.setDireccion_empleado(set.getString("direccion_empleado"));
        return cama;
    }

    public List<Enfermera> listar() throws SQLException {
        String query = "SELECT identificacion_enfermera, nombre_empleado, anos_de_experiencia, salario, telefono_empleado, e_mail, direccion_empleado \n"
                + "                  FROM (empleado INNER JOIN enfermera ON empleado.identificacion_empleado = enfermera.identificacion_enfermera) AS c1 INNER JOIN area ON c1.area_empleado = area.codigo_area\n"
                + "                  WHERE  c1.estado_empleado = '1'";

        if (listar == null) {
            listar = getConnection().prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Enfermera> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

    public Enfermera buscar(String id) throws SQLException {
        String query = "SELECT * \n"
                + "FROM Enfermera INNER JOIN Empleados ON Empleados.identificacion_enfermera = Enfermera.identificacion_empleado\n"
                + "WHERE Enfermera.identificacion = ? ;";

        if (buscar == null) {
            buscar = getConnection().prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;
    }

    public void actualizar(Enfermera entidad) throws SQLException {

        String query = "UPDATE Enfermera SET  anos_experiencia = ? WHERE identificacion_enfermera = ? ;";

        if (actualizar == null) {
            actualizar = getConnection().prepareStatement(query);
        }

        actualizar.setString(2, entidad.getIdentificacion_enfermera());
        actualizar.setString(1, entidad.getAnos_de_experiencia());
        actualizar.executeUpdate();
    }
}
