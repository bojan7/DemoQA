package DemoQA.Widgets;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatePicker extends DemoWidgets {

    @Test
    public void Test() throws InterruptedException {
        //Date picker button
        driver.findElement(By.xpath("//span[contains(text(),'Date Picker')]")).click();
        //Confirm on a right page
        driver.findElement(By.xpath("//h1[contains(text(),'Date Picker')]")).isDisplayed();

        //Pick first calendar
        driver.findElement(By.id("datePickerMonthYearInput")).click();
        //Click on  month
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/select[1]"))
                .click();
        //Chose month
        driver.findElement(By.xpath("//option[contains(text(),'January')]")).click();
        //Click on year
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/select[1]"))
                .click();
        //Chose month
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/select[1]"))
                .click();
        //Chose Month
        driver.findElement(By.xpath("//option[contains(text(),'1989')]")).click();
        //Chose date
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[3]/div[5]"))
                .click();

        //Confirm value first way
        driver.findElement(By.id("datePickerMonthYearInput")).getCssValue("01/19/1989");

        //Confirm value second way
        String myValue =driver.findElement(By.id("datePickerMonthYearInput")).getAttribute("value");
        Thread.sleep(3000);
        Assert.assertEquals(myValue,"01/19/1989");

        //Second Calendar//

        //Click on calendar
        driver.findElement(By.id("dateAndTimePickerInput")).click();
        //Month
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]"))
                .click();
        //Chose Month
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]"))
                .click();
        //Year
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/span[1]"))
                .click();
        //Chose Year
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[7]"))
                .click();
        //Chose Date
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[3]/div[5]"))
                .click();
        //Chose Time
        driver.findElement(By.xpath("//li[contains(text(),'10:30')]")).click();
        Thread.sleep(5000);
        //Add element ot the variable
        String myDate = driver.findElement(By.id("dateAndTimePickerInput")).getAttribute("value");
        //Confirm the outcome
        Assert.assertEquals(myDate, "January 19, 1989 10:30 AM");
















    }


}
