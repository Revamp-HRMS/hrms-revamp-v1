package com.hrmsrevamp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * User Model.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
  private Long userId;
  private String email;
  private String mobileNumber;
  private String fullName;
  private List<String> roles;
  private String status;
  private String createdOn;
  private Long createdBy;
  private String updatedOn;
  private Long updatedBy;
  private Boolean userRegistered;
  private String updatedToken;
}
