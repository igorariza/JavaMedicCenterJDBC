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
public class RecursoHistoria_Clinica_Especifica {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Historia_Clinica_Especifica> get(){
        try {
            return Historia_Clinica_EspecificaDAO.getInstance().listar();
            
        } catch (SQLException ex) {
            Logger.getLogger(RecursoHistoria_Clinica_Especifica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Historia_Clinica_Especifica usuario){
        try {
            Historia_Clinica_EspecificaDAO.getInstance().insertar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoHistoria_Clinica_Especifica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Historia_Clinica_Especifica getUsuarioById(@PathParam("id")String id){
        try {
            return Historia_Clinica_EspecificaDAO.getInstance().buscar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoHistoria_Clinica_Especifica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")String id){
        try {
            Historia_Clinica_EspecificaDAO.getInstance().eliminar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoHistoria_Clinica_Especifica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Path("{id}")
    public void put(@PathParam("id")Integer id, Historia_Clinica_Especifica usuario){
        usuario.setHistoria_serial_hce(id);
        try {
            Historia_Clinica_EspecificaDAO.getInstance().actualizar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoHistoria_Clinica_Especifica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}