package com.hrmsrevamp.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class AppraisalCycleModel {
  private Long Id;
  private Long userId;
  private String name;
  private String employeeCode;
  private String designation;
  private String deportingManager;
  private String reviewingManager;
  private String appraisalCycle; //1 March 2024 // 2024-04-10
  private String status;

}
