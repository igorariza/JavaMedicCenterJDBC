package recursos;

import data.*;
import domain.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("pacientes")
public class RecursoPaciente_Cama {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente_Cama> get(){
        try {
            return Paciente_CamaDAO.getInstance().listar();
            
        } catch (SQLException ex) {
            Logger.getLogger(RecursoPaciente_Cama.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Paciente_Cama usuario){
        try {
            Paciente_CamaDAO.getInstance().insertar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoPaciente_Cama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente_Cama getUsuarioById(@PathParam("id")String id){
        try {
            return Paciente_CamaDAO.getInstance().buscar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoPaciente_Cama.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")String id){
        try {
            Paciente_CamaDAO.getInstance().eliminar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoPaciente_Cama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Path("{id}")
    public void put(@PathParam("id")String id, Paciente_Cama usuario){
        usuario.setIdentificacion_paciente(id);
        try {
            Paciente_CamaDAO.getInstance().actualizar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoPaciente_Cama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}