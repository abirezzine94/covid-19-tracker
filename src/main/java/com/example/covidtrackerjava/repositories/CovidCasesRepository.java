package com.example.covidtrackerjava.repositories;

import com.example.covidtrackerjava.models.dao.CovidCasesEntity;
import com.example.covidtrackerjava.models.dto.DateReport;
import com.example.covidtrackerjava.models.dto.MonthReport;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;

public interface CovidCasesRepository extends JpaRepository<CovidCasesEntity, Long> {
    @Query("SELECT  new com.example.covidtrackerjava.models.dto.DateReport(c.countryCode,cast(c.testDate as text), count (c)) from CovidCasesEntity c where c.testResult=true group by c.countryCode,c.testDate")
    Page<DateReport> findByTestDate(Pageable pageable);

    @Query("SELECT  new com.example.covidtrackerjava.models.dto.MonthReport(count (c),cast(YEAR(c.testDate) as text),cast(MONTH(c.testDate) as text),c.countryCode) from CovidCasesEntity c where c.testResult=true group by c.countryCode,MONTH(c.testDate),YEAR(c.testDate)")
    Page<MonthReport> findBPerMonth( Pageable pageable);

}
