package postgrescrud.crud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/test")
@Repository
public class TestApi {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
     @GetMapping("/d")
    public List<Map<String, Object>> getDynamicData() {
        // List<User> resultList = userDao.getUserDetailForLogin(2);

        String sql = "SELECT * FROM UserDetails";

        return jdbcTemplate.queryForList(sql);

        //   List<User> customers = jdbcTemplate.query(sql,
        //         BeanPropertyRowMapper.newInstance(User.class));
         
        // customers.forEach(System.out :: println);
        // return customers;
    }


}
