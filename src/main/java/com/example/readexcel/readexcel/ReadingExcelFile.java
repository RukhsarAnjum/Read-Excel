package com.example.readexcel.readexcel;

import com.example.readexcel.bean.Customer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class ReadingExcelFile {

    public ArrayList<Customer> readData() throws IOException {
        String excelFilePath=".\\datafiles\\data.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelFilePath);
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fileInputStream);

        ArrayList<Customer> sheetData=new ArrayList<>();
        XSSFSheet sheet =xssfWorkbook.getSheetAt(0);
        int rows=sheet.getLastRowNum();
        int cols=sheet.getRow(1).getLastCellNum();

        for(int r=1;r<=rows;r++){
            XSSFRow row=sheet.getRow(r);
            Customer customer=new Customer();
            for(int c=0;c<cols;c++){
                XSSFCell cell=row.getCell(c);
                switch (c){
                    case 0:customer.setDateOfInvocation(getCellValue(cell)); break;
                    case 1:customer.setLenderID(getCellValue(cell)); break;
                    case 2:customer.setApiInvoked(getCellValue(cell)); break;
                    case 3:customer.setTimeInvoked(getCellValue(cell)); break;
                    case 4:customer.setCustomerID(getCellValue(cell)); break;
                    case 5:customer.setCustomerPhone(Long.parseLong(getCellValue(cell))); break;
                    case 6:customer.setResult(getCellValue(cell)); break;
                }
            }
           // System.out.println(customer);
            sheetData.add(customer);
        }
        return sheetData;
    }

    public String getCellValue(Cell cell){
        if(cell != null){
            switch (cell.getCellType())
            {
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.println("Number"+cell.getNumericCellValue());
                    Double doubleValue = cell.getNumericCellValue();
                    BigDecimal bd = new BigDecimal(doubleValue.toString());
                    long lonVal = bd.longValue();
                    String phoneNumber = Long.toString(lonVal).trim();
                    return phoneNumber+"";

                case Cell.CELL_TYPE_STRING:
                    System.out.println(cell.getStringCellValue());
                    return cell.getStringCellValue();

                case Cell.CELL_TYPE_BOOLEAN:
                    return cell.getBooleanCellValue()+"";
            }
        }
        return null;
    }

}
