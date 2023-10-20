package postgrescrud.crud.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import postgrescrud.crud.dao.UserDao;



@Service
public class UserService implements UserDao {
    
    @Autowired
    private final JdbcTemplate jdbcCon;


    public UserService(JdbcTemplate jdbcCon) {
        this.jdbcCon = jdbcCon;
    }


    @Override
    public List<Map<String, Object>> getMenu(String uid) {
        return jdbcCon.queryForList("select uid, up.pageid , pagelabel from (SELECT us.uid , pageid FROM public.users as us left join public.\"pages-uid\" as pui on pui.uid::uuid = us.uid where us.uid = ?::uuid) as up left join public.pages pg on up.pageid = pg.pageid where structure is not null;" , uid);
    //  return jdbcCon.queryForList("SELECT * FROM public.components;");
    }


    @Override
    public List<Map<String, Object>> getPage(String pageId) {
         return jdbcCon.queryForList("select pageid , pagelabel , structure from public.pages pg where pageid = ?", pageId);
    }


    @Override
    public List<Map<String, Object>> getComp(String compId) {
         return jdbcCon.queryForList("SELECT page_id, component_id, component_label, data, component_styles FROM public.components where component_id = ?;", compId);
    }

    

   
}
