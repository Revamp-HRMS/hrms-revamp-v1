package com.hrmsrevamp.entity.jobElements;

import com.hrmsrevamp.entity.RatingAndComments;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JobKnowledge {

  private Long id;
  private Long userId;
  @OneToOne
  private RatingAndComments ratingAndComments;
}
