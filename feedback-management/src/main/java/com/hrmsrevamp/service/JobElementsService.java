package com.hrmsrevamp.service;

import com.hrmsrevamp.model.CustomResponse;
import com.hrmsrevamp.model.JobElementsModel;

public interface JobElementsService {
    CustomResponse addJobElements(JobElementsModel jobElementsModel);

    CustomResponse getJobElementsById(Long jobElementsModel);

    CustomResponse updateJobElementsById(Long jobElementsId, JobElementsModel jobElementsModel);
}
