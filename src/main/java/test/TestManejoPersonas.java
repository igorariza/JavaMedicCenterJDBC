
package test;

import data.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();    
        //Insertando Objeto tipo persona
//        Persona newPersona = new Persona("1234578879", "Jefe 4","Jefe","5000000","Calle 2 # 30-32","emp10@gmail.com","3008009001","1001","1234567891","1");
//        personaDAO.insert(newPersona);
        
        //update datos empleado
//        Persona personUpdate = new Persona("1234578879","Jefe update","Jefe","5000000","Calle 2 # 30-32","emp10@gmail.com","3008009001","1001","1234567891","1");
//        personaDAO.update(personUpdate);

        //update datos empleado
        Persona personDelete = new Persona("12131546");
        personaDAO.delete(personDelete);
        //
        List<Persona> personas = personaDAO.seleccionar();
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
    
}
