package com.hrmsrevamp.entity.jobElements;

import com.hrmsrevamp.entity.RatingAndComments;
import jakarta.persistence.OneToOne;

public class WorkQuality {
  private Long id;
  private String appraisalCycle;
  @OneToOne
  private RatingAndComments ratingAndComments;
}
