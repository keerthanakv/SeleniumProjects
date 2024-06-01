package com.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class swaglabs {
    // WebDriver driver;
    

    @Test(dataProvider = "getData")
    public void testWithExcelData(String username, String password) {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        // Your test logic using the provided username and password
        System.setProperty("webdriver.chrome.driver","D:\\Users\\NEW\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions Option = new ChromeOptions();
        WebDriver driver = new ChromeDriver(Option);
        driver.get("https://www.saucedemo.com/v1/");

        //System.out.println("Username: " + username + " Password: " + password);
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        
        // Assertions and further test steps can be added here
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        String excelFilePath = "D:\\Users\\NEW\\Desktop\\SOFTWARE TESTING\\testcase.xlsx";
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

