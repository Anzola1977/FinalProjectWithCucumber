package com.example.steps;

import com.example.context.Context;
import com.example.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

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

    @When("user clicks icon button")
    public void userClicksIconButton() {
        new MainPage().iconCheck.click();
    }

    @Then("a checkmark appears")
    public void aCheckmarkAppears() {
        assertTrue(new MainPage().iconCheckTaskCompleted.isDisplayed());
    }

    @And("the text color changes to gray and crossed out")
    public void theTextColorChangesToGrayAndCrossedOut() {
        assertTrue(new MainPage().taskCompleted.isDisplayed());
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

    @Then("the text color of previously marked tasks becomes black and is not crossed out")
    public void theTextColorOfPreviouslyMarkedTasksBecomesBlackAndIsNotCrossedOut() {
        assertTrue(new MainPage().taskFieldInput.isDisplayed());
    }

    @Then("the counter of marked tasks will be equal to the number of tasks")
    public void theCounterOfMarkedTasksWillBeEqualToTheNumberOfTasks() {
        assertEquals(String.valueOf(new MainPage().listOfTasks.size()), new MainPage().counter.getText());
    }

    @And("clicks clear button")
    public void clicksClearButton() {
        new MainPage().deleteButton.click();
    }

    @Then("a marked task is deleted")
    public void aMarkedTaskIsDeleted() {
        assertTrue(new MainPage().listOfTasks.isEmpty());
    }

//    @And("this user task is not clickable")
//    public void thisUserTaskIsNotClickable() {
////        new MainPage().listOfTasks.getFirst().click();
//        assertFalse(new MainPage().taskFieldInput.click());
//    }
}
