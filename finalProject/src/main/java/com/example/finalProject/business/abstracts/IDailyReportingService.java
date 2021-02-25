package com.example.finalProject.business.abstracts;

import java.io.IOException;
import java.sql.Date;

import com.example.finalProject.entities.concretes.DailyReporting;

public interface IDailyReportingService {
	
	DailyReporting add(DailyReporting reporting) throws IOException;
	DailyReporting getDailyReportByDate(Date date);

}
