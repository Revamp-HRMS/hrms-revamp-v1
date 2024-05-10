package com.hrmsrevamp.controller;

import com.hrmsrevamp.model.CustomResponse;
import com.hrmsrevamp.model.ResetPasswordRequest;
import com.hrmsrevamp.model.SignInRequest;
import com.hrmsrevamp.model.SignUpRequest;
import com.hrmsrevamp.service.AuthService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Auth controller for auth apis.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {
  @Autowired
  private AuthService authService;


  private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

  @GetMapping("/ping")
  public ResponseEntity<String> helloFromLittlePinger() {
    return new ResponseEntity<>("Hello from little pinger..!", HttpStatus.OK);
  }

  /**
   * To SignUp Admin.
   *
   * @param request - SignInRequest Model
   * @return customResponse - contained admin token.
   */
  @PostMapping("/signup")
  public ResponseEntity<CustomResponse> adminSignup(@RequestBody SignUpRequest request) {
    long startTime = System.currentTimeMillis();
    CustomResponse customResponse = authService.adminSignup(request);
    long endTime = System.currentTimeMillis();
    LOGGER.debug("Time taken to signUp admin: {} Millis", (endTime - startTime));
    return new ResponseEntity<>(customResponse, HttpStatus.OK);
  }

  /**
   * To SignIn Admin.
   *
   * @param request - SignInRequest Model
   * @return customResponse - contained admin token.
   */
  @PostMapping("/signin")
  public ResponseEntity<CustomResponse> signIn(@RequestBody SignInRequest request) {
    long startTime = System.currentTimeMillis();
    CustomResponse customResponse = authService.signIn(request);
    long endTime = System.currentTimeMillis();
    LOGGER.debug("Time taken to signIn admin: {} Millis", (endTime - startTime));
    return new ResponseEntity<>(customResponse, HttpStatus.OK);
  }

  /**
   * To Reset Admin password.
   *
   * @param resetPwdRequest - ResetPasswordRequest Model
   * @return customResponse - contained message.
   */
  @PostMapping("/password")
  public ResponseEntity<CustomResponse> resetAdminPassword(@Valid @RequestBody ResetPasswordRequest resetPwdRequest) {
    long startTime = System.currentTimeMillis();
    CustomResponse customResponse = authService.resetAdminPassword(resetPwdRequest);
    long endTime = System.currentTimeMillis();
    LOGGER.debug("Time taken to reset password: {} Millis", (endTime - startTime));
    return new ResponseEntity<>(customResponse, HttpStatus.OK);
  }

  /**
   * To check if User is exists or not in db.
   *
   * @param email - user email.
   * @return customResponse - contained message.
   */
  @GetMapping("/exists")
  public ResponseEntity<CustomResponse> checkUserExistsOrNot(@RequestParam(value = "email") String email) {
    long startTime = System.currentTimeMillis();
    CustomResponse customResponse = authService.checkUserExistsOrNot(email);
    long endTime = System.currentTimeMillis();
    LOGGER.debug("Time taken to check user exists or not by email: {} Millis", (endTime - startTime));
    return new ResponseEntity<>(customResponse, HttpStatus.OK);
  }

  /**
   * Refreshes the user's authentication token.
   *
   * @param request - the sign-in request containing user information.
   * @return customResponse - a response containing the result of the token refresh operation.
   */
  @PostMapping("/refreshToken")
  public ResponseEntity<CustomResponse> refreshToken(@RequestBody SignInRequest request) {
    long startTime = System.currentTimeMillis();
    CustomResponse customResponse = authService.refreshTokenForUser(request);
    long endTime = System.currentTimeMillis();
    LOGGER.debug("Time taken to refresh token: {} Millis", (endTime - startTime));
    return new ResponseEntity<>(customResponse, HttpStatus.OK);
  }

  @PostMapping("/log-out")
  public ResponseEntity<CustomResponse> userLogOutActivity(@RequestParam("userId") Long userId) {
    long startTime = System.currentTimeMillis();
    CustomResponse customResponse = authService.storeUserLogOutActivity(userId);
    long endTime = System.currentTimeMillis();
    LOGGER.debug("Time taken to add user activity: {} Millis", (endTime - startTime));
    return new ResponseEntity<>(customResponse, HttpStatus.OK);
  }

}
