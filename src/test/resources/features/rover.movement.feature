Feature: Basic movement of the Rover vehicle: Forward and backward when facing every possible direction.

  @Forward.North
  Scenario: Move the Rover forward when facing north
    Given I set the mars rover on the 0, 0 position of the Mars grid
    And it is "n" oriented
    When I perform a "f" move
    Then the position of the mars rover is 0, 1

  @Backward.North
  Scenario: Move the Rover backward when facing north
    Given I set the mars rover on the 2, 2 position of the Mars grid
    And it is "n" oriented
    When I perform a "b" move
    Then the position of the mars rover is 2, 1

  @Forward.South
  Scenario: Move the Rover forward when facing south
    Given I set the mars rover on the 99, 99 position of the Mars grid
    And it is "s" oriented
    When I perform a "f" move
    Then the position of the mars rover is 99, 98

  @Backward.South
  Scenario: Move the Rover backward when facing south
    Given I set the mars rover on the 98, 98 position of the Mars grid
    And it is "s" oriented
    When I perform a "b" move
    Then the position of the mars rover is 98, 99

  @Forward.East
  Scenario: Move the Rover forward when facing east
    Given I set the mars rover on the 0, 0 position of the Mars grid
    And it is "e" oriented
    When I perform a "f" move
    Then the position of the mars rover is 1, 0

  @Backward.East
  Scenario: Move the Rover backward when facing west
    Given I set the mars rover on the 2, 2 position of the Mars grid
    And it is "e" oriented
    When I perform a "b" move
    Then the position of the mars rover is 1, 2

  @Forward.West
  Scenario: Move the Rover forward when facing east
    Given I set the mars rover on the 2, 2 position of the Mars grid
    And it is "w" oriented
    When I perform a "f" move
    Then the position of the mars rover is 1, 2

  @Backward.West
  Scenario: Move the Rover backward when facing west
    Given I set the mars rover on the 2, 2 position of the Mars grid
    And it is "w" oriented
    When I perform a "b" move
    Then the position of the mars rover is 3, 2