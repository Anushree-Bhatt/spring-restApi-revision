package com.practice.springboot.my_rest_api.surveyQuestionnaire.pojo;

import java.util.List;

public class Question {
    private Integer id;
    private String description;
    private List<String> options;
    private String answer;

    public Question() {
    }

    public Question(Integer id, String description, List<String> options, String answer){
        this.id = id;
        this.description = description;
        this.options = options;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", options=" + options +
                ", answer='" + answer + '\'' +
                '}';
    }
}
