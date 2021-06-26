package data;

import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/centromedico?useSSl=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
    
    static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER,JDBC_PASSWORD); 
    }
    private static void close(ResultSet rs) throws SQLException{
        rs.close();        
    }
    private static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
    private static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    static void close(Connection conn) throws SQLException{
        conn.close();
    }

    static void close(PreparedStatement smtm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
