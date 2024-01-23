package Pages;

import Enums.WebElementEnums.RegisterPageEnums;
import HelperMethods.FetchExcelFileData;
import HelperMethods.FetchPropertiesFileData;
import HelperMethods.GetUniqueValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterPage {
    FetchPropertiesFileData dataProp = new FetchPropertiesFileData();
    FetchExcelFileData excelFileData = new FetchExcelFileData();
    GetUniqueValue getUniqueValue = new GetUniqueValue();

    WebDriver driver;

    String genderRadioFieldXpath = "//div[@class='gender']/span[@class='%s']/input";
    String registerInputFieldsXpath = "//div[@class='inputs']/input[@name='%s']";
    String dateOfBirthDropdownXpath = "//select[@name='%s']";
    By registerButton = By.xpath("//button[@name='register-button']");
    By registrationCompleteMessage = By.xpath("//div[@class='result']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void userRegisters() {
        driver.findElement(By.xpath(String.format(genderRadioFieldXpath, RegisterPageEnums.MaleRadioFieldClass.value))).click();
        driver.findElement(By.xpath(String.format(registerInputFieldsXpath, RegisterPageEnums.FirstNameInputFieldName.value))).sendKeys(excelFileData.fetchUserRegisterDataExcel(2, 0));
        driver.findElement(By.xpath(String.format(registerInputFieldsXpath, RegisterPageEnums.LastNameInputFieldName.value))).sendKeys(excelFileData.fetchUserRegisterDataExcel(2, 1));
        Select dayDropdown = new Select(driver.findElement(By.xpath(String.format(dateOfBirthDropdownXpath, RegisterPageEnums.DayDropdownName.value))));
        dayDropdown.selectByValue(dataProp.fetchPropertiesData("Day_Of_Birth"));
        Select monthDropdown = new Select(driver.findElement(By.xpath(String.format(dateOfBirthDropdownXpath, RegisterPageEnums.MonthDropdownName.value))));
        monthDropdown.selectByValue(dataProp.fetchPropertiesData("Month_Of_Birth"));
        Select yearDropdown = new Select(driver.findElement(By.xpath(String.format(dateOfBirthDropdownXpath, RegisterPageEnums.YearDropdownName.value))));
        yearDropdown.selectByValue(dataProp.fetchPropertiesData("Year_Of_Birth"));
        driver.findElement(By.xpath(String.format(registerInputFieldsXpath, RegisterPageEnums.EmailInputFieldName.value))).sendKeys(dataProp.fetchPropertiesData("Email").replace("{uniqueValue}", getUniqueValue.getUniqueValue()));
        driver.findElement(By.xpath(String.format(registerInputFieldsXpath, RegisterPageEnums.PasswordInputFieldName.value))).sendKeys(excelFileData.fetchUserRegisterDataExcel(2, 2));
        driver.findElement(By.xpath(String.format(registerInputFieldsXpath, RegisterPageEnums.ConfirmPasswordInputFieldName.value))).sendKeys(excelFileData.fetchUserRegisterDataExcel(2, 2));
        driver.findElement(registerButton).click();
        Assert.assertEquals(driver.findElement(registrationCompleteMessage).getText(), dataProp.fetchPropertiesData("Register_Completion_Message"));
    }
}