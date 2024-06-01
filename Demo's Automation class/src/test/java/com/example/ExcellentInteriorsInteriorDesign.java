package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcellentInteriorsInteriorDesign {

    @Test(dataProvider = "getData")
    public void InteriorDesignForm(String Name,String Phone,String EMail){
    WebDriverManager.chromedriver().clearDriverCache().setup();
    System.setProperty("webdriver.chrome.driver","D:\\Users\\NEW\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();
    driver.get("https://esightsolutions.in/excellentInteriors/demo7/interior-design.html");
    driver.manage().window().maximize();
    WebElement element = driver.findElement(By.cssSelector("#innerService > article.container > article > article.innerServiceDetails > article.enquireBtn"));
    if (element.isDisplayed() && element.isEnabled() ) {
       
         element.sendKeys(Keys.ENTER);
    } else {
        System.out.println("Element is not visible or enabled");
        // Send ENTER key to click the button
    }
    

//driver.findElement(By.xpath("//*[@id=\"innerService\"]/article[2]/article/article[1]/article[1]")).sendKeys(Keys.ENTER);
    
    WebElement name = driver.findElement(By.id("e_name"));
    name.sendKeys(Name);
    WebElement phno = driver.findElement(By.id("e_phone"));
    phno.sendKeys(Phone);
    WebElement email = driver.findElement(By.id("email_id"));
    email.sendKeys(EMail);

    driver.findElement(By.className("closeEnquiryPopup")).sendKeys(Keys.ENTER);

    
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        
        String excelFilePath = "D:\\Users\\NEW\\Desktop\\SOFTWARE TESTING\\ExcellentInteriors\\Jobwork.xlsx";
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

