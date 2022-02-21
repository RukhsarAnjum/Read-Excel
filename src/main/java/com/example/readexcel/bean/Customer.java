package com.example.readexcel.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class Customer {
    private String dateOfInvocation;
    private String lenderID;
    private String apiInvoked;
    private String timeInvoked;
    private String customerID;
    private Long customerPhone;
    private String result;
}
