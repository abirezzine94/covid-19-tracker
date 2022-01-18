package com.example.covidtrackerjava.models.dto;

import java.util.List;

public class PaginatedPage {
    private List<?> result;
    private Integer nextPage;
    private Integer priviousPage;
    private Integer totalPage;

    public PaginatedPage() {
    }

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getPriviousPage() {
        return priviousPage;
    }

    public void setPriviousPage(Integer priviousPage) {
        this.priviousPage = priviousPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
