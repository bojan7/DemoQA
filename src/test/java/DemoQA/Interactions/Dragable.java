package DemoQA.Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Dragable extends DemoInteractions {

    @Test
    public void test() throws InterruptedException {

        //Simple
        driver.findElement(By.xpath("//span[contains(text(),'Droppable')]")).click();
        //Verify that your on a good page
        driver.findElement(By.xpath("//h1[contains(text(),'Droppable')]")).isDisplayed();

        //Create an Action
        Actions act = new Actions(driver);

        //Add variables to the elements so we can manipulate them
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement dropp = driver.findElement(By.id("droppable"));

        //Perform the action here
        act.dragAndDrop(drag, dropp).perform();
        Thread.sleep(2000);

        //Confirm it is done
        if (!driver.findElement(By.id("droppable")).isDisplayed()){
            System.out.println("You didn't perform drag!");
        }   else System.out.println("Success!!!");

        //Accept
        //click tub accept
        driver.findElement(By.id("droppableExample-tab-accept")).click();
        //confirm your there
        driver.findElement(By.xpath("//h1[contains(text(),'Droppable')]")).isDisplayed();

        //Add actions
        Actions doIt = new Actions(driver);

        //Declare variables to the elements
        WebElement acc = driver.findElement(By.xpath("//div[@id='acceptable']"));
//        WebElement notAcc = driver.findElement(By.id("notAcceptable"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));

        //Action
        doIt.dragAndDrop(acc, drop).perform();

        //Check if done
        if (driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]")).isDisplayed()){
            System.out.println("Good job!");
        } else {
            System.out.println("Better luck next time!");
        }

        //Prevent Propagation
        //Click on tab Propagation
        driver.findElement(By.id("droppableExample-tab-preventPropogation")).click();
        //Confirm on a right page
        driver.findElement(By.xpath("//p[contains(text(),'Inner droppable (not greedy)')]"))
                .isDisplayed();

        //Action
        Actions propagation = new Actions(driver);

        //Declare a variable to the elements
        WebElement text = driver.findElement(By.id("dragBox"));
        WebElement notGreedyIner = driver.findElement(By.id("notGreedyInnerDropBox"));

        //Do something
        propagation.dragAndDrop(text, notGreedyIner).perform();

        //Verify success
        driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/p[1]"))
                .isDisplayed();

        //refresh a page
        driver.navigate().refresh();

        Thread.sleep(2000);

        //Click on tab Propagation
        driver.findElement(By.id("droppableExample-tab-preventPropogation")).click();

        WebElement text1 = driver.findElement(By.id("dragBox"));
        WebElement notGreedyOuter = driver.findElement(By.id("notGreedyDropBox"));
        //Do something
        propagation.dragAndDrop(text1, notGreedyOuter).perform();

        //Verify success
        driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]"))
                .isDisplayed();




    }

}
