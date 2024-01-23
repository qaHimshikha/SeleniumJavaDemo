package Pages.Config;

import HelperMethods.FetchPropertiesFileData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BaseClass {
    FetchPropertiesFileData dataProp = new FetchPropertiesFileData();
    WebDriver driver;
    protected PageFactory pageFactory;

    public void navigateToNopcommerce() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String nopcommerceUrl = dataProp.fetchPropertiesData("URL");
        driver.navigate().to(nopcommerceUrl);
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(), nopcommerceUrl);
        pageFactory = new PageFactory(driver);
    }

    public void closeBrowserWindow() {
        driver.quit();
    }
}