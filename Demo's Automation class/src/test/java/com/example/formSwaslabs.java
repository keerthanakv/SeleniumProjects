package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class formSwaslabs {
     @BeforeTest()
     public void logins(){
        WebDriverManager.chromedriver().clearDriverCache().setup();
   
      System.setProperty("webdriver.chrome.driver","D:\\Users\\NEW\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions Option = new ChromeOptions();
        WebDriver driver = new ChromeDriver(Option);
        driver.get("https://www.saucedemo.com/v1/");
        //System.out.println("Username: " + username + " Password: " + password);
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
     }

    @Test(dataProvider = "getData")
    public void testWithExcelData(String firstname, String lastname, CharSequence[] zip) {
       WebDriverManager.chromedriver().clearDriverCache().setup();
        System.setProperty("webdriver.chrome.driver","D:\\Users\\NEW\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        //ChromeOptions Option = new ChromeOptions();
       
        WebDriver driver = new ChromeDriver();
         
        driver.get("https://www.saucedemo.com/v1/checkout-step-one.html");
        //System.out.println("Username: " + username + " Password: " + password);
        driver.findElement(By.id("first-name")).sendKeys(firstname);
        driver.findElement(By.id("last-name")).sendKeys(lastname);
        driver.findElement(By.id("postal-code")).sendKeys(zip);
        driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")).click();

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        String excelFilePath = "D:\\Users\\NEW\\Desktop\\SOFTWARE TESTING\\checkout.xlsx";
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
    
                // Handle cell type based on content
                switch (cell.getCellType()) {
                    case STRING:
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        // For zip, assuming it's numeric, use the appropriate data type
                        if (j == 2) {
                            data[i][j] = String.valueOf((int) cell.getNumericCellValue());
                        } else {
                            // For other string fields
                            data[i][j] = String.valueOf(cell.getNumericCellValue());
                        }
                        break;
                    default:
                        // Handle other types if needed
                        break;
                }
            }
        }
    
        workbook.close();
        return data;
    }
    
    

}
