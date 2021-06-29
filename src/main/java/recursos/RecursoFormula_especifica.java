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

@Path("formulaespecifica")
public class RecursoFormula_especifica {
    
    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Formula_especifica> getUsuarioById(@PathParam("id")String id){
        try {
            return Formula_especificaDAO.getInstance().buscar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoFormula_especifica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}