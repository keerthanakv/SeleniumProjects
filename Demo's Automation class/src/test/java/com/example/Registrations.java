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
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registrations {

    @Test(dataProvider = "registerData")

    public void setting(String fname,String lname ,String Gender,String ads,String sads,String apto,String states,String pin,String country,String email,String phone,String textarea){
    WebDriverManager.edgedriver().clearDriverCache().setup();
    System.setProperty("webdriver.edge.driver", "D:\\Users\\NEW\\Downloads\\edgedriver_win64\\msedgedriver.exe");
    WebDriver driver = new EdgeDriver();
    driver.manage().window().maximize();
    driver.get("https://nxtgenaiacademy.com/demo-site/");

    WebElement firstNameElement = driver.findElement(By.id("vfb-5"));
    firstNameElement.sendKeys(fname);
    WebElement lastNameElement = driver.findElement(By.id("vfb-7"));
    lastNameElement.sendKeys(lname);
    // WebElement radio = driver.findElement(By.id("vfb-31-2"));
    // radio.click();
    WebElement maleElement = driver.findElement(By.id("vfb-31-1"));
    WebElement femaleElement = driver.findElement(By.id("vfb-31-2"));
    WebElement other = driver.findElement(By.id("vfb-31-3"));
            if ("Male".equalsIgnoreCase(Gender)) {
                maleElement.click();
            }else if ("Female".equalsIgnoreCase(Gender)) {
                 femaleElement.click();
            }else{
                 other.click();
            }
    WebElement address = driver.findElement(By.id("vfb-13-address"));
    address.sendKeys(ads);
    WebElement saddress = driver.findElement(By.id("vfb-13-address-2"));
    saddress.sendKeys(sads);
    WebElement apt = driver.findElement(By.id("vfb-13-city"));
    apt.sendKeys(apto);
    WebElement state = driver.findElement(By.id("vfb-13-state"));
    state.sendKeys(states);
    WebElement zip = driver.findElement(By.id("vfb-13-zip"));
    zip.sendKeys(pin);
    WebElement countryc = driver.findElement(By.xpath("//*[@id=\"item-vfb-13\"]/div/span[6]/span/span[1]/span"));
    countryc.click();
    WebElement countryi = driver.findElement(By.xpath("/html/body/span[2]/span/span[1]/input"));
    countryi.sendKeys(country,Keys.ENTER);
    WebElement mail = driver.findElement(By.id("vfb-14"));
    mail.sendKeys(email);
    WebElement DateBirth = driver.findElement(By.id("vfb-18"));
    DateBirth.sendKeys("10/12/2000");
    driver.findElement(By.cssSelector("#item-vfb-18 > span > label")).click();
    WebElement hhc = driver.findElement(By.cssSelector("#item-vfb-16 > span:nth-child(2) > span > span.selection > span > span.select2-selection__arrow"));
    hhc.click();
    WebElement hhi = driver.findElement(By.cssSelector("body > span.select2-container.select2-container--default.select2-container--open > span > span.select2-search.select2-search--dropdown > input"));
    hhi.sendKeys("03",Keys.ENTER);
    WebElement mmc = driver.findElement(By.cssSelector("#item-vfb-16 > span:nth-child(3) > span > span.selection > span > span.select2-selection__arrow"));
    mmc.click();
    WebElement mmi = driver.findElement(By.cssSelector("body > span.select2-container.select2-container--default.select2-container--open > span > span.select2-search.select2-search--dropdown > input"));
    mmi.sendKeys("03",Keys.ENTER);
    driver.findElement(By.id("vfb-19")).sendKeys(phone);
    driver.findElement(By.id("vfb-20-1")).click();
    driver.findElement(By.id("vfb-23")).sendKeys(textarea);

    driver.findElement(By.id("vfb-3")).sendKeys("99");
    driver.findElement(By.id("vfb-4")).click();

     }


    @DataProvider
    public Object[][] registerData() throws IOException {
        
        String excelFilePath = "D:\\Users\\NEW\\Desktop\\SOFTWARE TESTING\\registrations.xlsx";
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

