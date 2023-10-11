package postgrescrud.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import postgrescrud.crud.dao.UserDao;
import postgrescrud.crud.security.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user/")
public class UserController {

     @Autowired
    private UserDao userDao;

    // @Autowired
    private Security security = new Security();



       //3 apis for users, page and components
   @PostMapping(value="login")
   public Map<String, String> login(@RequestBody Map<String, Object>  body) {

        Map<String, String> map = new HashMap<String,String>();
        map.put("uid" , (String) body.get("uid"));
    try {
            String token = security.generateToken((String) body.get("uid"));
            map.put("token" , token);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
       return map;
   }


   //3 apis for users, page and components
   @GetMapping(value="menu")
   public List<Map<String, Object>> getMenu( @RequestHeader("Authorization") String authorizationHeader) {
    

    try{  
    String token = authorizationHeader.substring("Bearer ".length());
        String uid = security.validateToken(token);
       return userDao.getMenu(uid);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

   @GetMapping(value="page")
   public List<Map<String, Object>> getPage(@RequestHeader("Authorization") String authorizationHeader,@RequestParam String pageId) {
    // System.out.println("Page called");
    try{
        String token = authorizationHeader.substring("Bearer ".length());
         String uid = security.validateToken(token);
       return userDao.getPage(pageId);
   
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

   @GetMapping(value="componentdata")
   public List<Map<String, Object>> getComponent(@RequestHeader("Authorization") String authorizationHeader, @RequestParam String compId) {
System.out.println("componentdata called");
    try{ 
        String token = authorizationHeader.substring("Bearer ".length());
         String uid = security.validateToken(token);
       return userDao.getComp(compId);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }
   


}
