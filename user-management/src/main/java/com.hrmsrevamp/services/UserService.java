package com.hrmsrevamp.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hrmsrevamp.entity.User;
@Service
public interface UserService {

  List<User> getAllUser(String role);
}
