package com;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class lmsadmin {

    @Test(dataProvider="loginData", dataProviderClass = TestData.class, priority = 1)
    public void admin_login(String u_name, String p_wd){
    
        // Setup EdgeDriver using WebDriverManager
        WebDriverManager.edgedriver().setup();

        // Initialize the WebDriver
        WebDriver driver = new EdgeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the specified URL
        driver.get("https://stayberries.in/neethus/admin/login");

        // Login to admin
        WebElement name = driver.findElement(By.id("user_name"));
        name.sendKeys(u_name);
        WebElement pwd = driver.findElement(By.id("password-field"));
        pwd.sendKeys(p_wd);
        WebElement L_Btn = driver.findElement(By.xpath("/html/body/main/div/div/form/div[3]/button"));
        L_Btn.click();

        // Close the browser
        // driver.quit();
    }

    public static class TestData {
        @DataProvider(name = "loginData")
        public Object[][] getData() throws IOException {
            FileInputStream fis = new FileInputStream("D:\\Users\\NEW\\Desktop\\Automation codes\\LMS Application\\LMS_Login_Details.xlsx"); // Add .xlsx extension if needed
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Object[][] data = new Object[sheet.getLastRowNum()][2];
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                String u_name = getCellValueAsString(row.getCell(0));
                String p_wd = getCellValueAsString(row.getCell(1));
                data[rowIndex - 1][0] = u_name;
                data[rowIndex - 1][1] = p_wd;
            }
            fis.close();
            return data;
        }

        private String getCellValueAsString(Cell cell) {
            switch (cell.getCellType()) {
                case STRING:
                    return cell.getStringCellValue();
                case NUMERIC:
                    // Handle numeric values by converting them to a string
                    DecimalFormat decimalFormat = new DecimalFormat("#");
                    return decimalFormat.format(cell.getNumericCellValue());
                default:
                    // Handle other cell types if needed
                    return "";
            }
        }
    }
}
