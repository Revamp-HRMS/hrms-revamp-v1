package controller;

import com.hrmsrevamp.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/api/user")
public class UserController {

  @org.springframework.beans.factory.annotation.Autowired private services.UserService userService;

  @org.springframework.web.bind.annotation.GetMapping("/{role}")
  public org.springframework.http.ResponseEntity<java.util.List<User>> getAllUser(@org.springframework.web.bind.annotation.PathVariable String role){
     return org.springframework.http.ResponseEntity.ok(userService.getAllUser(role));
  }
}
