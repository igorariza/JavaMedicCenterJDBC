package data;


import java.sql.SQLException;
import java.util.List;

public interface IDAOBUSCAR1 <T> {
    
   List<T> buscar(String id) throws SQLException;
   List<T> listar() throws SQLException;

}

