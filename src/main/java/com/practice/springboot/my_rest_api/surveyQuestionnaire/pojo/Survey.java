package com.practice.springboot.my_rest_api.surveyQuestionnaire.pojo;

import java.util.List;

public class Survey {
    private Integer id;
    private String title;
    private String description;
    List<Question> questions;

    public Survey(){}

    public Survey(Integer id, String title, String description, List<Question> questions){
        this.id = id;
        this.title = title;
        this.description = description;
        this.questions = questions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

//    public void setQuestions(List<Question> questions) {
//        this.questions = questions;
//    }

    public void addQuestion(Question question){
        System.out.println("Adding question");
        System.out.println(this.questions);
        this.questions.add(question);
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", questions=" + questions +
                '}';
    }
}
