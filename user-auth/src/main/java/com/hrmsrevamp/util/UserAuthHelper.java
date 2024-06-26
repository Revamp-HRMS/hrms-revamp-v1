package com.hrmsrevamp.util;

import com.hrmsrevamp.entity.User;
import com.hrmsrevamp.repository.RoleRepository;
import com.hrmsrevamp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * UserAuthHelper.
 */

@Component
public class UserAuthHelper {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;

  private static final Logger LOGGER = LoggerFactory.getLogger(UserAuthHelper.class);


}
