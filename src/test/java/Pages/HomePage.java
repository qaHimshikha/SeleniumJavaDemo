package Pages;

import Enums.WebElementEnums.NavbarHeaderLinkEnums;
import HelperMethods.FetchPropertiesFileData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    FetchPropertiesFileData dataProp = new FetchPropertiesFileData();
    WebDriver driver;

    String navbarHeaderLinks = "//div[@class='header-links']/ul/li/a[contains(@class,'%s')]";
    By verifyRegisterPageTitle = By.xpath("//div[@class='page-title']/h1");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToRegisterPage() {
        driver.findElement(By.xpath(String.format(navbarHeaderLinks, NavbarHeaderLinkEnums.RegisterHeaderLinkClass.value))).click();
        Assert.assertEquals(driver.findElement(verifyRegisterPageTitle).getText(), dataProp.fetchPropertiesData("Register_Page_Title"));
    }
}