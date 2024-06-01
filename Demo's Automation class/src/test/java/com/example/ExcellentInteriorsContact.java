package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcellentInteriorsContact {
     @Test(dataProvider = "getData")
    public void ContactForm(String Name,String Phone,String EMail,String CMessage){
    WebDriverManager.chromedriver().clearDriverCache().setup();
    System.setProperty("webdriver.chrome.driver","D:\\Users\\NEW\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();
     driver.manage().window().maximize();
    driver.get("https://esightsolutions.in/excellentInteriors/demo7/contact.html");
   
    
    WebElement name = driver.findElement(By.id("c_name"));
    name.sendKeys(Name);
    WebElement phno = driver.findElement(By.id("c_phone"));
    phno.sendKeys(Phone);
    WebElement email = driver.findElement(By.id("email_id"));
    email.sendKeys(EMail);
    WebElement msg = driver.findElement(By.id("message"));
    msg.sendKeys(CMessage);

    WebElement button_1 = driver.findElement(By.cssSelector("#send_btn"));
    button_1.sendKeys(Keys.ENTER);
    // if(button_1.isSelected()){
    // 
    // }
    // else{
    //     System.out.println("unable to click");
    // }
   

    
       
        // WebElement sendBtn = driver.findElement(By.id("send_btn"));
        // WebElement interferingElement = driver.findElement(By.id("send_btn"));

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.elementToBeClickable(sendBtn));
        // sendBtn.click();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        
        String excelFilePath = "D:\\Users\\NEW\\Desktop\\SOFTWARE TESTING\\ExcellentInteriors\\Contact.xlsx";
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

    

