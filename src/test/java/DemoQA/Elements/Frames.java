package DemoQA.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Frames {

    public WebDriver driver;

    public WebDriverWait wait;

    public String baseURL;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        baseURL = "https://demoqa.com/frames";

    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseURL);
        //Switch to frame
        driver.switchTo().frame("frame1");
        //Do some testing
        driver.findElement(By.id("sampleHeading")).isDisplayed();
        //Go back to the previous page
        driver.switchTo().defaultContent();

        //Scroll page down
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,350)", "");

        driver.switchTo().frame("frame2");
        driver.findElement(By.id("sampleHeading")).isDisplayed();
        driver.switchTo().defaultContent();


    }

    @AfterTest
    public void after() {
        driver.quit();
    }


}
