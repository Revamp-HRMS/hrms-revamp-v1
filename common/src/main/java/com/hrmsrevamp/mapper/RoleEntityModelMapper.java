package com.hrmsrevamp.mapper;
import com.hrmsrevamp.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Role Entity to Model Mapper.
 */
@Mapper
public interface RoleEntityModelMapper {
  com.hrmsrevamp.model.Role roleEntityToModel(Role role);

  Role roleModelToEntity(com.hrmsrevamp.model.Role role);

  List<com.hrmsrevamp.model.Role> listRoleEntityToModel(List<Role> roleList);

  List<Role> listRoleModelToEntity(List<com.hrmsrevamp.model.Role> roles);
}
