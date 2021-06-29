package data;

import static data.Conexion.*;
import domain.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Participante_CampanaDAO implements IDAO<Participante_Campana> {//clase que retorna o bien un vector o una matriz de 

    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;

    private static Participante_CampanaDAO instacia;

    private Participante_CampanaDAO() {
    }//constructor

    public static Participante_CampanaDAO getInstance() {
        if (instacia == null) {
            instacia = new Participante_CampanaDAO();
        }
        return instacia;
    }//crea una instancia del objeto.

    @Override
    public void insertar(Participante_Campana entidad) throws SQLException {

        String query = "INSERT INTO Participante_Campana (codigo_de_campana, identificacion_paciente) VALUES (?, ?)";

        if (insertar == null) {
            insertar = getConnection().prepareStatement(query);
        }

        insertar.setString(1, entidad.getCodigo_de_campana());
        insertar.setString(2, entidad.getIdentificacion_paciente());
        insertar.executeUpdate();

    }

    @Override
    public void eliminar(String id) throws SQLException {
        String query = "DELETE FROM Participante_Campana WHERE codigo_de_campana = ? ";

        if (eliminar == null) {
            eliminar = getConnection().prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public Participante_Campana cargar(ResultSet set) throws SQLException {

        Participante_Campana participante_campana = new Participante_Campana();
        participante_campana.setNombre_paciente(set.getString("nombre_paciente"));
        participante_campana.setDireccion_paciente(set.getString("direccion_paciente"));
        participante_campana.setTelefono_pacietne(set.getString("telfono_paciente"));

        return participante_campana;
    }

    @Override
    public List<Participante_Campana> listar() throws SQLException {
        String query = "SELECT * \n"
                + "FROM Participante_Campana \n";

        if (listar == null) {
            listar = getConnection().prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<Participante_Campana> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

    
//    public List<Participante_Campana> buscar(String id) throws SQLException {
//
//        String query = "SELECT DISTINCT   nombre_paciente, direccion_paciente, telefono_paciente\n"
//                + "FROM campana_prevencion NATURAL JOIN (participante_campana INNER JOIN paciente ON participante_campana.identificacion_paciente = paciente.numero_ss) \n"
//                + "WHERE codigo_de_campana = ?";
//
//        if (buscar == null) {
//            buscar = getConnection().prepareStatement(query);
//        }
//
//        buscar.setString(1, id);
//        ResultSet set = buscar.executeQuery();
//        ArrayList<Participante_Campana> result = new ArrayList<>();
//        while (set.next()) {
//            result.add(cargar(set));
//        }
//
//        return result;
//    }

    @Override
    public void actualizar(Participante_Campana entidad) throws SQLException {
//Aqui no debe ser posible hacer actualizaciones
    }

    @Override
    public Participante_Campana buscar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
