package data;

import static data.Conexion.*;
import domain.Persona;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT * FROM Empleado";
    private static final String SQL_INSERT = "INSERT INTO Empleado (identificacion_empleado, nombre_empleado, cargo_empleado, salario, direccion_empleado, e_mail, telefono_empleado, area_empleado, identificacion_jefe, estado_empleado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
                close(rs);
                close(smtm);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return personas;
    }

    public int insert(Persona persona) {
        Connection conn = null;
        PreparedStatement smtm = null;
        int registro = 0;
        try {
            conn = getConnection();
            smtm = conn.prepareStatement(SQL_INSERT);
            smtm.setString(1, persona.getIdEmpleado());
            smtm.setString(2, persona.getNombre());
            smtm.setString(3, persona.getCargo());
            smtm.setString(4, persona.getSalario());
            smtm.setString(5, persona.getDireccion());
            smtm.setString(6, persona.getE_mail());
            smtm.setString(7, persona.getTelefono());
            smtm.setString(8, persona.getArea());
            smtm.setString(9, persona.getIdJefe());
            smtm.setString(10, persona.getEstado());
            registro = smtm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(smtm);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;

    }

}
