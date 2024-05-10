package com.hrmsrevamp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * SignInRequest model.
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {
  private String email;
  private String password;
  private String uid;
  private String idToken;
  private String refreshToken;
}
