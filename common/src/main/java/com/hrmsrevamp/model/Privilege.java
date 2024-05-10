package com.hrmsrevamp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Privileges.
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Privilege {
  private Long id;
  private String name;
  private String status;
  private String createdBy;
  private String updatedBy;
  private String createdOn;
  private String updatedOn;
}
