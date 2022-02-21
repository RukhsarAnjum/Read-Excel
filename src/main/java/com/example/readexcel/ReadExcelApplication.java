package com.example.readexcel;

import com.example.readexcel.bean.Customer;
import com.example.readexcel.controller.ExcelController;
import com.example.readexcel.readexcel.ReadingExcelFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
public class ReadExcelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadExcelApplication.class, args);
	}

}
