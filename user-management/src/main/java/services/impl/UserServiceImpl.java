package services.impl;

import com.hrmsrevamp.entity.User;
import com.hrmsrevamp.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import services.UserService;

public class UserServiceImpl implements services.UserService {

  @org.springframework.beans.factory.annotation.Autowired
  private UserRepository userRepository;

  @Override
  public java.util.List<User> getAllUser(String role) {
    return userRepository.findAll();
  }
}
