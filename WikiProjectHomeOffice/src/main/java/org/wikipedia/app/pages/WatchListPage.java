package org.wikipedia.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.wikipedia.app.utilities.Settings;

public class WatchListPage extends BasePage {


    public WatchListPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = "//button[@text = 'Log In']")
    WebElement loginElement;
    @FindBy(xpath = "//input[@type = 'email']")
    WebElement enterEmailElement;
    @FindBy(xpath = "//input[@type = 'password']")
    WebElement enterPasswordElement;

    public WatchListPage loginToCoinMarket()
    {
        String username = Settings.getTestConfig("username");
        String password = Settings.getTestConfig("password");
        loginElement.click();
        enterEmailElement.sendKeys(username);
        enterPasswordElement.sendKeys(password);
        loginElement.click();
        return PageFactory.initElements(driver, WatchListPage.class);

    }


}
