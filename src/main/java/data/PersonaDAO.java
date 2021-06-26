package data;

import static data.Conexion.*;
import domain.Persona;
import java.sql.*;
import java.util.*;

public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT * FROM Empleado";

    public List<Persona> seleccionar() {
        Connection conn = null;
        PreparedStatement smtm = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = getConnection();
            smtm = conn.prepareStatement(SQL_SELECT);
            rs = smtm.executeQuery();
            while (rs.next()) {
                var idPersona = rs.getString("identificacion_empleado");
                var nombre = rs.getString("nombre_empleado");
                var cargo = rs.getString("cargo_empleado");
                var salario = rs.getString("salario");
                var direccion = rs.getString("direccion_empleado");
                var e_mail = rs.getString("e_mail");
                var telefono = rs.getString("telefono_empleado");
                var area = rs.getString("area_empleado");
                var idJefe = rs.getString("identificacion_jefe");
                var estado = rs.getString("estado_empleado");
                persona = new Persona(idPersona, nombre, cargo, salario, direccion, e_mail, telefono, area, idJefe, estado);
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close((Connection) rs);
                Conexion.close((Connection) smtm);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return personas;
    }

}
