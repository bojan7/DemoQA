package Magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckOut {

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
    public void test() throws InterruptedException {

        driver.get(baseURL);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
        //Click on the userName
        driver.findElement(By.id("email")).click();
        //Put in userName
        driver.findElement(By.id("email")).sendKeys("BokiQA@yopmail.com");
        //click on the password
        driver.findElement(By.id("pass")).click();
        //put in password
        driver.findElement(By.id("pass")).sendKeys("Andjela.2021");
        //click on the login button
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button/span"))
                .click();
        //click on the men products
        driver.findElement(By.xpath("//span[contains(text(),'Men')]")).click();
        //select group of the products
        driver.findElement(By.xpath("//a[contains(text(),'Hoodies & Sweatshirts')]")).click();
        //select the article from the list
        driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[4]/ol[1]/li[1]/div[1]/a[1]/span[1]/span[1]/img[1]"))
                .click();
        //select the size of the product
        driver.findElement(By.id("option-label-size-143-item-167")).click();
        Thread.sleep(2000);
//        select the colour of the product
        driver.findElement(By.id("option-label-color-93-item-53")).click();
        Thread.sleep(2000);
        //click on the add to cart button
        driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click();
        Thread.sleep(2000);
        //Verified that is displayed
        //driver.findElement(By.xpath("//header/div[2]/div[1]/a[1]/span[2]")).isDisplayed();
        //Click on the cart
        driver.findElement(By.xpath("//header/div[2]/div[1]/a[1]"))
                .click();
        Thread.sleep(2000);
        //Click on proceed to checkout
        driver.findElement(By.id("top-cart-btn-checkout")).click();
        Thread.sleep(5000);
        //Click on the next button
        driver.findElement(By.xpath("//span[contains(text(),'Next')]"))
                .click();
        Thread.sleep(5000);
        //Click on the
        driver.findElement(By.xpath("//body/div[3]/main[1]/div[2]/div[1]/div[3]/div[4]/ol[1]/li[3]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/button[1]"))
                .click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/p[1]")).isDisplayed();





    }

    @AfterTest
    public void after(){
        driver.quit();
    }



}
