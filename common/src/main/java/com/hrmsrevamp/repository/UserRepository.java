package com.hrmsrevamp.repository;

import com.hrmsrevamp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * User Repository.
 */

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {
  Optional<User> findByEmailAndStatusNot(String email, String status);


  Optional<User> findByUserId(Long userId);

  Boolean existsByEmail(String email);

  Page<User> findByStatusIn(List<String> statuses, Pageable userPage);


  Optional<User> findByEmailAndStatusIn(String email, List<String> list);

  List<User> findByUserIdInAndStatus(List<Long> userId, String status);

  User findByUserIdAndStatus(Long userId, String status);
}
