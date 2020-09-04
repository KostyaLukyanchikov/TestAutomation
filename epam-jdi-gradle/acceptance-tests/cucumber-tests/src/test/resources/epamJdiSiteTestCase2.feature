Feature: EpamJdiSiteTestUsingSeleniumCase2

  Scenario: Login As User
    Given I open epam index page
    When I login as 'user'
    Then My personal account name shows

  Scenario: Navigate To Different Elements Page From Header
    Given I am on any page on Epam Jdi
    When I click service button on header
    Then Header service dropdown shows
    And I click different elements page button
    And Different elements page opens

  Scenario: Check Number Of Check Boxes On Different Elements Page
    Given I am on any page on Epam Jdi
    When Navigate to different elements page
    Then Number check boxes should be 4

  Scenario: Check Number Of Radio Buttons On Different Elements Page
    Given I am on any page on Epam Jdi
    When Navigate to different elements page
    Then Number radio buttons should be 4

  Scenario: Check Number Of Drop Downs On Different Elements Page
    Given I am on any page on Epam Jdi
    When Navigate to different elements page
    Then Number drop downs should be 1

  Scenario: Check Number Of Buttons On Different Elements Page
    Given I am on any page on Epam Jdi
    When Navigate to different elements page
    Then Number buttons should be 2



#  Scenario: Check Service Drop Down Elements From Header
#    Given I am on any page on Epam Jdi
#    And I login as 'user'
#    When I click service button on header
#    Then Header service drop down elements should be displayed
#      |SUPPORT|
#      |DATES|
#      |SEARCH|
#      |COMPLEX TABLE|
#      |SIMPLE TABLE|
#      |TABLE WITH PAGES|
#      |DIFFERENT ELEMENTS|

#  Scenario: Check Service Drop Down Elements From Left Side Bar
#    Given I am on any page on Epam Jdi
#    And I login as 'user'
#    When I click service button on left side bar
#    Then Left side bar Service drop down elements should be displayed
#      |SUPPORT|
#      |DATES|
#      |SEARCH|
#      |COMPLEX TABLE|
#      |SIMPLE TABLE|
#      |TABLE WITH PAGES|
#      |DIFFERENT ELEMENTS|

#  Scenario: Select Check Box
#    Given I am on different elements page
#    When I select 'checkbox' checkbox
#    Then Check box *checkbox* should be selected
#
#  Scenario: Select Radio Button
#    Given I am on different elements page
#    When I select *radio button* radio button
#    Then Radio button *radio button* should be selected
#
#  Scenario: Select Drop Down Color
#    Given I am on different elements page
#    When I select *drop down color* drop down color
#    Then Drop down color *drop down color* should be selected