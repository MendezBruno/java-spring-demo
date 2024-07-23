package com.bruno.galaxy.period.domain.model;

public class Period {

    private Long id;
    private Integer startDate;
    private Integer finishDate;
    private String wheaterCondition;

    public Period () {}

    public Period(Long id, Integer startDate, Integer finishDate, String wheaterCondition) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.wheaterCondition = wheaterCondition;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Integer finishDate) {
        this.finishDate = finishDate;
    }

    public String getWheaterCondition() {
        return wheaterCondition;
    }

    public void setWheaterCondition(String wheaterCondition) {
        this.wheaterCondition = wheaterCondition;
    }

   
}
