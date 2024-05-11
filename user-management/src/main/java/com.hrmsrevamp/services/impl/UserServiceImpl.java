package com.hrmsrevamp.services.impl;

import com.hrmsrevamp.entity.User;
import com.hrmsrevamp.repository.UserRepository;
import java.util.List;

import com.hrmsrevamp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getAllUser(String role) {
    return userRepository.findAll();
  }
}
