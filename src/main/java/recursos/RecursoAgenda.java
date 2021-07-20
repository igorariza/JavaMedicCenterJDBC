package recursos;

import data.*;
import domain.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


public class RecursoAgenda {
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AgendaDTO> getUsuarioById(@PathParam("id")String id){
        try {
            return AgendaDaoJDBC.getInstance().buscar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
