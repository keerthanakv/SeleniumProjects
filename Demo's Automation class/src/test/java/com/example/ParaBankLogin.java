package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParaBankLogin {
    @Test(dataProvider = "getData")
    public void registers(String username,String password){
    WebDriverManager.chromedriver().clearDriverCache().setup();
    System.setProperty("webdriver.chrome.driver","D:\\Users\\NEW\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();
    driver.get("https://parabank.parasoft.com/parabank/initializeDB.htm");
    
    driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")).sendKeys(username);
    driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input")).sendKeys(password);
    driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
    
}
@DataProvider
    public Object[][] getData() throws IOException {
        String excelFilePath = "D:\\Users\\NEW\\Desktop\\SOFTWARE TESTING\\paralogin.xlsx";
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
                data[i][j] = cell.getStringCellValue();
            }
        }

        workbook.close();
        return data;
    }
}