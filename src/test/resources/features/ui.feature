Feature: The UI is simply printing text statements on console.

  @Exit
  Scenario: Print the exit message
    Given The console from the Mars Rover
    When I perform the exit operation
    Then the system prints "Disconnected from Mars rover"

  @Prompt
  Scenario: Print the prompt message
    Given The console from the Mars Rover
    When I perform the prompt operation
    Then the system prints "Your rover is located by default at the 0, 0 position and it's facing North."

  @Random.Text
  Scenario: Print random text
    Given The console from the Mars Rover
    When I perform the print operation with the text "Random text"
    Then the system prints "Random text"