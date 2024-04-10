package SwagLab.SwagLabTEST;

import SwagLab.BeforeAll;
import SwagLab.FUN.AccountFUN;
import org.testng.annotations.Test;

public class SwagLabTEST extends BeforeAll {

    @Test (priority = 1, description = "LogIn Valid account")

    public void logIn() {

        AccountFUN.logInValidAccount(driver, wait);
    }
}
