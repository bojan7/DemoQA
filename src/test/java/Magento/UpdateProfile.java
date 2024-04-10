package Magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class UpdateProfile {

    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;


    @BeforeTest
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        baseURL = "https://magento.softwaretestingboard.com/";

    }

    @Test
    public void test() throws InterruptedException {
        //Go to base URL
        driver.get(baseURL);
        //sing in
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[2]/a[1]"))
                .click();
        //email
        driver.findElement(By.id("email")).click();
        //enter email
        driver.findElement(By.id("email")).sendKeys("BokiQA@yopmail.com");
        //password
        driver.findElement(By.id("pass")).click();
        //enter password
        driver.findElement(By.id("pass")).sendKeys("Andjela.2021");
        //sign in button
        driver.findElement(By.id("send2")).click();
        //verify welcome is displayed
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[1]/span[1]"))
                .isDisplayed();
        Thread.sleep(5000);
        /*refresh a page*/
        driver.navigate().refresh();
        //dropdown menu on welcome user
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[2]/span[1]/button[1]"))
                .click();
        Thread.sleep(1000);
        //my account
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/ul[1]/li[1]/a[1]"))
                .click();
        //manage addresses
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[5]/div[1]/a[1]"))
                .click();
        //billing addresses
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[2]/a[1]"))
                .click();
        //First name
        driver.findElement(By.id("firstname")).clear();
        //set new input username
        driver.findElement(By.id("firstname")).sendKeys("Andjela");
        //last name
        driver.findElement(By.id("lastname")).clear();
        //set new input lastname
        driver.findElement(By.id("lastname")).sendKeys("Jevtic");
        //company
        driver.findElement(By.id("company")).clear();
        //set new input company
        driver.findElement(By.id("company")).sendKeys("Cake.doo");
        //telephone
        driver.findElement(By.id("telephone")).clear();
        //set new input telephone
        driver.findElement(By.id("telephone")).sendKeys("011/8321-631");
        //street
        driver.findElement(By.id("street_1")).clear();
        //set new input street
        driver.findElement(By.id("street_1")).sendKeys("Sarajevska");
        //street-2
        driver.findElement(By.id("street_2")).clear();
        //set new value Street_2
        driver.findElement(By.id("street_2")).sendKeys("Moj Grad");
        //street_3
        driver.findElement(By.id("street_3")).clear();
        //set new value Street_3
        driver.findElement(By.id("street_3")).sendKeys("BeoGrad");
        //City
        driver.findElement(By.id("city")).clear();
        //set new value City
        driver.findElement(By.id("city")).sendKeys("Beograd");
        //State/Province
        driver.findElement(By.id("region")).clear();
        //set new value State/Province
        driver.findElement(By.id("region")).sendKeys("Rozanci");
        //zip
        driver.findElement(By.id("zip")).clear();
        //set new value zip
        driver.findElement(By.id("zip")).sendKeys("11461");
        //Country
        driver.findElement(By.id("country")).click();
        //set new value Country
        driver.findElement(By.xpath("//option[contains(text(),'Serbia')]")).click();
        //submit
        driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/form[1]/div[1]/div[1]/button[1]"))
                .click();
        driver.findElement(By.xpath("//div[contains(text(),'You saved the address.')]"))
                .isDisplayed();






    }

    @AfterTest
    public void after() {
        driver.quit();
    }


}
