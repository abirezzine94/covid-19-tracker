package com.example.covidtrackerjava.services;

import com.example.covidtrackerjava.models.dao.CovidCasesEntity;
import com.example.covidtrackerjava.models.dto.CovidCasesDto;
import com.example.covidtrackerjava.models.dto.CustomResponse;
import com.example.covidtrackerjava.models.dto.PaginatedPage;

import java.sql.Date;

public interface CovidCasesService {
    CustomResponse addOneCase(CovidCasesDto covidCasesDto);
    CustomResponse update(CovidCasesEntity covidCasesEntity);
    PaginatedPage getDailyCases(Integer page);
    PaginatedPage getMonthlyCases(Integer page);
}
