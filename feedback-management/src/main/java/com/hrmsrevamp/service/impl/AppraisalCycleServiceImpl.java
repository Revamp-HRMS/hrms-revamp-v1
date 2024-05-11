package com.hrmsrevamp.service.impl;

import com.hrmsrevamp.constants.MessageEnum;
import com.hrmsrevamp.model.AppraisalCycleModel;
import com.hrmsrevamp.model.CustomResponse;
import com.hrmsrevamp.repository.AppraisalCycleRepository;
import com.hrmsrevamp.service.AppraisalCycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppraisalCycleServiceImpl implements AppraisalCycleService {


  @Autowired
  private AppraisalCycleRepository appraisalCycleRepository;

  @Override
  public CustomResponse addAppraisalCycle(AppraisalCycleModel appraisalCycleModel) {
    return null;
  }


  @Override
  public CustomResponse updateAppraisalCycle(AppraisalCycleModel appraisalCycleModel) {
    return null;
  }

  @Override
  public CustomResponse getAppraisalCycleByUserId(Long userId) {

    List<AppraisalCycleModel> appraisalCycleModelsList = new ArrayList<>();
    return CustomResponse.setAndGetCustomResponse(true, MessageEnum.APPRAISAL_CYCLE_LIST.name(), appraisalCycleModelsList);
  }
}
