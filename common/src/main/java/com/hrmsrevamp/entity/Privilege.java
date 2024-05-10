package com.hrmsrevamp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * Privilege entity.
 */

@Builder
@Entity
@Table(name = "privilege")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Privilege {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRIVILEGE_SEQ")
  @SequenceGenerator(name = "PRIVILEGE_SEQ", sequenceName = "PRIVILEGE_SEQ", initialValue = 1, allocationSize = 1)
  private Long id;

  private String name;

  @ManyToMany(mappedBy = "privileges")
  private Collection<Role> roles;
}
