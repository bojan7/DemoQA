package Magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogInInvalidAccount {



    public WebDriver driver;

    public WebDriverWait wait;

    public String baseURL;


    @BeforeTest
    public void valid() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        baseURL = "https://magento.softwaretestingboard.com/";

    }

    @Test
    public void test() {

        driver.get(baseURL);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("bokStari@gmail.com");
        driver.findElement(By.id("pass")).click();
        driver.findElement(By.id("pass")).sendKeys("Andjela.2021");
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button/span"))
                .click();
        driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect or your account ')]"))
                .isDisplayed();
    }

    @AfterTest
    public void after() {
        driver.quit();
    }




}
