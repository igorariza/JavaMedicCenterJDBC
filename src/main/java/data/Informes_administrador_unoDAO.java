package data;

import static data.Conexion.*;
import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Informes_administrador_unoDAO {

    //para las consultas SQL............
    private PreparedStatement listar = null;
    private Connection conn = null;
    private Connection conexionTransaccional;
    private static Informes_administrador_unoDAO instacia;

    private Informes_administrador_unoDAO() {
    }//constructor

    public static Informes_administrador_unoDAO getInstance() {
        if (instacia == null) {
            instacia = new Informes_administrador_unoDAO();
        }
        return instacia;
    }

    public Informes_administrador_uno cargar(ResultSet set) throws SQLException {

        Informes_administrador_uno area = new Informes_administrador_uno();
        area.setNombre_empleado(set.getString("nombre_empleado"));
        area.setIdentificacion_medico_cita(set.getString("identificacion_medico_cita"));
        area.setCitas_atendidas(set.getString("citas_atendidas"));

        return area;
    }

    public List<Informes_administrador_uno> listar(Informes_administrador_uno entidad) throws SQLException {
        String query = "SELECT Empleado.nombre_empleado, R2.identificacion_medico_cita, R2.Citas_atendidas\n"
                + "FROM Empleado INNER JOIN (SELECT R1.identificacion_medico_cita, COUNT(R1.fecha_cita)AS Citas_atendidas\n"
                + "FROM (SELECT * FROM cita_medica WHERE Cita_medica.fecha_cita BETWEEN '?' AND '?' AND estado_cita = 'Atendida') AS R1\n"
                + "GROUP BY R1.identificacion_medico_cita) AS R2 ON Empleado.identificacion_empleado = R2.identificacion_medico_cita";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (listar == null) {
            listar = conn.prepareStatement(query);
        }
        listar.setString(1, entidad.getFecha_inicial());
        listar.setString(2, entidad.getFecha_final());
        ResultSet set = listar.executeQuery();
        ArrayList<Informes_administrador_uno> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

}
