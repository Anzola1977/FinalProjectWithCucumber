package com.example.steps;

import com.example.context.Context;
import com.example.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonSteps {
    @Given("user enter main page")
    public void user_enter_main_page() {
        Context.scenario.log("User entered main page");
    }

    @Then("user's task is added to his task list last")
    public void user_s_task_is_added_to_his_task_list_last() {
        Context.wait.until(ExpectedConditions.visibilityOfAllElements(new MainPage().listOfTasks));
        assertEquals(1, new MainPage().listOfTasks.size());
    }
}
