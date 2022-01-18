package com.example.covidtrackerjava.controllers;

import com.example.covidtrackerjava.models.dao.CovidCasesEntity;
import com.example.covidtrackerjava.models.dto.CovidCasesDto;
import com.example.covidtrackerjava.models.dto.CustomResponse;
import com.example.covidtrackerjava.models.dto.PaginatedPage;
import com.example.covidtrackerjava.services.CovidCasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RequestMapping("/covid-cases")
@RestController
public class CovidCasesController {
    @Value("${code.notfound}")
    private Integer notFoundCode;
    @Autowired
    CovidCasesService covidCasesService;
    @PostMapping("/")
    public ResponseEntity<?>createCovidCase(@RequestBody CovidCasesDto covidCasesDto){
        try {
            CustomResponse response=covidCasesService.addOneCase(covidCasesDto);
            return new ResponseEntity<>(response.getResult(), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    @PatchMapping("/")
    public ResponseEntity<?>updateCase(@RequestBody CovidCasesEntity covidCasesEntity){
        try {
            CustomResponse response=covidCasesService.update(covidCasesEntity);
            if(response.getCode().equals(notFoundCode)){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(response.getResult(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("/daily")
    public ResponseEntity<?>getDaily(@RequestParam(required = false,defaultValue = "0") Integer page){
        try {
            PaginatedPage paginatedPage= covidCasesService.getDailyCases(page);
            return new ResponseEntity<>(paginatedPage,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    @GetMapping("/monthly")
    public ResponseEntity<?>getMonthly(@RequestParam(required = false,defaultValue = "0") Integer page){
        try {
            PaginatedPage paginatedPage= covidCasesService.getMonthlyCases(page);
            return new ResponseEntity<>(paginatedPage,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
