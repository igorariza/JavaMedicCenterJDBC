package data;

import domain.AgendaDTO;
import java.util.List;

public interface IAgendaDao {
    
    public List<AgendaDTO> select();    
    public int insert(AgendaDTO agenda);
    public int update(AgendaDTO agenda);
    public int delete(AgendaDTO agenda);
    
    
    
}
