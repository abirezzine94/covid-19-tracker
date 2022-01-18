package com.example.covidtrackerjava.services;

import com.example.covidtrackerjava.models.dao.CovidVaccinationEntity;
import com.example.covidtrackerjava.models.dto.CovidVaccinationDto;
import com.example.covidtrackerjava.models.dto.CustomResponse;
import com.example.covidtrackerjava.repositories.CovidVaccInfRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class CovidVaccinationInfServiceImpl implements CovidVaccinationInfService {
    @Autowired
    CovidVaccInfRepository covidVaccInfRepository;
    @Value("${code.success}")
    private Integer successCode;
    @Value("${code.notfound}")
    private Integer notFoundCode;
    @Value("${page.size}")
    private Integer pageSize;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public CustomResponse addOneVacc(CovidVaccinationDto dto) {
        try {
            CovidVaccinationEntity entity = objectMapper.convertValue(dto, CovidVaccinationEntity.class);
            CovidVaccinationEntity entityReturn = covidVaccInfRepository.save(entity);
            return new CustomResponse(successCode, objectMapper.convertValue(entityReturn, CovidVaccinationEntity.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CustomResponse update(CovidVaccinationEntity entity) {
        try {
            Optional<CovidVaccinationEntity> vaccEntity= covidVaccInfRepository.findById(entity.getId());
            if(vaccEntity.isEmpty()){
                return new CustomResponse(notFoundCode,null);
            }
            entity.setEditDate(new Timestamp(System.currentTimeMillis()));
            CovidVaccinationEntity entityReturn = covidVaccInfRepository.saveAndFlush(entity);
            return new CustomResponse(successCode, objectMapper.convertValue(entityReturn, CovidVaccinationDto.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
