package com.practice.springboot.my_rest_api.surveyQuestionnaire.controller;

import com.practice.springboot.my_rest_api.surveyQuestionnaire.pojo.Survey;
import com.practice.springboot.my_rest_api.surveyQuestionnaire.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @RequestMapping("/surveys")
    public List<Survey> getAllSurveys(){
        return surveyService.getSurveys();
    }

}
