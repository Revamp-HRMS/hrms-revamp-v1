package com.hrmsrevamp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobElementsModel {

  private Long userId;
  private Long appraisalCycleId;
  private Long jobElementId;
  private String selfAssessment;
  private String projectLeader;
  private String mentor;
  private String employeeComments;
  private String projectManagerComments;
  private String MentorComments;
}
