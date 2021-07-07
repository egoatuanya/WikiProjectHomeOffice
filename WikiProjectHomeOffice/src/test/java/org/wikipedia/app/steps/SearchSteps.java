package org.wikipedia.app.steps;

import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.wikipedia.app.pages.BasePage;
import org.wikipedia.app.pages.HomePage;
import org.wikipedia.app.pages.SearchResultPage;
import org.wikipedia.app.pages.WatchListPage;
import org.wikipedia.app.support.WorldHelper;
import org.wikipedia.app.utilities.Settings;


public class SearchSteps {

    private WorldHelper helper;
    private BasePage basePage;
    private HomePage landingPage;
    private SearchResultPage searchResultPage;
    private WatchListPage watchListPage;

    public SearchSteps(WorldHelper helper){this.helper = helper;}

    @Given("^I am on Wikipedia Page$")
    public void iAmOnWikipediaPage()
    {
        landingPage = helper.getBasePage().goToHomePage();

    }

    @Then("^I should be able to see the default language is \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeTheDefaultLanguageIs(String language)
    {
        language = Settings.getTestConfig("English.language");
       boolean result = landingPage.validateDefaultLanguage(language);
        Assert.assertTrue(result);
    }

    @When("^I enter a \"([^\"]*)\" on the search field$")
    public void iEnterAOnTheSearchField(String value)throws Throwable
    {
        value = Settings.getTestConfig("specific.value");
        landingPage.searchForSpecificValue(value);
    }


    @And("^I click on the submit button$")
    public void iClickOnTheSubmitButton() {

        searchResultPage = landingPage.clickOnSubmitButton();
    }


    @Then("^I should be able to validate the first heading of the search result page contains \"([^\"]*)\"$")
    public void iShouldBeAbleToValidateTheFirstHeadingOfTheSearchResultPageContains(String resultHeader)  {
        resultHeader = Settings.getTestConfig("specific.value");
        searchResultPage.validateSearchResultPage(resultHeader);

    }

    @And("^I should be able to verify that the search result page is available in a different \"([^\"]*)\"$")
    public void iShouldBeAbleToVerifyThatTheSearchResultPageIsAvailableInADifferent(String otherLanguage)  {
        otherLanguage = Settings.getTestConfig("other.language");
        searchResultPage.verifyOtherLanguages(otherLanguage);

    }


    @Given("^I navigate back to Wikipedia Homepage$")
    public void iNavigateBackToWikipediaHomepage() {
        landingPage = helper.getBasePage().goToHomePage();

    }
    @When("^I select a language different from \"([^\"]*)\"$")
    public void iSelectALanguageDifferentFrom(String otherValue)  {
        otherValue = Settings.getTestConfig("select.otherLanguage");
        landingPage.selectOtherLanguageSearch(otherValue);

    }
    @Then("^I should be able to search in a language different from \"([^\"]*)\"$")
    public void iShouldBeAbleToSearchInALanguageDifferentFrom(String diffLanguageValue)  {
        diffLanguageValue = Settings.getTestConfig("otherValue.search");
        searchResultPage = landingPage.searchForOtherValue(diffLanguageValue).clickOnSubmitButton();

    }



    @And("^I should be able to validate the results page includes a link to the version in \"([^\"]*)\"$")
    public void iShouldBeAbleToValidateTheResultsPageIncludesALinkToTheVersionIn(String englishLink)

    {
        englishLink = Settings.getTestConfig("english.link");
        searchResultPage.verifyLinkInEnglish(englishLink);
    }

    @Given("^I navigate to coinmarket cap website$")
    public void iNavigateToCoinmarketCapWebsite() throws Throwable {
        landingPage = helper.getBasePage().goToHomePage();
    }
    @Given("^I login with the correct credentials$")
    public void i_login_with_the_correct_credentials() throws Throwable {
        helper.getWatchListPage().loginToCoinMarket();

    }

    @When("^I click on the star icon for the first five coins$")
    public void i_click_on_the_star_icon_for_the_first_five_coins() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the following coins are added the watchlist Bitcoin$")
    public void the_following_coins_are_added_the_watchlist_Bitcoin() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the following coins are added the watchlist Ethereum$")
    public void the_following_coins_are_added_the_watchlist_Ethereum() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the following coins are added the watchlist Tether$")
    public void the_following_coins_are_added_the_watchlist_Tether() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the following coins are added the watchlist Binance Coin$")
    public void the_following_coins_are_added_the_watchlist_Binance_Coin() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the following coins are added the watchlist Cardano$")
    public void the_following_coins_are_added_the_watchlist_Cardano() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }




}


