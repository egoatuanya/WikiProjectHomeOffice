package org.wikipedia.app.pages;



import org.wikipedia.app.waits.WebWaits;
import org.wikipedia.app.webControls.ClickControl;
import org.wikipedia.app.webControls.TextFieldsControl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class BasePage {

    protected WebDriver webDriver;

    @FindBy(id = "username")
    private WebElement usernameElement = null;
    @FindBy(id = "password")
    private WebElement passwordElement = null;
    @FindBy(css = "#kc-form-login > input.submit")
    private WebElement loginButton = null;
    private Random random = new Random();
    protected String randomNo = Integer.toString(random.nextInt(100) + 1);
    @FindBy(css = "body > div.col-xs-11.col-sm-4.alert.alert-success.animated.fadeInDown")
    protected WebElement alert = null;


    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage goToHomePage() {
        return PageFactory.initElements(webDriver, HomePage.class);
    }
//    public void scrollToBottomOfPage() {
//        ((JavascriptExecutor) webDriver)
//                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
//    }
}
