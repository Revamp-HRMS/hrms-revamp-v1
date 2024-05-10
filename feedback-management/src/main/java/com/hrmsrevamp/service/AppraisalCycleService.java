package com.hrmsrevamp.service;


import com.hrmsrevamp.model.AppraisalCycleModel;
import com.hrmsrevamp.model.CustomResponse;

public interface AppraisalCycleService {

  CustomResponse addAppraisalCycle(AppraisalCycleModel appraisalCycleModel);


  CustomResponse updateAppraisalCycle(AppraisalCycleModel appraisalCycleModel);

  CustomResponse getAppraisalCycleByUserId(Long userId);
}
