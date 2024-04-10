package DemoQA.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Buttons extends DemoButtons {

    @Test
    public void Test() {
        //Chose buttons in the menu
        driver.findElement(By.id("item-4")).click();
        //Verify on a right page
        driver.findElement(By.xpath("//h1[contains(text(),'Buttons')]")).isDisplayed();

        //Set action
        Actions doble = new Actions(driver);

        //Declare a variable to the element
        WebElement button = driver.findElement(By.id("doubleClickBtn"));
        //Do something - double-click on the button
        doble.doubleClick(button).perform();
        //Confirm success
        driver.findElement(By.id("doubleClickMessage")).isDisplayed();


        //Right Click on n element
        Actions actions = new Actions(driver);

        //Declare a variable to the element
        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        //Do something - right click on it
        actions.contextClick(rightClick).perform();
        //Verify the success
        driver.findElement(By.id("rightClickMessage")).isDisplayed();

        //Click me button
        //Click on the button
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/button[1]")).click();
        //Verify the success message appears
        driver.findElement(By.id("dynamicClickMessage")).isDisplayed();




    }
}
