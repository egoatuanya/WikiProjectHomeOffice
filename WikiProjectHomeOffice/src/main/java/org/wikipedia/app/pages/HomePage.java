package org.wikipedia.app.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.wikipedia.app.webControls.DropDownControl;
import org.wikipedia.app.webControls.TextFieldsControl;

public class HomePage extends BasePage {

    @FindBy(id = "searchLanguage")
    private WebElement language = null;
    @FindBy(id = "searchInput")
    private WebElement searchField = null;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage searchForSpecificValue(String value) {
        searchField.sendKeys();
//        TextFieldsControl.enterText(searchField, value);
        return this;
    }

    public boolean validateDefaultLanguage(String selectedLanguage) {
//        DropDownControl.selectDropDownByVisibleText(language, selectedLanguage);
        return language.getText().contains(selectedLanguage);
    }

}


