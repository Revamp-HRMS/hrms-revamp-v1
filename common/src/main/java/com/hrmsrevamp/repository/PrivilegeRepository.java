package com.hrmsrevamp.repository;
import com.lp.common.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PrivilegeRepository.
 */

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
  Privilege findByName(String name);
}
