@regression
  Feature: Testing search result page
    As a user
    I want to be able to search for any value of my choice on Wikipedia Homepage
    And I want to be able to select any language of my choice
    So that I can get all my expected search results

    Scenario: Search Test on Wikipedia Page and verify the search result page
      Given I am on Wikipedia Page
      Then I should be able to see the default language is "English Language"
      When I enter a "specific value" on the search field
      And I click on the submit button
      Then  I should be able to validate the first heading of the search result page contains "Home Office"
      And I should be able to verify that the search result page is available in a different "Language"

    Scenario: Search Test in a language different from English
      Given I navigate back to Wikipedia Homepage
      When I select a language different from "English Language"
      Then I should be able to search in a language different from "English"
      And I should be able to validate the results page includes a link to the version in "English"


