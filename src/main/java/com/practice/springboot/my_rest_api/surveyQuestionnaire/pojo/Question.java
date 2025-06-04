package com.practice.springboot.my_rest_api.surveyQuestionnaire.pojo;

import java.util.List;

public class Question {
    private Integer id;
    private String title;
    private String description;
    private List<String> options;
    private String answer;

    public Question() {
    }

    public Question(Integer id, String title, String description, List<String> options, String answer){
        this.id = id;
        this.title = title;
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

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", options=" + options +
                '}';
    }
}
