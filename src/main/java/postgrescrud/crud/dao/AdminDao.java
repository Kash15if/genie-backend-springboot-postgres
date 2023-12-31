package postgrescrud.crud.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import postgrescrud.crud.entity.User;

public interface AdminDao {
     

     public void createPage( String pageLabel, String structure) throws SQLException;

    public void updatePage(String pageId, String pageLabel, Object structure) throws SQLException;

    public void deletePage(String pageId) throws SQLException;

    public List<Map<String, Object>> getComponent(String pageId, String compId);

    public void updateComponent(String pageId, String componentId, String compLabel, String data, String compStyles ) throws SQLException;

    public void deleteComponent(String pageId, String compronentId ) throws SQLException;

    public void createUser(String uid, String password, String name, String clientId, String email) throws SQLException;

    public void updateUser(String uid, String password, String name, String clientId, String email) throws SQLException;

    public void deleteUser(String uid) throws SQLException;

    public List<Map<String, Object>> getUsers() throws SQLException;

    public List<Map<String, Object>> getPages() throws SQLException;

    public void assignPages(String userId, String[] pageIds) throws SQLException;

    public List<Map<String, Object>> pagesAssignation() throws SQLException;

    public void deletessignPages(String uid);

    public List<Map<String, Object>> getPageStructure(String pageId);

    }
