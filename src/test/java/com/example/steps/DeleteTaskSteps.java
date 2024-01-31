package com.example.steps;

import com.example.pages.MainPage;
import io.cucumber.java.en.And;

public class DeleteTaskSteps {

    @And("clicks clear button")
    public void clicksClearButton() {
        new MainPage().deleteButton.click();
    }

    @And("clicks a trash icon in the task field")
    public void clicksATrashIconInTheTaskField() {
        new MainPage().iconTrash.click();
    }
}
