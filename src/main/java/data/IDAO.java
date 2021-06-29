package data;


import java.sql.SQLException;
import java.util.List;



public interface IDAO <T> {
    
    void insertar(T entidad) throws SQLException;

    void eliminar(String id) throws SQLException;

    List<T> listar() throws SQLException;

    T buscar(String id) throws SQLException;

    void actualizar(T entidad) throws SQLException;
}

