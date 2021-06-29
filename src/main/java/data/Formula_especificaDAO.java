package data;

import static data.Conexion.*;
import domain.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Formula_especificaDAO implements IDAOBUSCAR1<Formula_especifica> {

    
    private PreparedStatement buscar;
   

    // --Formula_especifica(id_formula_especifica, id_formula_medica,codigo_medicamento,cantidad)
    private static Formula_especificaDAO instacia;

    public static Formula_especificaDAO getInstance() {
        if (instacia == null) {
            instacia = new Formula_especificaDAO();
        }
        return instacia;
    }

    

    public Formula_especifica cargar(ResultSet set) throws SQLException {

        Formula_especifica Formula_especifica = new Formula_especifica();
        Formula_especifica.setCodigo_medicamento(set.getString("codigo_medicamento"));
        Formula_especifica.setNombre_medicamento(set.getString("nombre_medicamento"));
        Formula_especifica.setDescripcion(set.getString("descripcion_medicamento"));
        Formula_especifica.setCantidad(set.getInt("cantidad"));
        Formula_especifica.setPrecio(set.getDouble("preciototal"));

        // --Formula_especifica(id_formula_especifica, id_formula_medica,codigo_medicamento,cantidad)
        return Formula_especifica;
    }

   

    
    public List<Formula_especifica> buscar(String id) throws SQLException {
        String query = "SELECT codigo_medicamento, nombre_medicamento, descripcion_medicamento ,cantidad ,(costo * cantidad) AS precioTotal\n"
                + "FROM (((formula_especifica NATURAL JOIN medicamento) AS lista INNER JOIN formula_medica ON lista.id_formula_medica =  formula_medica.id_formula) AS p \n"
                + "INNER JOIN paciente ON p.identificacion_paciente_formula = paciente.numero_ss ) AS medi\n"
                + "WHERE  medi.numero_ss = ?";

        if (buscar == null) {
            buscar = getConnection().prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();
        ArrayList<Formula_especifica> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
       
    }
}
