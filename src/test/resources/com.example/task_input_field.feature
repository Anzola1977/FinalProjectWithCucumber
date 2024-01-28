Feature: The task input field functionality

  @positive
  Scenario Outline: Input scenarios with submit button
    Given user enter main page
    When user enters tasks "<tasks>"
    And clicks submit button
    Then user's task is added to his task list last

    Examples:
      | tasks                  |
      | write a program        |
      | ein Programm schreiben |
      | write a program        |
      | 12345677               |
      | /*%;:+                 |
      | 0                      |
      | 12.45                  |
      |                        |

  @positive
  Scenario: Input scenarios with Enter key
    Given user enter main page
    When user clicks in the task input field
    And enters task "программирование" and presses Enter key
    Then user's task is added to his task list last

  @negative
  Scenario: The task input field is not available for input
    Given user enter main page
    When user clicks the submit button 20 times
    Then empty tasks are added to task list
    And the task input field is no longer available