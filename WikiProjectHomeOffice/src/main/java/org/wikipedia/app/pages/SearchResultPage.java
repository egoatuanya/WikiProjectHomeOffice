package org.wikipedia.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
    @FindBy(id = "firstHeading")
    private WebElement searchResultPageHeader = null;
    @FindBy(id = "p-lang-label")
    private WebElement searchResultOtherLanguages = null;
    @FindBy(linkText = "https://en.wikipedia.org/wiki/Pasta")
    private WebElement linkToVersionInEnglish = null;

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }
    //Validate that the first heading of the search results page matches the search string
    public boolean validateSearchResultPage(String englishResultHeader)
    {
        return searchResultPageHeader.getText().equalsIgnoreCase(englishResultHeader);
    }
    //Verify that the search results page is available in other languages.  Verify that there is a languages heading on the right hand side of the page
    public boolean verifyOtherLanguages(String otherLanguages)
    {
        return searchResultOtherLanguages.getText().contains(otherLanguages);
    }

    // Validate that the search results page in the new language includes a link to the version in English.
    public boolean verifyLinkInEnglish(String english)
    {
        return linkToVersionInEnglish.getText().equals(english);
    }
}
