package org.wikipedia.app.pages;



import org.wikipedia.app.utilities.Settings;
import org.wikipedia.app.waits.WebWaits;
import org.wikipedia.app.webControls.ClickControl;
import org.wikipedia.app.webControls.TextFieldsControl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;




    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }
    //Navigate to the wikipedia homepage
    public HomePage goToHomePage() {
        String baseUrl = Settings.getTestConfig("base.url");
        driver.navigate().to(baseUrl);
        long timeout = Long.parseLong(Settings.getTestConfig("browser.time"));
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.navigate().refresh();

        return PageFactory.initElements(driver, HomePage.class);
    }

}
