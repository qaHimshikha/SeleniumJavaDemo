package TestCases;

import Pages.Config.BaseClass;
import org.testng.annotations.Test;

public class VerifyUserIsAbleToRegister extends BaseClass {
    @Test
    public void verifyUserIsAbleToRegister() {
        navigateToNopcommerce();
        pageFactory.getHomePage().navigateToRegisterPage();
        pageFactory.getRegisterPage().userRegisters();
        closeBrowserWindow();
    }
}