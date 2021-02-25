package com.example.finalProject.dataaccess.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.finalProject.entities.concretes.Credit;
import com.example.finalProject.entities.concretes.DailyReporting;

public interface DailyReportingRepository extends JpaRepository<DailyReporting,Integer>{

	DailyReporting findByDate(Date date);
}
