package org.wikipedia.app.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.wikipedia.app.pages.BasePage;
import org.wikipedia.app.pages.HomePage;
import org.wikipedia.app.support.WorldHelper;
import org.wikipedia.app.utilities.Settings;


public class SearchSteps {

    private WorldHelper helper;
    private BasePage basePage;
    private HomePage landingPage;

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
        boolean result = helper.getBasePage().goToHomePage().validateDefaultLanguage(language);
        Assert.assertTrue(result);
    }

    @When("^I enter a \"([^\"]*)\" on the search field$")
    public void iEnterAOnTheSearchField(String value)throws Throwable
    {
        value = Settings.getTestConfig("specific.value");
        landingPage.searchForSpecificValue(value);

    }

}
