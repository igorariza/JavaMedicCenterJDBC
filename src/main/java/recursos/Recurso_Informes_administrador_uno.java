package recursos;

import data.*;
import domain.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("pacientes")
public class Recurso_Informes_administrador_uno {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Informes_administrador_uno> get(Informes_administrador_uno usuario){
        try {
            return Informes_administrador_unoDAO.getInstance().listar(usuario);
            
        } catch (SQLException ex) {
            Logger.getLogger(Recurso_Informes_administrador_uno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}