package com.example.finalProject.api.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.business.abstracts.IDailyReportingService;
import com.example.finalProject.entities.concretes.Credit;
import com.example.finalProject.entities.concretes.Customer;
import com.example.finalProject.entities.concretes.DailyReporting;
import com.example.finalProject.entities.concretes.LimitationOfCredit;


@RestController
@RequestMapping("/api/v1")
public class DailyReportsController {
	
	@Autowired
	private IDailyReportingService dailyReportingService;
	
	@GetMapping("/dailyReports/{id}")
	public ResponseEntity<DailyReporting> getDailyReportByDate(@PathVariable(value="id") Date date){

		DailyReporting getDailyReport = dailyReportingService.getDailyReportByDate(date);

		return ResponseEntity.ok(getDailyReport);
	}

	@PostMapping("/dailyReports")
	public ResponseEntity<DailyReporting> add(@RequestBody DailyReporting dailyReport) throws IOException {
		
		DailyReporting addedDailyReport = dailyReportingService.add(dailyReport);

		return ResponseEntity.ok(addedDailyReport);

	}
	

}
