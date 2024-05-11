package services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hrmsrevamp.entity.User;
@org.springframework.stereotype.Service
public interface UserService {

  java.util.List<User> getAllUser(String role);
}
