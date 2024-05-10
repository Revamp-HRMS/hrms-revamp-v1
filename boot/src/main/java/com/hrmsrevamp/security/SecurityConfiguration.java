package com.hrmsrevamp.security;

import com.lp.auth.service.impl.UserDetailsServiceImpl;
import com.lp.common.constants.RoleEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

/**
 * Security Configuration.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  @Bean
  public JwtAuthenticationFilter jwtAuthenticationFilter() {
    return new JwtAuthenticationFilter();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public ApiAuthEntryPoint unauthorizedHandler() {
    return new ApiAuthEntryPoint();
  }

  @Bean
  public UserDetailsServiceImpl userDetailsService() {
    return new UserDetailsServiceImpl();
  }

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
          throws Exception {
    return config.getAuthenticationManager();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(request -> request
                    .requestMatchers(HttpMethod.GET, "/ws-endpoint/**")
                    .permitAll()
                    /* use-auth APIs */
                    .requestMatchers(HttpMethod.GET, "/api/auth/**").permitAll()

                    .requestMatchers(HttpMethod.POST, "/api/auth/**").permitAll()

                    .requestMatchers(HttpMethod.POST, "/api/auth/password")
                    .hasAuthority(RoleEnum.ADMIN.name())

                    /* user APIs */
                    .requestMatchers(HttpMethod.GET, "/api/user/userId")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.GET, "/api/user/all")
                    .hasAnyAuthority(RoleEnum.ADMIN.name())

                    .requestMatchers(HttpMethod.GET, "/api/user/uid")
                    .hasAuthority(RoleEnum.ADMIN.name())

                    .requestMatchers(HttpMethod.PUT, "/api/user/{userId}")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.DELETE, "/api/user/userId")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.PUT, "/api/user/status")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.PUT, "/api/user/role")
                    .hasAnyAuthority(RoleEnum.ADMIN.name())

                    .requestMatchers(HttpMethod.GET, "/api/user/dashboard/counts")
                    .hasAnyAuthority(RoleEnum.ADMIN.name())

                    .requestMatchers(HttpMethod.GET, "/api/user/status")
                    .permitAll()

                    /* device APIs */
                    .requestMatchers(HttpMethod.GET, "/api/device")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.GET, "/api/device/all")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.GET, "/api/device/all/v1")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.GET, "/api/device/keys")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.GET, "/api/device/summary")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.GET, "/api/device/csv")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.GET, "/api/device/dashboard/counts")
                    .hasAnyAuthority(RoleEnum.ADMIN.name())

                    .requestMatchers(HttpMethod.GET, "/api/device/dashboard/user-device-counts")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.POST, "/api/device/notification")
                    .permitAll()

                    .requestMatchers(HttpMethod.POST, "/api/device")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.PUT, "/api/device/{userDeviceId}")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.PUT, "/api/device/status")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.PUT, "/api/device/cradlepoint/not-found")
                    .permitAll()

                    .requestMatchers(HttpMethod.DELETE, "/api/device/**")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    /* user audit APIs */
                    .requestMatchers(HttpMethod.GET, "/api/user-audit/**")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.POST, "/api/user-audit/**")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())


                    /* Stripe APIs */
                    .requestMatchers(HttpMethod.GET, "/api/stripe/products/**")
                    .permitAll()

                    .requestMatchers(HttpMethod.GET, "/api/stripe/invoice/**")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.POST, "/api/stripe/subscription/**")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.GET, "/api/stripe/subscription/**")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.PUT, "/api/stripe/subscription/**")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    .requestMatchers(HttpMethod.POST, "/api/stripe/session/**")
                    .hasAnyAuthority(RoleEnum.ADMIN.name(), RoleEnum.USER.name())

                    /* Notification APIs */
                    .requestMatchers(HttpMethod.POST, "/api/notification/new-signup")
                    .hasAnyAuthority(RoleEnum.USER.name())

                    .anyRequest().authenticated())
            .sessionManagement(manager -> manager.sessionCreationPolicy(STATELESS))
            .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(unauthorizedHandler()))
            .authenticationProvider(daoAuthenticationProvider()).addFilterBefore(
                    jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}
