package com.example.days.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

@Service
public class DayService {

//Week dates
    public ArrayList<LocalDate> getWeekDates(LocalDate localDate){

        ArrayList<LocalDate> dateList = new ArrayList<>();
        TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
        for(int i=1;i<=7;i++) {
            dateList.add(localDate.with(fieldISO, i));
        }
        System.out.println(dateList);
        return dateList;
    }

// Month dates
    public ArrayList<LocalDate> getMonthDates(LocalDate localDate){

        ArrayList<LocalDate> dateList = new ArrayList<>();
        LocalDate date = localDate.withDayOfMonth(1);
        LocalDate end = date.plusMonths(1);

        while(date.isBefore(end)) {
            dateList.add(date);
            date = date.plusDays(1);
        }
        return dateList;
    }

}
