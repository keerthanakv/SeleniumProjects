package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class ParaBankRegister {


    @Test(dataProvider = "getData")
    public void registers(String first,String last,String address,String city, String state, String zipCode,String phone,String ssn,String userName,String password,String rpass){
    WebDriverManager.chromedriver().clearDriverCache().setup();
    System.setProperty("webdriver.chrome.driver","D:\\Users\\NEW\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();
    driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=AEB33B2790ABD198F1B7263E77B44DB3");
    
    driver.findElement(By.id("customer.firstName")).sendKeys(first);
    driver.findElement(By.id("customer.lastName")).sendKeys(last);
    driver.findElement(By.id("customer.address.street")).sendKeys(address);
    driver.findElement(By.id("customer.address.city")).sendKeys(city);
    driver.findElement(By.id("customer.address.state")).sendKeys(state);
    driver.findElement(By.id("customer.address.zipCode")).sendKeys(zipCode);
    driver.findElement(By.id("customer.phoneNumber")).sendKeys(phone);
    driver.findElement(By.id("customer.ssn")).sendKeys(ssn);
    driver.findElement(By.id("customer.username")).sendKeys(userName);
    driver.findElement(By.id("customer.password")).sendKeys(password);
    driver.findElement(By.id("repeatedPassword")).sendKeys(rpass);
    driver.findElement(By.cssSelector("#customerForm > table > tbody > tr:nth-child(13) > td:nth-child(2) > input")).click();

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        
        String excelFilePath = "D:\\Users\\NEW\\Desktop\\SOFTWARE TESTING\\parabank.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("Sheet1");
    
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
    
        Object[][] data = new Object[rowCount][colCount];
    
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1); // Skip header row
    
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                    DataFormatter formatter = new DataFormatter();
                    String cellValue = formatter.formatCellValue(cell);
                    data[i][j] = cellValue;
               
        }
    }
    
    
        workbook.close();
        return data;
    }

}
