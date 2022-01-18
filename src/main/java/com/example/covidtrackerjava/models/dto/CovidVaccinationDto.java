package com.example.covidtrackerjava.models.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class CovidVaccinationDto {
    private Integer doseNbr;
    private String countryCode;
    private String patientFirstName;
    private String patientLastName;
    private Date birthDate;
    private String patientAddress;
    private Timestamp creationDate;
    private Timestamp editDate;

    public CovidVaccinationDto() {
    }

    public Integer getDoseNbr() {
        return doseNbr;
    }

    public void setDoseNbr(Integer doseNbr) {
        this.doseNbr = doseNbr;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getEditDate() {
        return editDate;
    }

    public void setEditDate(Timestamp editDate) {
        this.editDate = editDate;
    }
}
