package DemoQA.Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ProgressBar extends DemoWidgets {

    @Test
    public void test() throws InterruptedException {
        //Progress bar
        driver.findElement(By.xpath("//span[contains(text(),'Progress Bar')]")).click();
        //Verify on the right page
        driver.findElement(By.xpath("//h1[contains(text(),'Progress Bar')]")).isDisplayed();

        //Click on the start button
        driver.findElement(By.id("startStopButton")).click();
        //Add statement that if the progress bar is empty or in this case less than 20 %
        //Click on the start button
        if (!driver.findElements(By.xpath("//div[contains(text(),'20%')]")).isEmpty()) {
            driver.findElement(By.id("startStopButton")).click();
        } else {
            System.out.println("Please try again!");
        }
        Thread.sleep(2000);

        //Continue
        driver.findElement(By.id("startStopButton")).click();
        //Wait until expected condition or in this case  reset button appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resetButton"))).isDisplayed();
        //Another confirmation
        driver.findElement(By.xpath("//div[contains(text(),'100%')]")).isDisplayed();
        //Reset button
        driver.findElement(By.id("resetButton")).click();
        //Wait until
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startStopButton"))).isDisplayed();

        driver.findElement(By.xpath("//div[contains(text(),'0%')]")).isDisplayed();


    }


}
