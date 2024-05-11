package com.hrmsrevamp.services;

import org.springframework.stereotype.Service;
@Service
public interface UserService {

  com.hrmsrevamp.model.CustomResponse getAllUser(String role);
}
