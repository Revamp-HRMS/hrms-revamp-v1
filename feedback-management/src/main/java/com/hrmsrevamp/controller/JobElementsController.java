package com.hrmsrevamp.controller;

import com.hrmsrevamp.entity.RatingAndComments;
import com.hrmsrevamp.entity.User;
import com.hrmsrevamp.model.CustomResponse;
import com.hrmsrevamp.model.JobElementsModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobElementsController {

  private

  @PostMapping("/add")
  public ResponseEntity<CustomResponse> addJobElements(@RequestBody JobElementsModel jobElementsModel) {

  }

  private CustomResponse addJobElements(JobElementsModel jobElementsModel) {
    User user = new User(); //loggedInUser()
    RatingAndComments ratingAndCommentsEntity = new RatingAndComments();
    if (user.getRole().equals("Employee")) {
      ratingAndCommentsEntity.setEmployeeComments(jobElementsModel.getEmployeeComments());
      ratingAndCommentsEntity.setSelfAssessment(jobElementsModel.getSelfAssessment());
    }
    if (jobElementsModel.getJobElementId().equals("workQuality")) {
      JobKnowledge jobKnowledge = new JobKnowledge();
      jobKnowledge.setUserId(jobElementsModel.getUserId());
      jobKnowledge.setRatingAndComments(ratingAndCommentsEntity);
    }
    JobElementsModel jobElementsModelResponse = new JobElementsModel();
    jobElementsModelResponse.setJobElementId(JobKnowledge.);
    CustomResponse.setAndGetCustomResponse(true, "jobElements added successfully", null)
  }

  private CustomResponse getJobElements(Long User, String jobElements) {
    if (jobElements.equals("workQuality")) {

    }
    findByUserIdAndJobElements(User, jobElements);
   //fetch from job
  }
}
