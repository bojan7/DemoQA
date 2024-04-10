package Magento;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccount {


    public WebDriver driver;

    public WebDriverWait wait;

    public String baseURL;

    @BeforeTest
    public void befor() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        baseURL = "https://magento.softwaretestingboard.com/";


    }


    @Test
    public void test() {
        //Add this to set up for generating random email addresses
        String prefix = "boki";
        String nameMail = prefix + RandomStringUtils
                .randomAlphabetic(5).toLowerCase();
        //Till this
        driver.get(baseURL);
        driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
        driver.findElement(By.id("firstname")).click();
        driver.findElement(By.id("firstname")).sendKeys("Bojan");
        driver.findElement(By.id("lastname")).click();
        driver.findElement(By.id("lastname")).sendKeys("Jevtic");
        driver.findElement(By.id("email_address")).click();
        //Here in the send keys we put in the function to be called
        driver.findElement(By.id("email_address")).sendKeys(nameMail + "@yopmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Andjela.2021");
        driver.findElement(By.id("password-confirmation")).click();
        driver.findElement(By.id("password-confirmation")).sendKeys("Andjela.2021");
        driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]/span[1]"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"))
                .isDisplayed();


    }


    @AfterTest
    public void after() {
        driver.quit();
    }


}
