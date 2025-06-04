package com.practice.springboot.my_rest_api.surveyQuestionnaire.controller;

import com.practice.springboot.my_rest_api.surveyQuestionnaire.pojo.Survey;
import com.practice.springboot.my_rest_api.surveyQuestionnaire.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @RequestMapping("/surveys")
    public List<Survey> getAllSurveys(){
        return surveyService.retrieveAllSurveys();
    }

    @RequestMapping("/surveys/{id}")
    public Survey getSurvey(@PathVariable Integer id){
        Survey survey = surveyService.retrieveSurvey(id);

        if (survey == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey Not Found!");

        return survey;
    }

}
