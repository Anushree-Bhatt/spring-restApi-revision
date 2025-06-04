package com.practice.springboot.my_rest_api.surveyQuestionnaire.service;

import com.practice.springboot.my_rest_api.surveyQuestionnaire.pojo.Question;
import com.practice.springboot.my_rest_api.surveyQuestionnaire.pojo.Survey;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {
    private static List<Survey> surveys = new ArrayList<>();

    static {
        Question q1 = new Question(1, "Most popular cloud platform today", Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        Question q2 = new Question(2, "Fastest growing Cloud platform", Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Azure");
        Question q3 = new Question(3, "Most popular devops tool", Arrays.asList("Docker", "Kubernates", "Terraform", "Azure Devops"), "Docker");

        Survey s1 = new Survey(1, "Survey 1", "Survey on Cloud", Arrays.asList(q1, q2));
        Survey s2 = new Survey(2, "Survey 2", "Survey on DevOps", Arrays.asList(q3));

        surveys.add(s1);
        surveys.add(s2);
    }

    public List<Survey> retrieveAllSurveys(){
        return  surveys;
    }

    public Survey retrieveSurvey(Integer id) {
        Optional<Survey> res = surveys.stream().filter(survey -> survey.getId().equals(id)).findFirst();

        if(res.isEmpty()){
            System.out.println("************** Survey id - "+id+" does not exist");
            return null;
        }

        return res.get();
    }

    public List<Question> retrieveAllQuestions(Integer id) {
        Survey s = retrieveSurvey(id);

        if (s == null){
            System.out.println("************** Survey id - "+id+" does not exist");
            return null;
        }

        return s.getQuestions();
    }


    public Question retieveSurveyQuestion(Integer surveyId, Integer questionId) {
        List<Question> questions = retrieveAllQuestions(surveyId);

        if (questions == null){
            return null;
        }

        Optional<Question> optionalQuestion = questions.stream().filter(question -> question.getId().equals(questionId)).findFirst();

        if (optionalQuestion.isEmpty()){
            System.out.println("******************* Question id does not exist");
            return null;
        }

        return optionalQuestion.get();
    }
}
