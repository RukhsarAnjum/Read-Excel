package com.example.readexcel.controller;

import com.example.readexcel.bean.Customer;
import com.example.readexcel.readexcel.ReadingExcelFile;
import com.example.readexcel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class ExcelController {
    @Autowired
    private CustomerService customerService;

    public ArrayList<Customer> readExcel() throws IOException {
        ReadingExcelFile readingExcelFile=new ReadingExcelFile();
        ArrayList<Customer> customerList = readingExcelFile.readData();
        System.out.println(customerList);
        return customerList;
//        ArrayList<Customer> readCustomer=
    }

    public void saveAllCustomer(ArrayList<Customer> customerList) {
        for(Customer customer:customerList) {
            saveCustomer(customer);
        }
    }

    private void saveCustomer(Customer customer){
        customerService.saveCustomer(customer);
    }
}
