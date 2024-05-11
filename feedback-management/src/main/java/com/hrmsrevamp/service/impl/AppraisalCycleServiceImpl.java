package com.hrmsrevamp.service.impl;

import com.hrmsrevamp.constants.MessageEnum;
import com.hrmsrevamp.entity.appraisal.AppraisalCycle;
import com.hrmsrevamp.model.AppraisalCycleModel;
import com.hrmsrevamp.model.CustomResponse;
import com.hrmsrevamp.repository.AppraisalCycleRepository;
import com.hrmsrevamp.service.AppraisalCycleService;
import java.util.Optional;
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
    AppraisalCycle cycleModel = new AppraisalCycle();
    cycleModel.setUserId(appraisalCycleModel.getUserId());
    cycleModel.setName(appraisalCycleModel.getName());
    cycleModel.setEmployeeCode(appraisalCycleModel.getEmployeeCode());
    cycleModel.setDesignation(appraisalCycleModel.getDesignation());
    cycleModel.setReportingManager(appraisalCycleModel.getReportingManager());
    cycleModel.setReviewingManager(appraisalCycleModel.getReviewingManager());
    cycleModel.setAppraisalCycle(appraisalCycleModel.getAppraisalCycle());
    cycleModel.setStatus(appraisalCycleModel.getStatus());

    AppraisalCycle savedAppraisalCycle = appraisalCycleRepository.save(cycleModel);
    return CustomResponse.setAndGetCustomResponse(true, MessageEnum.NEW_DATA_STORED.name(), savedAppraisalCycle);
  }

  @Override
  public CustomResponse updateAppraisalCycle(Long appraisalId, AppraisalCycleModel appraisalCycleModel) {

    Optional<AppraisalCycle> optional = appraisalCycleRepository.findById(appraisalId);
    AppraisalCycle existingAppraisalCycle = optional.get();
    existingAppraisalCycle.setUserId(appraisalCycleModel.getUserId());
    existingAppraisalCycle.setName(appraisalCycleModel.getName());
    existingAppraisalCycle.setEmployeeCode(appraisalCycleModel.getEmployeeCode());
    existingAppraisalCycle.setDesignation(appraisalCycleModel.getDesignation());
    existingAppraisalCycle.setReportingManager(appraisalCycleModel.getReportingManager());
    existingAppraisalCycle.setReviewingManager(appraisalCycleModel.getReviewingManager());
    existingAppraisalCycle.setAppraisalCycle(appraisalCycleModel.getAppraisalCycle());
    existingAppraisalCycle.setStatus(appraisalCycleModel.getStatus());

    AppraisalCycle savedAppraisalCycle = appraisalCycleRepository.save(existingAppraisalCycle);
    return CustomResponse.setAndGetCustomResponse(true, MessageEnum.UPDATED.name(), savedAppraisalCycle);
  }

  @Override
  public CustomResponse getAppraisalCycleByUserId(Long userId) {
    List<AppraisalCycle> appraisalCycleModelList = appraisalCycleRepository.findByUserId(userId);
    if (!appraisalCycleModelList.isEmpty())
      return CustomResponse.setAndGetCustomResponse(true, MessageEnum.APPRAISAL_CYCLE_LIST.name(), appraisalCycleModelList);
    return CustomResponse.setAndGetCustomResponse(false, MessageEnum.NOT_FOUND.name(), null);
  }

}
