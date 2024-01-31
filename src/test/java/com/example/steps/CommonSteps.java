package com.example.steps;

import com.example.context.Context;
import com.example.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonSteps {

    @Given("user enter main page")
    public void user_enter_main_page() {
        Context.scenario.log("User entered main page");
    }

    @When("enters task {string} and presses Enter key")
    public void user_enters_task(String string) {
        MainPage mainPage = new MainPage();
        mainPage.newTaskInput.sendKeys(string, Keys.ENTER);
    }

    @When("user clicks this task")
    public void user_clicks_this_task() {
        new MainPage().listOfTasks.getFirst().click();
    }

    @Then("user's task is added to his task list last")
    public void user_s_task_is_added_to_his_task_list_last() {
        Context.wait.until(ExpectedConditions.visibilityOfAllElements(new MainPage().listOfTasks));
        assertEquals(1, new MainPage().listOfTasks.size());
    }

    @When("clicks submit button")
    public void clicks_submit_button() {
        new MainPage().submitButton.click();
    }

    @When("user clicks in the task input field")
    public void user_clicks_in_the_task_input_field() {
        new MainPage().newTaskInput.click();
    }

    @Then("a task is deleted")
    public void aMarkedTaskIsDeleted() {
        assertTrue(new MainPage().listOfTasks.isEmpty());
    }

    @And("user enters tasks {string} and clicks submit button")
    public void userEntersTasksAndClicksSubmitButton(String tasks) {
        MainPage mainPage = new MainPage();
        mainPage.newTaskInput.sendKeys(tasks);
        mainPage.submitButton.click();
    }

    @And("user clicks icon button in all tasks")
    public void clicksIconButtonInAllTasks() {
        for (int i = 0; i < new MainPage().listOfTasks.size(); i++) {
            new MainPage().iconCheck.click();
        }
    }

    @When("user clicks icon button")
    public void userClicksIconButton() {
        new MainPage().iconCheck.click();
    }

}
