package com.example.covidtrackerjava.controllers;

import com.example.covidtrackerjava.models.dao.CovidVaccinationEntity;
import com.example.covidtrackerjava.models.dto.CovidVaccinationDto;
import com.example.covidtrackerjava.models.dto.CustomResponse;
import com.example.covidtrackerjava.services.CovidVaccinationInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/covid-vaccination")
public class CovidVaccinationController {
    @Autowired
    CovidVaccinationInfService covidVaccServ;
    @Value("${code.notfound}")
    private Integer notFoundCode;

    @PostMapping("/")
    public ResponseEntity<?> createCovidVaccination(@RequestBody CovidVaccinationDto covidVaccinationDto){
        try {
            CustomResponse response=covidVaccServ.addOneVacc(covidVaccinationDto);
            return new ResponseEntity<>(response.getResult(), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    @PatchMapping("/")
    public ResponseEntity<?>updateVaccination(@RequestBody CovidVaccinationEntity covidVaccinationEntity){
        try {
            CustomResponse response=covidVaccServ.update(covidVaccinationEntity);
            if(response.getCode().equals(notFoundCode)){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(response.getResult(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
