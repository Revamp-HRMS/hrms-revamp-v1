package com.hrmsrevamp.controller;


import com.hrmsrevamp.model.AppraisalCycleModel;
import com.hrmsrevamp.model.CustomResponse;
import com.hrmsrevamp.service.AppraisalCycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class AppraisalCycleController {

  @Autowired
  private AppraisalCycleService appraisalCycleService;

  public ResponseEntity<CustomResponse> addAppraisalCycle(@RequestBody AppraisalCycleModel appraisalCycleModel) {
    CustomResponse customResponse = appraisalCycleService.addAppraisalCycle(appraisalCycleModel);
  }
}
