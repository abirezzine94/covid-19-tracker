package com.example.covidtrackerjava.services;

import com.example.covidtrackerjava.models.dao.CovidVaccinationEntity;
import com.example.covidtrackerjava.models.dto.CovidVaccinationDto;
import com.example.covidtrackerjava.models.dto.CustomResponse;

public interface CovidVaccinationInfService {
    CustomResponse addOneVacc(CovidVaccinationDto dto);
    CustomResponse update(CovidVaccinationEntity entity);
}
