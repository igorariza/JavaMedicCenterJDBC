package data;

import static data.Conexion.*;
import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario implements IDAO<User> {

    //para las consultas SQL............
    private PreparedStatement insertar = null;
    private PreparedStatement eliminar = null;
    private PreparedStatement actualizar = null;
    private PreparedStatement buscar = null;
    private PreparedStatement listar = null;
    private Connection conn = null;
    private Connection conexionTransaccional;

    private static DaoUsuario instacia;

    private DaoUsuario() {
    }

    public static DaoUsuario getInstance() {
        if (instacia == null) {
            instacia = new DaoUsuario();
        }
        return instacia;
    }

    public void insertar(User usuario) throws SQLException {
        String query = "INSERT INTO Usuarios (id_usuario, nombreapellido_usuario, username, psw, id_estado, id_rol) VALUES (?, ?, ?, ?, ?, ?)";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (insertar == null) {
            insertar = conn.prepareStatement(query);
        }

        insertar.setString(1, usuario.getCodigo_usuario());
        insertar.setString(2, usuario.getNombre_usuario());
        insertar.setString(3, usuario.getUsername());
        insertar.setString(4, usuario.getPsw());
        insertar.setInt(5, 1);
        insertar.setInt(6, usuario.getId_rol());
        insertar.executeUpdate();
    }

    public void eliminar(String id) throws SQLException {
        String query = "DELETE FROM Usuarios WHERE id_usuario = ?";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (eliminar == null) {
            eliminar = conn.prepareStatement(query);
        }

        eliminar.setString(1, id);
        eliminar.executeUpdate();
    }

    public List<User> listar() throws SQLException {
        String query = "SELECT Usuarios.id_usuario, Usuarios.nombreapellido_usuario, Usuarios.username, Usuarios.id_rol, Rol.nombre, estados.nombre_estado \n"
                + "FROM Usuarios, Rol, estados \n"
                + "WHERE Usuarios.id_estado=estados.id_estado AND Rol.id_rol=Usuarios.id_rol";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (listar == null) {
            listar = conn.prepareStatement(query);
        }
        ResultSet set = listar.executeQuery();
        ArrayList<User> result = new ArrayList<>();
        while (set.next()) {
            result.add(cargar(set));
        }

        return result;
    }

    public User buscar(String id) throws SQLException {
        String query = "SELECT usuarios.id_usuario, usuarios.nombreapellido_usuario, usuarios.username, usuarios.psw, usuarios.id_rol, roles.nombre_rol, estados.nombre_estado \n"
                + "FROM usuarios, roles, estados \n"
                + "WHERE usuarios.id_estado=estados.id_estado AND roles.id_rol=usuarios.id_rol AND usuarios.id_estado=1  AND usuarios.username = ?";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (buscar == null) {
            buscar = conn.prepareStatement(query);
        }

        buscar.setString(1, id);
        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;
    }

    public void actualizar(User usuario) throws SQLException {
        String query = "UPDATE Usuarios SET nombreapellido_usuario=?, username=?, psw=?, id_estado=?, id_rol=?"
                + "WHERE id_usuario = ?";

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        if (actualizar == null) {
            actualizar = conn.prepareStatement(query);
        }

        actualizar.setString(1, usuario.getNombre_usuario());
        actualizar.setString(2, usuario.getUsername());
        actualizar.setString(3, usuario.getPsw());
        actualizar.setInt(4, usuario.getId_estado());
        actualizar.setInt(5, usuario.getId_rol());
        actualizar.setString(6, usuario.getCodigo_usuario());

        actualizar.executeUpdate();
    }

    public User cargar(ResultSet set) throws SQLException {

        User usuario = new User();
        usuario.setCodigo_usuario(set.getString("id_usuario"));
        usuario.setNombre_usuario(set.getString("nombreapellido_usuario"));
        usuario.setUsername(set.getString("username"));
        usuario.setPsw(set.getString("psw"));
        usuario.setId_rol(set.getInt("id_rol"));
        usuario.setRol(set.getString("nombre_rol"));
        usuario.setEstado(set.getString("nombre_estado"));
        return usuario;
    }
}
