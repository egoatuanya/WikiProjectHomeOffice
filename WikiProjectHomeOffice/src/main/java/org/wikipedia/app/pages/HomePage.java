package org.wikipedia.app.pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends BasePage {

    @FindBy(id = "searchLanguage")
    private WebElement language = null;
    @FindBy(id = "searchInput")
    private WebElement searchField = null;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton = null;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    // Search for a specific item
    public HomePage searchForSpecificValue(String value) {
        searchField.sendKeys(value);
        return PageFactory.initElements(driver, HomePage.class);
       // return this;
    }
    // Verify that English language is the default language
    public boolean validateDefaultLanguage(String selectedLanguage) {

        return  language.getText().contains(selectedLanguage);
    }

    // Click on the submit button
    public SearchResultPage clickOnSubmitButton()
    {
        submitButton.click();
        return PageFactory.initElements(driver, SearchResultPage.class);
    }


    // select another language for search
    public HomePage selectOtherLanguageSearch(String otherValue)
    {
        language.click();
        Select select = new Select(language);
        select.selectByVisibleText(otherValue);
        return PageFactory.initElements(driver, HomePage.class);
    }
    //verify that the language is now other language
    public boolean validateOtherLanguage(String otherLanguage) {

        return  language.getText().contains(otherLanguage);
    }

    //Search in other language
    public HomePage searchForOtherValue(String otherLanguagevalue) {
        searchField.sendKeys(otherLanguagevalue);
        return PageFactory.initElements(driver, HomePage.class);
        // return this;
    }



}


