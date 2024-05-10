package com.hrmsrevamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobKnowledge extends JpaRepository<JobKnowledge, Long> {
}
