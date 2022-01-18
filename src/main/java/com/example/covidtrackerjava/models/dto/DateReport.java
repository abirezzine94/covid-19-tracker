package com.example.covidtrackerjava.models.dto;

import java.sql.Date;

public class DateReport {
    private Long totalCases;
    private String date;
    private String code;

    public DateReport() {
    }

    public DateReport( String code,String date,Long totalCases) {
        this.totalCases = totalCases;
        this.date = date;
        this.code = code;
    }

    public Long getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Long totalCases) {
        this.totalCases = totalCases;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
