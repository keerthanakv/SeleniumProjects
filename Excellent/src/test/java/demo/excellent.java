package demo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class excellent {

    private WebDriver driver;
   

    @Test(dataProvider = "testData")
    public void excel(String name, String phone, String email, String message, String Jname,String Jphone,String Jemail) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        WebDriverManager.edgedriver().clearDriverCache().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://excellentInteriors.com/"); // it's dummy link of project


                    WebElement contactNow = driver.findElement(By.id("contact_btn"));
                    contactNow.sendKeys(Keys.ENTER);

                    WebElement clientName = driver.findElement(By.id("c_name"));
                    clientName.sendKeys(name);

                    WebElement clientPhone = driver.findElement(By.id("c_phone"));
                    clientPhone.sendKeys(phone);

                    WebElement clientEmail = driver.findElement(By.id("email_id"));
                    clientEmail.sendKeys(email);

                    WebElement clientMsg = driver.findElement(By.id("message"));
                    clientMsg.sendKeys(message);

                    WebElement clientSubmit = driver.findElement(By.id("send_btn"));
                    clientSubmit.sendKeys(Keys.ENTER);

/////////// JOB WORK ///////////

        WebElement jobwork = driver.findElement(By.xpath("/html/body/nav/article/article/article[1]/ul/li[4]"));
        jobwork.click();

            WebElement jobworkexplore = driver.findElement(By.cssSelector("#innerService > article.container > article > article.innerServiceDetails > article.enquireBtn"));

        // Scroll the element into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", jobworkexplore);

        // Wait for a short moment (you can adjust the sleep duration if needed)
            Thread.sleep(500);

        // Click on the element
            jobworkexplore.click();

                    WebElement jobworkname = driver.findElement(By.id("e_name"));
                    jobworkname.sendKeys(Jname);

                    WebElement jobworkphone = driver.findElement(By.id("e_phone"));
                    jobworkphone.sendKeys(Jphone);

                    WebElement jobworkemail = driver.findElement(By.id("email_id"));
                    jobworkemail.sendKeys(Jemail);

                    WebElement jobwork_submit = driver.findElement(By.id("send_btn"));
                    jobwork_submit.click();


///////// SERVICES /////////

        WebElement service = driver.findElement(By.cssSelector("body > nav > article > article > article.navLink > ul > li:nth-child(3) > article > a"));

    // Scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", service);

    // Wait for a short moment (you can adjust the sleep duration if needed)
        Thread.sleep(500);

    // Click on the element
        service.sendKeys(Keys.ENTER);

// Interior Design Service //

        WebElement S_ID = driver.findElement(By.cssSelector("#servicePage > article > article.servicePageMain > article:nth-child(1) > article.servicePageBoxDetails > a"));
        S_ID.sendKeys(Keys.ENTER);
       
            WebElement S_ID_expolre = driver.findElement(By.cssSelector("#innerService > article.container > article > article.innerServiceDetails > article.enquireBtn"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", S_ID_expolre);
            Thread.sleep(500);
            S_ID_expolre.click();

                    WebElement S_ID_name = driver.findElement(By.id("e_name"));
                    S_ID_name.sendKeys(Jname);

                    WebElement S_ID_phone = driver.findElement(By.id("e_phone"));
                    S_ID_phone.sendKeys(Jphone);

                    WebElement S_ID_email = driver.findElement(By.id("email_id"));
                    S_ID_email.sendKeys(Jemail);

                    WebElement S_ID_submit = driver.findElement(By.id("send_btn"));
                    S_ID_submit.click();

                    driver.navigate().back();

// Interior Contracting //

        WebElement S_IC = driver.findElement(By.cssSelector("#servicePage > article > article.servicePageMain > article:nth-child(2) > article.servicePageBoxDetails > a"));
        S_IC.click();

            WebElement S_IC_expolre = driver.findElement(By.cssSelector("#innerService > article.container > article > article.innerServiceDetails > article.enquireBtn"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", S_IC_expolre);
            Thread.sleep(500);
            S_IC_expolre.click();

                    WebElement S_IC_name = driver.findElement(By.id("e_name"));
                    S_IC_name.sendKeys(Jname);

                    WebElement S_IC_phone = driver.findElement(By.id("e_phone"));
                    S_IC_phone.sendKeys(Jphone);

                    WebElement S_IC_email = driver.findElement(By.id("email_id"));
                    S_IC_email.sendKeys(Jemail);

                    WebElement S_IC_submit = driver.findElement(By.id("send_btn"));
                    S_IC_submit.click();

                    driver.navigate().back();

// Custom Furnitures //

        WebElement CF = driver.findElement(By.cssSelector("#servicePage > article > article.servicePageMain > article:nth-child(3) > article.servicePageBoxDetails > a"));
        CF.click();

            WebElement CF_expolre = driver.findElement(By.cssSelector("#innerService > article.container > article > article.innerServiceDetails > article.enquireBtn"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CF_expolre);
            Thread.sleep(500);
            CF_expolre.click();

                    WebElement CF_name = driver.findElement(By.id("e_name"));
                    CF_name.sendKeys(Jname);

                    WebElement CF_phone = driver.findElement(By.id("e_phone"));
                    CF_phone.sendKeys(Jphone);

                    WebElement CF_email = driver.findElement(By.id("email_id"));
                    CF_email.sendKeys(Jemail);

                    WebElement CF_submit = driver.findElement(By.id("send_btn"));
                    CF_submit.click();

                    driver.navigate().back();
    }

    @DataProvider(name = "testData")
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Desktop\\excontact.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Object[][] data = new Object[sheet.getLastRowNum()][7];

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);

                // Handle numeric values
                    String name = getCellValueAsString(row.getCell(0));
                    String phone = getCellValueAsString(row.getCell(1));
                    String email = getCellValueAsString(row.getCell(2));
                    String message = getCellValueAsString(row.getCell(3));
                    String Jname = getCellValueAsString(row.getCell(4));
                    String Jphone = getCellValueAsString(row.getCell(5));
                    String Jemail = getCellValueAsString(row.getCell(6));

                    data[rowIndex - 1][0] = name;
                    data[rowIndex - 1][1] = phone;
                    data[rowIndex - 1][2] = email;
                    data[rowIndex - 1][3] = message;
                    data[rowIndex - 1][4] = Jname;
                    data[rowIndex - 1][5] = Jphone;
                    data[rowIndex - 1][6] = Jemail;
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
