package com.hrmsrevamp.services.impl;

import com.hrmsrevamp.repository.UserRepository;
import com.hrmsrevamp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrmsrevamp.repository.RoleRepository;
import com.hrmsrevamp.model.CustomResponse;
import com.hrmsrevamp.constants.MessageEnum;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public CustomResponse getAllUser(String role) {
    java.util.List<com.hrmsrevamp.model.UserModel> userModels = userRepository.findByRoles_Name(role)
        .stream().map(user -> com.hrmsrevamp.model.UserModel.builder()
            .email(user.getEmail())
            .id(user.getId())
            .role(role)
            .fullName(user.getFullName()).build()).toList();

    return CustomResponse.setAndGetCustomResponse(true,
        String.valueOf(MessageEnum.DATA_RETRIEVED), userModels);
  }
}
