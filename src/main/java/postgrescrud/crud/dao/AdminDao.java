package postgrescrud.crud.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import postgrescrud.crud.entity.User;

public interface AdminDao {
     

     public void createPage(String pageId, String pageLabel, Object structure) throws SQLException;

    public void updatePage(String pageId, String pageLabel, Object structure) throws SQLException;

    public void deletePage(String pageId) throws SQLException;

    public void updateComponent(String pageId, String compronentId, String compLabel, Object data, Object compStyles ) throws SQLException;

    public void deleteComponent(String pageId, String compronentId ) throws SQLException;

    public void createUser(User newUser) throws SQLException;

    public void updateUser(String uid, User updatedUser) throws SQLException;

    public void deleteUser(String uid) throws SQLException;

    public List<Map<String, Object>> getUsers() throws SQLException;

    public List<Map<String, Object>> getPages() throws SQLException;

    public void assignPages(String userId, String[] pageIds) throws SQLException;

    public List<Map<String, Object>> pagesAssignation() throws SQLException;

    }
