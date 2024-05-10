package com.hrmsrevamp.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class HrmsRevampDataLoader implements ApplicationRunner {
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;
  @Autowired
  private PrivilegeRepository privilegeRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Privilege readPrivilege = createPrivilegeIfNotFound("FULL_READ_PRIVILEGE");
    Privilege writePrivilege = createPrivilegeIfNotFound("FULL_WRITE_PRIVILEGE");
    Privilege partReadPrivilege = createPrivilegeIfNotFound("PART_READ_PRIVILEGE");
    Privilege partWritePrivilege = createPrivilegeIfNotFound("PART_WRITE_PRIVILEGE");
    List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
    List<Privilege> userPrivileges = Arrays.asList(partReadPrivilege, partWritePrivilege);
    addRole("ADMIN", adminPrivileges);
    addRole("USER", userPrivileges);
  }

  private Privilege createPrivilegeIfNotFound(String name) {
    Privilege privilege = privilegeRepository.findByName(name);
    if (privilege == null) {
      privilege = Privilege.builder().name(name).build();
      privilege = privilegeRepository.save(privilege);
    }
    return privilege;
  }

  private Role addRole(String name, List<Privilege> privileges) {
    Role role = roleRepository.findByName(name);
    if (role == null) {
      role = roleRepository.save(Role.builder()
              .name(name)
              .privileges(privileges).build());
    }
    return role;
  }

}