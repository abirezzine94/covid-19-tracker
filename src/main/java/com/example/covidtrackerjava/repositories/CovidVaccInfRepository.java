package com.example.covidtrackerjava.repositories;

import com.example.covidtrackerjava.models.dao.CovidVaccinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CovidVaccInfRepository extends JpaRepository<CovidVaccinationEntity, Long> {
}
