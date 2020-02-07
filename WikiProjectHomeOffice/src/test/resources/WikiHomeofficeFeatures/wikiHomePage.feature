@regression
  Feature: Testing search result page
    As a user
    I want to be able to search for any value of my choice on Wikipedia Homepage
    And I want to be able to select any language of my choice
    So that I can get all my expected search results

    Scenario: Search Test on Wikipedia Page
      Given I am on Wikipedia Page
      Then I should be able to see the default language is "English Language"
      When I enter a "specific value" on the search field
