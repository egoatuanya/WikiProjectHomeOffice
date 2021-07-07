package org.wikipedia.app.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.wikipedia.app.browsers.BrowserFactory;
import org.wikipedia.app.pages.BasePage;
import org.wikipedia.app.pages.HomePage;
import org.wikipedia.app.pages.SearchResultPage;
import org.wikipedia.app.pages.WatchListPage;

public class WorldHelper {

    private WebDriver driver = BrowserFactory.getDriver();
    private static BasePage basePage = null;
    private static HomePage landingPage = null;
    private static SearchResultPage searchResultPage = null;
    private static WatchListPage watchListPage = null;


    public  BasePage getBasePage(){
        if(basePage != null) return basePage;
        return PageFactory.initElements(driver, BasePage.class);
    }

    public  HomePage getLandingPage(){
        if(landingPage != null) return landingPage;
        return PageFactory.initElements(driver, HomePage.class);
    }
    public  SearchResultPage getSearchResultPage(){
        if(searchResultPage!= null) return searchResultPage;
        return PageFactory.initElements(driver, SearchResultPage.class);
    }
    public  WatchListPage getWatchListPage(){
        if(watchListPage!= null) return watchListPage;
        return PageFactory.initElements(driver, WatchListPage.class);
    }
}
