package com.hrmsrevamp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

/**
 * Role entity.
 */
@Builder
@Entity
@Table(name = "role")
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
  @SequenceGenerator(name = "ROLE_SEQ", sequenceName = "ROLE_SEQ", initialValue = 1, allocationSize = 1)
  private Long id;

  private String name;
  @ManyToMany(mappedBy = "roles")
  private Collection<User> users;

  @ManyToMany
  @JoinTable(
          name = "roles_privileges",
          joinColumns = @JoinColumn(
                  name = "role_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(
                  name = "privilege_id", referencedColumnName = "id"))
  private Collection<Privilege> privileges;
}
