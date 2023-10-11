package postgrescrud.crud.dao;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public List<Map<String, Object>> getMenu(String uid);

    public List<Map<String, Object>> getPage(String pageId);

    public List<Map<String, Object>> getComp(String compId);
    
    
}
