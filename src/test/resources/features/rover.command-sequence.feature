Feature: The Rover vehicle is able to process a sequence of commands.

  @Command.Sequence
  Scenario: The Rover vehicle accepts a command sequence.
    Given I set the mars rover on the 0, 0 position of the Mars grid
    And it is "north" oriented
    When I send the command sequence "ffef"
    Then the position of the mars rover is 1, 2

  @Bad.Command.Sequence
  Scenario: The Rover vehicle does not accept a bad command sequence.
    Given I set the mars rover on the 0, 0 position of the Mars grid
    And it is "north" oriented
    When I send the command sequence "Xef"
    Then the position of the mars rover is 0, 0

  @Rover.Founding.Obstacle
  Scenario: The Rover vehicle aborts command when obstacle is found
    Given I set the mars rover on the 0, 0 position of the Mars grid
    And it is "north" oriented
    Then the rover should abort sequence when obstacle found