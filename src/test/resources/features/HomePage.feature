Feature: User navigates to the Dashboard Page

  @AutomatedTests
  Scenario Outline: Verify that user is able to navigate to the Dashboard Page
    Given User is at the start screen
    When User clicks on the "Get Started" button
    Then User lands on the league selection page
    And User selects a "<league>"
    And User clicks on the "Continue" button
    Then User clicks on the "Maybe Later" button
    Then User lands on team selection page
    Then User selects a "<team>"
    Then User clicks on the "Continue" button
    And User lands on notifications page
    Then User clicks on the "Continue" button
    Then User clicks on the "Maybe Later" button
    And User clicks on "Allow" Notifications
    Then User lands on the Dashboard Page
    And User verifies if selected "<league>" and "<team>" are getting displayed on the dashboard page

    Examples:
      | league | team |  |
      | NHL    | Tor  |  |

  @AutomatedTests
  Scenario Outline: Validate the flow of league,team or player page and functionality of back navigation
    Given User starts from the Dashboard Page
    When User selects a "<selection>" from SearchBar
    Then User validates the header title of the "<selection>"
    And User verifies the sub tabs of the "<selection>"
    Then User clicks on a "<subTab>"
    And User verifies if back button is displayed in the header
    And User clicks on the "Navigate up" icon
    And User lands on the SearchBar Page
    And User clicks on the "Navigate up" icon
    Then User lands on the Dashboard Page

    Examples:
      | selection         | subTab     |
      | Cristiano Ronaldo | SEASON     |
      | Manchester United | TEAM STATS |


