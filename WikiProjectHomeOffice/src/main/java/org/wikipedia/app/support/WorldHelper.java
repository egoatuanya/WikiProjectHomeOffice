package org.wikipedia.app.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.wikipedia.app.browsers.BrowserFactory;
import org.wikipedia.app.pages.BasePage;
import org.wikipedia.app.pages.HomePage;

public class WorldHelper {

    private WebDriver driver = BrowserFactory.getDriver();
    private static BasePage basePage = null;
    private static HomePage landingPage = null;


    public  BasePage getBasePage(){
        if(basePage != null) return basePage;
        return PageFactory.initElements(driver, BasePage.class);
    }

    public  HomePage getLandingPage(){
        if(landingPage != null) return landingPage;
        return PageFactory.initElements(driver, HomePage.class);
    }
}
