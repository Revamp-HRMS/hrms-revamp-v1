package com.hrmsrevamp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * User Role.
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
  private Long id;
  private String name;
  private List<Privilege> privileges;
  private String status;
  private String createdBy;
  private String updatedBy;
  private String createdOn;
  private String updatedOn;
}
