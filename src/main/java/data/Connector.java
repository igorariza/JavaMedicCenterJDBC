package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class Connector {

    private Connection con;
    private final String driver = "org.postgresql.Driver";//donde tiene el driver 
    private final String usuario = "postgres";//base de datos donde lo corre
    private final String contrasena = "Ia2127374";//contraseña
    private final String urlBaseDatos = "jdbc:postgresql://localhost:5432/Clinica?serverTimezone=UTC";
    //direccion donde esta la base de datos....

    private static Connector conexion;

    private Connector() {

    }

    public static Connector getInstance() throws SQLException {
        if (conexion == null) {
            conexion = new Connector();
        }
        conexion.conectar();
        return conexion;
    }

    private void conectar() throws SQLException {
        if (con == null || con.isClosed()) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }
            con = DriverManager.getConnection(urlBaseDatos, usuario, contrasena);
        }
    }

    public boolean existeConexion() throws SQLException {
        return con != null && !con.isClosed();
    }

    public Connection getConnection() {
        return con;
    }

}
