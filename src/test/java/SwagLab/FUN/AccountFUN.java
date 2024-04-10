package SwagLab.FUN;

import SwagLab.POM.LogInObject;
import Test.BeforeAll;
import Test.POM.PLPHeaderObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountFUN extends BeforeAll {


    public static void logInValidAccount(WebDriver driver, WebDriverWait wait) {


        wait.until(ExpectedConditions.visibilityOfElementLocated(LogInObject.logInPage));

        driver.findElement(LogInObject.usernameField).sendKeys("standard_user");
        driver.findElement(LogInObject.passwordField).sendKeys("secret_sauce");
        driver.findElement(LogInObject.logInButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(PLPHeaderObject.hamburgerMenu));

    }
}
