package postgrescrud.crud.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import postgrescrud.crud.dao.AdminDao;
import postgrescrud.crud.entity.User;

@Service
public class AdminService implements AdminDao {

      @Autowired
    private final JdbcTemplate jdbcCon;
    private final PlatformTransactionManager transactionManager;


    public AdminService(JdbcTemplate jdbcCon, PlatformTransactionManager transactionManager) {
        this.jdbcCon = jdbcCon;
        this.transactionManager = transactionManager;
    }


    // jdbcTemplate.update(sql, col1, col2/*, Add more parameters as needed */);
    @Override
    public void createPage(String pageId, String pageLabel, String structure) throws SQLException {

        System.out.println(pageId);
        System.out.println(structure);
        String sql = "INSERT INTO public.pages( pageid, pagelabel, structure) VALUES (?, ?, ? :: json);";

        jdbcCon.update(sql, pageId, pageLabel, structure);
  
    }

    @Override
    public void updatePage(String pageId, String pageLabel, Object structure) throws SQLException {
        String sql = "UPDATE public.pages SET pagelabel=?, structure=? :: json WHERE pageid=?;";
        jdbcCon.update(sql, pageLabel, structure, pageId);
    }

    @Override
    public void deletePage(String pageId) throws SQLException {

         TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        String sql = "BEGIN; DELETE FROM public.components WHERE page_id = ?; DELETE FROM public.pages WHERE pageid = ?; COMMIT;";
        jdbcCon.update(sql, pageId, pageId);
        transactionManager.commit(status);
    }

    @Override
    public void updateComponent(String pageId, String componentId, String compLabel, String data,
    String compStyles) throws SQLException {

        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        String sql = "BEGIN; DELETE FROM public.components WHERE page_id=? and component_id=?; INSERT INTO public.components( page_id, component_id, component_label, data, component_styles) VALUES (?, ?, ?, ? ::json , ? ::json); COMMIT;";

        jdbcCon.update(sql, pageId, componentId, pageId, componentId, compLabel, data, compStyles);
        transactionManager.commit(status);
    }

    @Override
    public void deleteComponent(String pageId, String compronentId) throws SQLException {
        String sql = "DELETE FROM public.components\r\n" + //
                "\tWHERE component_id = ? and page_id = ?;";
        jdbcCon.update(sql, compronentId, pageId);
    }

    @Override
    public void createUser(String uid, String password, String name, String clientId, String email) throws SQLException {
       String sql = "INSERT INTO public.users( uid, password, name, clientid, email) VALUES (? ::uuid, ?, ?, ?, ?);";
        jdbcCon.update(sql, uid, password, name, clientId, email);
    }

    @Override
    public void updateUser(String uid, String password, String name, String clientId, String email) throws SQLException {
        String sql = "UPDATE public.users SET  password=?, name=?, clientid=?, email=? WHERE uid=? ::uuid;";
        jdbcCon.update(sql, password, name, clientId, email, uid);
    }

    @Override
    public void deleteUser(String uid) throws SQLException {
        String sql = "DELETE FROM public.users WHERE  uid=? :: uuid;";
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

        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        String sql = "BEGIN; DELETE FROM public.users WHERE  uid=? ::text;";

        for(String pageId: pageIds){
            sql += "INSERT INTO public.\"pages-uid\"( uid, pageid) VALUES (" + userId + "::uuid, " + pageId + ");";
        }
        sql += "COMMIT;";

        jdbcCon.update(sql, userId);
        transactionManager.commit(status);
    }

    @Override
    public List<Map<String, Object>> pagesAssignation() throws SQLException {
        return jdbcCon.queryForList("select * from from public.\"pages-uid\"");
    }
    
     
}
