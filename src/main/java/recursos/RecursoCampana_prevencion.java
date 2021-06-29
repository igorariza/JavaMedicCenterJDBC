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
public class RecursoCampana_prevencion {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Campana_prevencion> get(){
        try {
            return Campana_prevencionDAO.getInstance().listar();
            
        } catch (SQLException ex) {
            Logger.getLogger(RecursoCampana_prevencion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Campana_prevencion usuario){
        try {
            Campana_prevencionDAO.getInstance().insertar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoCampana_prevencion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Campana_prevencion getUsuarioById(@PathParam("id")String id){
        try {
            return Campana_prevencionDAO.getInstance().buscar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoCampana_prevencion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")String id){
        try {
            Campana_prevencionDAO.getInstance().eliminar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoCampana_prevencion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Path("{id}")
    public void put(@PathParam("id")String id, Campana_prevencion usuario){
        int idCampana = Integer.parseInt(id);
        usuario.setCodigo_de_campana(idCampana);
        try {
            Campana_prevencionDAO.getInstance().actualizar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoCampana_prevencion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}