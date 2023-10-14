package postgrescrud.crud.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import postgrescrud.crud.dao.AdminDao;
import postgrescrud.crud.entity.User;

@Service
public class AdminService implements AdminDao {

      @Autowired
    private final JdbcTemplate jdbcCon;


    public AdminService(JdbcTemplate jdbcCon) {
        this.jdbcCon = jdbcCon;
    }


    // jdbcTemplate.update(sql, col1, col2/*, Add more parameters as needed */);
    @Override
    public void createPage(String pageId, String pageLabel, Object structure) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPage'");
    }

    @Override
    public void updatePage(String pageId, String pageLabel, Object structure) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePage'");
    }

    @Override
    public void deletePage(String pageId) throws SQLException {
        String sql = "DELETE FROM public.components\r\n" + //
                "\tWHERE page_id = ?;\r\n" + //
                "DELETE FROM public.pages\r\n" + //
                "\tWHERE pageid = ?;";
        jdbcCon.update(sql, pageId, pageId);
    }

    @Override
    public void updateComponent(String pageId, String compronentId, String compLabel, Object data,
            Object compStyles) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateComponent'");
    }

    @Override
    public void deleteComponent(String pageId, String compronentId) throws SQLException {
        String sql = "DELETE FROM public.components\r\n" + //
                "\tWHERE component_id = ? and page_id = ?;";
        jdbcCon.update(sql, compronentId, pageId);
    }

    @Override
    public void createUser(User newUser) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public void updateUser(String uid, User updatedUser) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(String uid) throws SQLException {
        String sql = "DELETE FROM public.users WHERE  uid=?;";
        jdbcCon.update(sql, uid);
    }

    @Override
    public List<Map<String, Object>> getUsers() throws SQLException {
        return jdbcCon.queryForList("select * from  public.\"users\"");
    }

    @Override
    public List<Map<String, Object>> getPages() throws SQLException {    
        return jdbcCon.queryForList("select * from  public.\"pages\"");
    }

    @Override
    public void assignPages(String userId, String[] pageIds) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assignPages'");
    }

    @Override
    public List<Map<String, Object>> pagesAssignation() throws SQLException {
        return jdbcCon.queryForList("select * from from public.\"pages-uid\"");
    }
    
     
}
