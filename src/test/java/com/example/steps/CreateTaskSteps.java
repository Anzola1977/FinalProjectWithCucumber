package com.example.steps;

import com.example.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CreateTaskSteps {

    @When("user enters tasks {string}")
    public void user_enters_tasks(String string) {
        MainPage mainPage = new MainPage();
        mainPage.newTaskInput.sendKeys(string);
    }

    @When("user clicks the submit button {int} times")
    public void user_clicks_the_submit_button_times(Integer times) {
        MainPage mainPage = new MainPage();
        for (int i = 0; i < times; i++) {
            mainPage.submitButton.click();
        }
    }

    @Then("empty tasks are added to task list")
    public void empty_tasks_are_added_to_task_list() {
        assertEquals(20, new MainPage().listOfTasks.size());
    }

    @Then("the task input field is no longer available")
    public void the_task_input_field_is_no_longer_available() {
        assertFalse(new MainPage().newTaskInput.isDisplayed());
    }
}
