package DemoQA.Elements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts {

    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        baseURL = "https://demoqa.com/alerts";

    }

    @Test
    public void test() throws InterruptedException {
        //Calling the base URL
        driver.get(baseURL);

        //Click on see Alert
        driver.findElement(By.id("alertButton")).click();
        //Here we basically state driver switch to the  alert and accept what ever it says
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        //Scroll Page down
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,350)", "");

        //Alert after 5 sec
        driver.findElement(By.id("timerAlertButton")).click();
//        Thread.sleep(1000);
        //Here we say wait until a certain condition is done in this case alertIsPresent
        wait.until(ExpectedConditions.alertIsPresent());
        //switch to the alert and accept it
        driver.switchTo().alert().accept();
//        Thread.sleep(1000);

        //Confirm button
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().accept();
//        Thread.sleep(1000);
        driver.findElement(By.id("confirmResult")).isDisplayed();

        //Prompt box
        driver.findElement(By.id("promtButton")).click();
        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Hello All!");
        System.out.println(text);

        //Second way
        //declaring a variable to the alert itself
        Alert alert = driver.switchTo().alert();
        //say with the variable do something
        alert.sendKeys("Hello All");
        //variable accept the alert
        alert.accept();
        Thread.sleep(5000);
//        System.out.println(alert);
        driver.findElement(By.id("promptResult")).isDisplayed();

    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}
