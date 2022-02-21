package com.example.readexcel.controller;

import com.example.readexcel.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    ExcelController excelController;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("In CommandLineRunnerImpl ");
        //ExcelController excelController=new ExcelController();
        ArrayList<Customer> customerList = excelController.readExcel();
        excelController.saveAllCustomer(customerList);
    }
}
