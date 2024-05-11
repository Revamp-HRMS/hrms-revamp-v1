package com.hrmsrevamp.repository;

import com.hrmsrevamp.entity.appraisal.AppraisalCycle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraisalCycleRepository extends JpaRepository<AppraisalCycle, Long> {
  List<AppraisalCycle> findByUserId(long userId);
}
