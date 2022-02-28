package com.example.days.controller;

import com.example.days.entities.DateBean;
import com.example.days.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class DayController {

    @Autowired
    private DayService dayService;
    //http://localhost:8085/week/16-08-2022
    @GetMapping("/week/{date}")
    public ResponseEntity getWeeklyDate(@PathVariable String date) {
        //date format 16/08/2016 (dd-mm-yyyy)
        LocalDate localDate = null;
        try {
            localDate = convertStringToDate(date);

        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Kindly enter correct date time format",HttpStatus.OK);
        }


        return new ResponseEntity(dayService.getWeekDates(localDate),HttpStatus.OK);
    }

    //http://localhost:8085/month/16-02-2022
    @GetMapping("/month/{date}")
    public ResponseEntity getMonthlyDate(@PathVariable String date) {
        //date format 16/08/2016 (dd-mm-yyyy)
        LocalDate localDate = null;
        try {
            localDate = convertStringToDate(date);

        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Kindly enter correct date time format",HttpStatus.OK);
        }


        return new ResponseEntity(dayService.getMonthDates(localDate),HttpStatus.OK);
    }


    public LocalDate convertStringToDate(String date) throws Exception{
        LocalDate localDate = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
            localDate = LocalDate.parse(date, formatter);
        }catch (Exception ex){
            throw ex;
        }
        return localDate;
    }

}
