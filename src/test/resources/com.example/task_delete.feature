Feature: task delete functionality

  @positive
  Scenario: Testing the ability to delete a marked task
    Given user enter main page
    And enters task "write a program" and presses Enter key
    When user clicks icon button
    And clicks clear button
    Then a marked task is deleted

#  @positive
#  Scenario: Deleting a task using the trash icon
#    Given user enter main page
#    And inputs task "write a program"
#    And clicks submit button
#    When user clicks this task
#    And clicks a trash icon in the task field
#    Then a task is deleted