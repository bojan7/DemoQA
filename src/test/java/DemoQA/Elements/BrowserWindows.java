package DemoQA.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindows {

    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        baseURL = "https://demoqa.com/browser-windows";

    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseURL);
        //New Tub button
        driver.findElement(By.id("tabButton")).click();

        //When we have multiple Tabs open we can use List to move through them
        List<String> myURL = new ArrayList(driver.getWindowHandles());
        //Switch to one of the tabs
        driver.switchTo().window(myURL.get(1));
        //declare a variable to it so that we can store the current URL and check if it is good
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        //Check to see if the conditions are true or not
        //We can use this on multiple way like when changing username to see if it really changed of not
        Assert.assertEquals(currentURL, "https://demoqa.com/sample");
        //or we can use this statement
        Assert.assertNotEquals(currentURL, "This is false Address");


        // driver.switchTo().window("https://demoqa.com/sample");


    }

    @AfterTest
    public void after() {

        driver.quit();
    }

}
