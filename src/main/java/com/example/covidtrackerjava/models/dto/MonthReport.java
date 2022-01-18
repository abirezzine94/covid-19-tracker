package com.example.covidtrackerjava.models.dto;

public class MonthReport {
    private Long totalCases;
    private String year;
    private String month;
    private String code;

    public MonthReport() {
    }

    public MonthReport(Long totalCases, String year, String month, String code) {
        this.totalCases = totalCases;
        this.year = year;
        this.month = month;
        this.code = code;
    }

    public Long getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Long totalCases) {
        this.totalCases = totalCases;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

