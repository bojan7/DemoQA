package DemoQA.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Upload extends DemoButtons {


    @Test
    public void test() throws InterruptedException {

        //Upload
        driver.findElement(By.xpath("//span[contains(text(),'Upload and Download')]")).click();
        //put the Button ito the variable
        WebElement key = driver.findElement(By.id("uploadFile"));
        //Upload a file
        key.sendKeys("C:\\Users\\Boki\\Desktop");
        //Confirm it is displayed
        driver.findElement(By.id("uploadedFilePath")).isDisplayed();
        Thread.sleep(2000);

        String url = driver.getCurrentUrl();
        System.out.println("The current page you are no is: " + url);

        //Download
        driver.findElement(By.id("downloadButton")).click();
















    }

}
