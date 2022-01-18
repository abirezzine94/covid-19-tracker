package com.example.covidtrackerjava;

import com.example.covidtrackerjava.models.dao.CovidCasesEntity;
import com.example.covidtrackerjava.models.dao.CovidVaccinationEntity;
import com.example.covidtrackerjava.models.dto.CovidCasesDto;
import com.example.covidtrackerjava.models.dto.CovidVaccinationDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.core.JsonParseException;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import static junit.framework.TestCase.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CovidTrackerJavaApplication.class)
@WebAppConfiguration
@AutoConfigureMockMvc()
class CovidTrackerJavaApplicationTests {
    @Autowired
    protected MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void createCovidVaccination() throws Exception {
        String uri = "/covid-vaccination/";
        CovidVaccinationDto covidVaccinationDto = new CovidVaccinationDto();
        covidVaccinationDto.setCountryCode("TN");
        covidVaccinationDto.setPatientAddress("Tunis");
        covidVaccinationDto.setPatientFirstName("ABir");
        covidVaccinationDto.setPatientLastName("Ezzine");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = format.parse("2021-02-10");
        covidVaccinationDto.setDoseNbr(1);
        covidVaccinationDto.setBirthDate(new Date(((java.util.Date) format.parse("2021-02-10")).getTime()));

        String inputJson = mapToJson(covidVaccinationDto);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(status().isCreated()).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }

    @Test
    public void updateCovidVaccination() throws Exception {
        String uri = "/covid-vaccination/";
        CovidVaccinationEntity covidVaccinationEntity = new CovidVaccinationEntity();
        covidVaccinationEntity.setId((long) 1);
        covidVaccinationEntity.setCountryCode("TN");
        covidVaccinationEntity.setPatientAddress("Tunis");
        covidVaccinationEntity.setPatientFirstName("ABir");
        covidVaccinationEntity.setPatientLastName("Ezzine");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = format.parse("2021-02-10");
        covidVaccinationEntity.setDoseNbr(1);
        covidVaccinationEntity.setBirthDate(new Date(((java.util.Date) format.parse("2021-02-10")).getTime()));

        String inputJson = mapToJson(covidVaccinationEntity);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.patch(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(status().isNotFound()).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
    }

    @Test
    public void createCovidCase() throws Exception {
        String uri = "/covid-cases/";
        CovidCasesDto covidCasesDto = new CovidCasesDto();
        covidCasesDto.setCountryCode("TN");
        covidCasesDto.setPatientAddress("Tunis");
        covidCasesDto.setPatientFirstName("ABir");
        covidCasesDto.setPatientLastName("Ezzine");
        covidCasesDto.setTestResult(true);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = format.parse("2021-02-10");
        covidCasesDto.setTestDate(new Date(parsed.getTime()));
        covidCasesDto.setBirthDate(new Date(((java.util.Date) format.parse("2021-02-10")).getTime()));

        String inputJson = mapToJson(covidCasesDto);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(status().isCreated()).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }

    @Test
    public void updateCovidCase() throws Exception {
        String uri = "/covid-cases/";
        CovidCasesEntity covidCasesEntity = new CovidCasesEntity();
        covidCasesEntity.setId((long) 1);
        covidCasesEntity.setCountryCode("TN");
        covidCasesEntity.setPatientAddress("Tunis");
        covidCasesEntity.setPatientFirstName("ABir");
        covidCasesEntity.setPatientLastName("Ezzine");
        covidCasesEntity.setTestResult(false);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = format.parse("2021-02-10");
        covidCasesEntity.setTestDate(new Date(parsed.getTime()));
        covidCasesEntity.setBirthDate(new Date(((java.util.Date) format.parse("1994-06-24")).getTime()));

        String inputJson = mapToJson(covidCasesEntity);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.patch(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(status().isNotFound()).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
    }

    @Test
    public void getDailyCovidCase() throws Exception {
        String uri = "/covid-cases/daily";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        ;

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void getMonthlyCovidCase() throws Exception {
        String uri = "/covid-cases/monthly";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        ;

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

}
