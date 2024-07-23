package com.bruno.galaxy.period.infrastructure.repositories;

import com.bruno.galaxy.period.infrastructure.entities.PeriodEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPeriodRepository extends JpaRepository<PeriodEntity, Long> {
    List<PeriodEntity> findByWheaterCondition(String wheaterCondition);
}
