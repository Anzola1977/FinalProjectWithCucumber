package com.example.steps;

import com.example.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WorkWithTaskSteps {

    @When("user clicks this task, enters {string} and presses Enter key")
    public void userClicksThisTaskTimesEntersAndPressesEnterKey(String string) {
        MainPage mainPage = new MainPage();
        mainPage.listOfTasks.getFirst().click();
        mainPage.taskFieldInput.click();
        mainPage.taskFieldInput.sendKeys(string, Keys.ENTER);
    }

    @Then("the task is changed to {string}")
    public void theTaskIsChangedTo(String string) {
        assertEquals(string, new MainPage().taskFieldInput.getText());
    }

    @Then("a checkmark appears")
    public void aCheckmarkAppears() {
        assertTrue(new MainPage().iconCheckTaskCompleted.isDisplayed());
    }

    @And("the text color changes to gray and crossed out")
    public void theTextColorChangesToGrayAndCrossedOut() {
        assertTrue(new MainPage().taskCompleted.isDisplayed());
    }

    @Then("the text color of previously marked tasks becomes black and is not crossed out")
    public void theTextColorOfPreviouslyMarkedTasksBecomesBlackAndIsNotCrossedOut() {
        assertTrue(new MainPage().taskFieldInput.isDisplayed());
    }

    @Then("the counter of marked tasks will be equal to the number of tasks")
    public void theCounterOfMarkedTasksWillBeEqualToTheNumberOfTasks() {
        assertEquals(String.valueOf(new MainPage().listOfTasks.size()), new MainPage().counter.getText());
    }

    @Then("the task field changes color to {string} and trash icon appears")
    public void theTaskFieldChangesColor(String color) {
        assertTrue(new MainPage().iconTrash.isDisplayed());
        assertEquals(Color.fromString(color), Color.fromString(new MainPage().editTask.getCssValue("background-color")));
    }
}
