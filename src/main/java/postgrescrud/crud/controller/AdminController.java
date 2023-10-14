package postgrescrud.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import postgrescrud.crud.dao.AdminDao;
import postgrescrud.crud.dao.UserDao;
import postgrescrud.crud.security.Security;



@RestController
@RequestMapping("/sa/")
public class AdminController {
    

    
     @Autowired
    private AdminDao adminDao;

    // @Autowired
    private Security security = new Security();

    
    
   @PostMapping(value="createpage")
   public Map<String, String> createPage(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
    //    return userDao.getMenu(uid);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }


   
    @PostMapping(value="update-pagestructure")
   public Map<String, String> updatePage(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
    //    return userDao.getMenu(uid);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

    @PostMapping(value="delete-page")
   public Map<String, String> deletePage(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
    //    return userDao.getMenu(uid);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

    @PostMapping(value="update-component")
   public Map<String, String> updateComponent(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
    //    return userDao.getMenu(uid);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

    @PostMapping(value="delete-component")
   public Map<String, String> deleteComponent(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
    //    return userDao.getMenu(uid);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }



    @PostMapping(value="create-user")
   public Map<String, String> createUser(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
    //    return userDao.getMenu(uid);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

   
    @PostMapping(value="update-user")
   public Map<String, String> updateUser(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
    //    return userDao.getMenu(uid);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }


   
    @PostMapping(value="delete-user")
   public Map<String, String> deleteUser(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
    //    return userDao.getMenu(uid);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }


   
    @GetMapping(value="users")
   public Map<String, String> getUsers(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
    //    return userDao.getMenu(uid);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

   @GetMapping(value="pages")
   public Map<String, String> getPages(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
    //    return userDao.getMenu(uid);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

   
   @PostMapping(value="assign-pages")
   public Map<String, String> assignPages(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
    //    return userDao.getMenu(uid);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

   
   @GetMapping(value="assign-pages-table")
   public Map<String, String> pagesAssignation(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
    //    return userDao.getMenu(uid);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

}
