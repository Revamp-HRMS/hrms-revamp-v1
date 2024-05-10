package com.hrmsrevamp.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrmsrevamp.entity.Privilege;
import com.hrmsrevamp.entity.Role;
import com.hrmsrevamp.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * User Principal.
 */
public class UserPrincipal implements UserDetails {
  private User user;
  private String username;
  @JsonIgnore
  private String password;
  private Collection<? extends GrantedAuthority> authorities;

  public UserPrincipal(String password, User user,
                       Collection<? extends GrantedAuthority> authorities) {
    this.username = user.getEmail();
    this.password = password;
    this.authorities = authorities;
    this.user = user;
  }

  public static UserPrincipal create(User user) {
    return new UserPrincipal(user.getPassword(), user, getAuthorities(user.getRoles()));
  }

  private static Collection<? extends GrantedAuthority> getAuthorities(
          Collection<Role> roles) {
    return getGrantedAuthorities(getPrivileges(roles));
  }

  private static List<String> getPrivileges(Collection<Role> roles) {
    List<String> privileges = new ArrayList<>();
    List<Privilege> collection = new ArrayList<>();
    for (Role role : roles) {
      privileges.add(role.getName());
      collection.addAll(role.getPrivileges());
    }
    for (Privilege item : collection) {
      privileges.add(item.getName());
    }
    return privileges;
  }

  private static List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for (String privilege : privileges) {
      authorities.add(new SimpleGrantedAuthority(privilege));
    }
    return authorities;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public User getUser() {
    return user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserPrincipal that = (UserPrincipal) o;
    return Objects.equals(username, that.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username);
  }
}
