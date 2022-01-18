package com.example.covidtrackerjava.services;

import com.example.covidtrackerjava.models.dao.CovidCasesEntity;
import com.example.covidtrackerjava.models.dto.*;
import com.example.covidtrackerjava.repositories.CovidCasesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Optional;

@Service
public class CovidCasesServiceImpl implements CovidCasesService {

    @Autowired
    CovidCasesRepository covidCasesRepository;
    @Value("${code.success}")
    private Integer successCode;
    @Value("${code.notfound}")
    private Integer notFoundCode;
    @Value("${page.size}")
    private Integer pageSize;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public CustomResponse addOneCase(CovidCasesDto covidCasesDto) {
        try {
            CovidCasesEntity covidCasesEntity = objectMapper.convertValue(covidCasesDto, CovidCasesEntity.class);
            CovidCasesEntity covidCasesReturn = covidCasesRepository.save(covidCasesEntity);
            return new CustomResponse(successCode, objectMapper.convertValue(covidCasesReturn, CovidCasesDto.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CustomResponse update(CovidCasesEntity covidCasesEntity) {
        try {
            Optional<CovidCasesEntity> entity= covidCasesRepository.findById(covidCasesEntity.getId());
            if(entity.isEmpty()){
               return new CustomResponse(notFoundCode,null);
            }
            covidCasesEntity.setEditDate(new Timestamp(System.currentTimeMillis()));
            CovidCasesEntity covidCasesReturn = covidCasesRepository.saveAndFlush(covidCasesEntity);
            return new CustomResponse(successCode, objectMapper.convertValue(covidCasesReturn, CovidCasesDto.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PaginatedPage getDailyCases(Integer page) {
        try {
            Page<DateReport> casesEntities = covidCasesRepository.findByTestDate(PageRequest.of(page, pageSize));
            PaginatedPage paginatedPage = new PaginatedPage();
            paginatedPage.setResult(casesEntities.getContent());
            paginatedPage.setNextPage(casesEntities.hasNext() ? casesEntities.nextPageable().getPageNumber() : null);
            paginatedPage.setPriviousPage(casesEntities.hasPrevious() ? casesEntities.previousPageable().getPageNumber() : null);
            paginatedPage.setTotalPage(casesEntities.getTotalPages());
            return paginatedPage;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PaginatedPage getMonthlyCases(Integer page) {
        try {
            Page<MonthReport> casesEntities = covidCasesRepository.findBPerMonth(PageRequest.of(page, pageSize));
            PaginatedPage paginatedPage = new PaginatedPage();
            paginatedPage.setResult(casesEntities.getContent());
            paginatedPage.setNextPage(casesEntities.hasNext() ? casesEntities.nextPageable().getPageNumber() : null);
            paginatedPage.setPriviousPage(casesEntities.hasPrevious() ? casesEntities.previousPageable().getPageNumber() : null);
            paginatedPage.setTotalPage(casesEntities.getTotalPages());
            return paginatedPage;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
