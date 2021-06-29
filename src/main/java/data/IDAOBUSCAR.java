package data;


import java.sql.SQLException;
import java.util.List;

public interface IDAOBUSCAR <T> {
    
    T buscar(String id) throws SQLException;

}

