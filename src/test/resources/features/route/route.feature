Feature: Route calculation
  As a user, I want to get my calculated routes based on my origin and destination

  Scenario: Route calculation
    
    Given I am a user who wants request a route
    When I request a route with an origin and a destination
    Then I should get the calculated routes