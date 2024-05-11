package com.hrmsrevamp.service.impl;

import com.hrmsrevamp.entity.User;
import com.hrmsrevamp.model.CustomResponse;
import com.hrmsrevamp.model.JobElementsModel;
import com.hrmsrevamp.service.JobElementsService;
import org.springframework.stereotype.Service;

@Service
public class JobElementsServiceImpl implements JobElementsService {

    @Override
    public CustomResponse getJobElementsById(Long jobElementsModel) {
        return null;
    }

    @Override
    public CustomResponse addJobElements(JobElementsModel jobElementsModel) {
        User loggedInUser = LoggedInUser.getCurrentUser();
        String role = loggedInUser.getRole();
        //switch (loggedInUser);
        return null;
    }

    @Override
    public CustomResponse updateJobElementsById(Long jobElementsId, JobElementsModel jobElementsModel) {
        return null;
    }
}
