package com.bruno.galaxy.period.infrastructure.entities;

import com.bruno.galaxy.period.domain.model.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="periods")  // Nombre de la tabla en la base de datos
public class PeriodEntity {


    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id
    @GeneratedValue Long id;
    private Integer startDate;
    private Integer finishDate;
    private String wheaterCondition;


    public PeriodEntity() {
    }

    

    public PeriodEntity(Long id, Integer startDate, Integer finishDate, String wheaterCondition) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.wheaterCondition = wheaterCondition;
        
    }

    public static PeriodEntity fromDomainModel(Period period) {
        return new PeriodEntity(period.getId(), period.getStartDate(), period.getFinishDate(), period.getWheaterCondition());
    }

    public Period toDomainModel() {
        return new Period(id, startDate, finishDate, wheaterCondition);
    }

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
