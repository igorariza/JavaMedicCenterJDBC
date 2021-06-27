package data;

import static data.Conexion.*;
import domain.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT * FROM Usuario";
    private static final String SQL_INSERT = "INSERT INTO Usuario (usuario, id_usuario, password) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Usuario SET password = ? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM Usuario WHERE id_usuario = ?";
    
    public List<Usuario> seleccionar() {
        Connection conn = null;
        PreparedStatement smtm = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            conn = getConnection();
            smtm = conn.prepareStatement(SQL_SELECT);
            rs = smtm.executeQuery();
            while (rs.next()) {
                var usuarioName = rs.getString("usuario");
                var idUsuario = rs.getString("id_usuario");
                var password = rs.getString("password");
                usuario = new Usuario(usuarioName, idUsuario, password);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(smtm);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return usuarios;
    }

    public int insert(Usuario usuario) {
        Connection conn = null;
        PreparedStatement smtm = null;
        int registro = 0;
        try {
            conn = getConnection();
            smtm = conn.prepareStatement(SQL_INSERT);
            smtm.setString(1, usuario.getUsuario());
            smtm.setString(2, usuario.getId_usuario());
            smtm.setString(3, usuario.getPassword());
            registro = smtm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(smtm);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;

    }
    
    public int update(Usuario usuario) {
        Connection conn = null;
        PreparedStatement smtm = null;
        int registro = 0;
        try {
            conn = getConnection();
            smtm = conn.prepareStatement(SQL_UPDATE);
            smtm.setString(1, usuario.getPassword());
            smtm.setString(2, usuario.getId_usuario());
            registro = smtm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(smtm);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;

    }
    public int delete(Usuario usuario) {
        Connection conn = null;
        PreparedStatement smtm = null;
        int registro = 0;
        try {
            conn = getConnection();
            smtm = conn.prepareStatement(SQL_DELETE);
            smtm.setString(1, usuario.getId_usuario());
            registro = smtm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(smtm);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;

    }

}
