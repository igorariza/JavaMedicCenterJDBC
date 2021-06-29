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
public class RecursoParticipante_Campana {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Participante_Campana> get(){
        try {
            return Participante_CampanaDAO.getInstance().listar();
            
        } catch (SQLException ex) {
            Logger.getLogger(RecursoParticipante_Campana.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Participante_Campana usuario){
        try {
            Participante_CampanaDAO.getInstance().insertar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoParticipante_Campana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Participante_Campana getUsuarioById(@PathParam("id")String id){
        try {
            return Participante_CampanaDAO.getInstance().buscar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoParticipante_Campana.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")String id){
        try {
            Participante_CampanaDAO.getInstance().eliminar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoParticipante_Campana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Path("{id}")
    public void put(@PathParam("id")String id, Participante_Campana usuario){
        usuario.setIdentificacion_paciente(id);
        try {
            Participante_CampanaDAO.getInstance().actualizar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoParticipante_Campana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}