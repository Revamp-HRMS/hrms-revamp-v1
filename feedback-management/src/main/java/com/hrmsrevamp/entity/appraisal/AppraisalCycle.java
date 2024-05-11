package com.hrmsrevamp.entity.appraisal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@Entity
public class AppraisalCycle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  private Long userId;
  private String name;
  private String employeeCode;
  private String designation;
  private String reportingManager;
  private String reviewingManager;
  private Date appraisalCycle; //1 March 2024 // 2024-04-10
  private String status;
}
