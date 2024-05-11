package com.hrmsrevamp.controller;


import com.hrmsrevamp.constants.MessageEnum;
import com.hrmsrevamp.model.AppraisalCycleModel;
import com.hrmsrevamp.model.CustomResponse;
import com.hrmsrevamp.service.AppraisalCycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appraisal")
public class AppraisalCycleController {

  @Autowired
  private AppraisalCycleService appraisalCycleService;

  @PostMapping("appraisal-cycle")
  public ResponseEntity<CustomResponse> addAppraisalCycle(@RequestBody AppraisalCycleModel appraisalCycleModel) {
    try {
      CustomResponse customResponse = appraisalCycleService.addAppraisalCycle(appraisalCycleModel);
      return ResponseEntity.ok(customResponse);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(CustomResponse.setAndGetCustomResponse(false, MessageEnum.DATABASE_ERROR.name(), null));
    }
  }

  @PutMapping("appraisal-cycle/{appraisalId}") //{appraisalId}
  public ResponseEntity<CustomResponse> updateAppraisalCycle(@PathVariable Long appraisalId, @RequestBody AppraisalCycleModel appraisalCycleModel) {
    try {
      CustomResponse customResponse = appraisalCycleService.updateAppraisalCycle(appraisalId, appraisalCycleModel);
      return ResponseEntity.ok(customResponse);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(CustomResponse.setAndGetCustomResponse(false, MessageEnum.DATABASE_ERROR.name(), null));
    }
  }

  @GetMapping("appraisal-cycle/{userId}")
  public ResponseEntity<CustomResponse> getAllAppriasalDetials(@PathVariable Long userId) {
    try {
      CustomResponse customResponse = appraisalCycleService.getAppraisalCycleByUserId(userId);
      return ResponseEntity.ok(customResponse);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(CustomResponse.setAndGetCustomResponse(false, MessageEnum.DATABASE_ERROR.name(), null));
    }
  }

}
