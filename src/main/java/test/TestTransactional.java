package test;

import data.Conexion;
import data.*;
import domain.*;
import java.sql.*;
import java.util.List;

public class TestTransactional {

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            PersonaDAO pesonaDao = new PersonaDAO(conexion);
//            List<> personas = pesonaDao.seleccionar();

//            Persona updateEmpleado = new Persona();
//            updateEmpleado.setNombre("Jefe actualizado");
//            updateEmpleado.setIdEmpleado("1234567879");
//            updateEmpleado.setCargo("jefe");
//            updateEmpleado.setSalario("80000000");
//            updateEmpleado.setDireccion("Calle 2 # 30-32");
//            updateEmpleado.setE_mail("emp10@gmail.com");
//            updateEmpleado.setIdJefe("1234567891");
//            updateEmpleado.setEstado("1");
//            updateEmpleado.setArea("1001");
//            updateEmpleado.setTelefono("3008009001");
//
//            pesonaDao.update(updateEmpleado);
//
//            Persona createEmpleado = new Persona();
//            createEmpleado.setNombre("Jefe creado");
//            createEmpleado.setIdEmpleado("1023567879");
//            createEmpleado.setCargo("jefe nuevo");
//            createEmpleado.setSalario("20000000");
//            createEmpleado.setDireccion("Calle 22 # 35-32");
//            createEmpleado.setE_mail("emp110@gmail.com");
//            createEmpleado.setIdJefe("1234567891");
//            createEmpleado.setEstado("1");
//            createEmpleado.setArea("1001");
//            createEmpleado.setTelefono("3008029001");
//
//            pesonaDao.insert(createEmpleado);
            
            conexion.commit();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

}
