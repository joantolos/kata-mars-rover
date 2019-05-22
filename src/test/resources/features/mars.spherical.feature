Feature: When facing the edges of the grid, the rover should move to it's corresponding equivalent on the other side of the planet.

  @All.The.Way.East
  Scenario: Move the Rover forward when being at the edge of the grid on the east
    Given I set the mars rover on the 9, 0 position of the Mars grid
    And it is "east" oriented
    When I perform a "forward" move
    Then the position of the mars rover is 0, 0

  @All.The.Way.West
  Scenario: Move the Rover forward when being at the edge of the grid on the west
    Given I set the mars rover on the 0, 0 position of the Mars grid
    And it is "west" oriented
    When I perform a "forward" move
    Then the position of the mars rover is 9, 0

  @All.The.Way.North
  Scenario: Move the Rover forward when being at the edge of the grid on the north
    Given I set the mars rover on the 0, 9 position of the Mars grid
    And it is "north" oriented
    When I perform a "forward" move
    Then the position of the mars rover is 0, 0

  @All.The.Way.South
  Scenario: Move the Rover forward when being at the edge of the grid on the south
    Given I set the mars rover on the 0, 0 position of the Mars grid
    And it is "south" oriented
    When I perform a "forward" move
    Then the position of the mars rover is 0, 9