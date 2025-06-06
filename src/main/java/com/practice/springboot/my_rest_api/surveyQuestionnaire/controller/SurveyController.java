package com.practice.springboot.my_rest_api.surveyQuestionnaire.controller;

import com.practice.springboot.my_rest_api.surveyQuestionnaire.pojo.Question;
import com.practice.springboot.my_rest_api.surveyQuestionnaire.pojo.Survey;
import com.practice.springboot.my_rest_api.surveyQuestionnaire.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @RequestMapping("/surveys/{id}/questions")
    public List<Question> getAllQuestions(@PathVariable Integer id){
        List<Question> questions = surveyService.retrieveAllQuestions(id);

        if (questions == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey Not Found!");
        }

        return questions;
    }

    @RequestMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question getQuestion(@PathVariable Integer surveyId, @PathVariable Integer questionId){
        Question question = surveyService.retrieveSurveyQuestion(surveyId, questionId);

        if (question == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return question;

    }

    @RequestMapping(method = RequestMethod.POST, value = "/surveys/{surveyId}/questions")
    public ResponseEntity<Object> createQuestion(@RequestBody Question question, @PathVariable Integer surveyId){
        Integer questionId = surveyService.createSurveyQuestion(surveyId, question);

        if (questionId == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}").buildAndExpand(questionId).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/surveys/{surveyId}/questions/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer surveyId, @PathVariable Integer questionId){
        Boolean res = surveyService.deleteSurveyQuestion(surveyId, questionId);

        if (!res){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/surveys/{surveyId}/questions/{questionId}")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question, @PathVariable Integer surveyId, @PathVariable Integer questionId){
        Boolean res = surveyService.updateSurveyQuestion(question, surveyId, questionId);

        if (!res){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(httpHeaders -> {httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().build().toUri());}).build();
    }


}
