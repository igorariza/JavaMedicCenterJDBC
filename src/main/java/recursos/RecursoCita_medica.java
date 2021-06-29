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
public class RecursoCita_medica {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cita_medica> get(){
        try {
            return Cita_medicaDAO.getInstance().listar();
            
        } catch (SQLException ex) {
            Logger.getLogger(RecursoCita_medica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Cita_medica usuario){
        try {
            Cita_medicaDAO.getInstance().insertar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoCita_medica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cita_medica getUsuarioById(@PathParam("id")String id){
        try {
            return Cita_medicaDAO.getInstance().buscar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoCita_medica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")String id){
        try {
            Cita_medicaDAO.getInstance().eliminar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoCita_medica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Path("{id}")
    public void put(@PathParam("id")Integer id, Cita_medica usuario){
        usuario.setId_cita(id);
        try {
            Cita_medicaDAO.getInstance().actualizar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoCita_medica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}