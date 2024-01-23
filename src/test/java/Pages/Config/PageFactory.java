package Pages.Config;

import Pages.HomePage;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public RegisterPage getRegisterPage() {
        if (registerPage == null) {
            registerPage = new RegisterPage(driver);
        }
        return registerPage;
    }
}