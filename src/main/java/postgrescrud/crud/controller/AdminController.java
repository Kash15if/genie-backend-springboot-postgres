package postgrescrud.crud.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
   public ResponseEntity<String> createPage(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
        adminDao.createPage((String) body.get("pageId"), (String) body.get("pageLabel"), (String) body.get("structure"));
        return ResponseEntity.ok("Data inserted successfully");
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }


   
    @PostMapping(value="update-pagestructure")
   public ResponseEntity<String> updatePage(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
      adminDao.updatePage((String) body.get("pageId"), (String) body.get("pageLabel"), (String) body.get("structure"));
        return ResponseEntity.ok("Data updated successfully");
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

    @PostMapping(value="delete-page")
   public ResponseEntity<String> deletePage(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
          adminDao.deletePage((String) body.get("pageId"));
    return ResponseEntity.ok("Data deleted successfully");
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

    @PostMapping(value="update-component")
   public ResponseEntity<String> updateComponent(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
        adminDao.updateComponent((String) body.get("pageId"), (String) body.get("componentId"), (String) body.get("compLabel"),(String) body.get("data"), (String) body.get("compStyles"));
    return ResponseEntity.ok("Data updated successfully");
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

    @PostMapping(value="delete-component")
   public ResponseEntity<String> deleteComponent(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
     adminDao.deleteComponent((String) body.get("pageId"), (String) body.get("componentId"));
    return ResponseEntity.ok("Data deleted successfully");
  
}
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }



    @PostMapping(value="create-user")
   public ResponseEntity<String> createUser(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
        adminDao.createUser((String) body.get("uid"), (String) body.get("password"), (String) body.get("name"),(String) body.get("clientid"), (String) body.get("email"));
    return ResponseEntity.ok("User Created successfully");
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

   
    @PostMapping(value="update-user")
   public ResponseEntity<String> updateUser(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
    adminDao.updateUser((String) body.get("uid"), (String) body.get("password"), (String) body.get("name"),(String) body.get("clientid"), (String) body.get("email"));
 
    return ResponseEntity.ok("User Updated successfully");
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }


   
    @PostMapping(value="delete-user")
   public ResponseEntity<String> deleteUser(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);    
        adminDao.deleteUser((String) body.get("uid"));
 
    return ResponseEntity.ok("User Deleted successfully");
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }


   
    @GetMapping(value="users")
   public List<Map<String, Object>> getUsers() {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
       return adminDao.getUsers();
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

   @GetMapping(value="pages")
   public List<Map<String, Object>> getPages(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
       return adminDao.getPages();
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }


   @PostMapping(value="delete-assign-pages")
   public ResponseEntity<String> deleteAssignPages(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);

    adminDao.deletessignPages((String) body.get("uid"));
 
    return ResponseEntity.ok("Pages assigned successfully");
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }


   
   @PostMapping(value="assign-pages")
   public ResponseEntity<String> assignPages(@RequestBody Map<String, Object>  body) {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);

        String pages = (String) body.get("pages");
        System.out.println(pages);
        String[] tempArrayPages = new String[0];

        if (pages != null && pages != "") {
            tempArrayPages = pages.split(", ");

            // Trim leading and trailing whitespace from each element
            for (int i = 0; i < tempArrayPages.length; i++) {
                tempArrayPages[i] = tempArrayPages[i].trim();
            }
        }
    adminDao.assignPages((String) body.get("uid"), tempArrayPages);
 
    return ResponseEntity.ok("Pages assigned successfully");
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

   
   @GetMapping(value="assign-pages-table")
   public List<Map<String, Object>> pagesAssignation() {

        try{  
    // String token = authorizationHeader.substring("Bearer ".length());
        // String uid = security.validateToken(token);
       return adminDao.pagesAssignation();
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return null;
   }

}
