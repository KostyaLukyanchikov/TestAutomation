Feature: EpamJdiSiteTestUsingSeleniumCase1
  Scenario: Index Page Testing Login
    Given I open index page
    When I login as user
    Then My personal account name shows