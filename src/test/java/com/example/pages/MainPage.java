package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{
    public MainPage(){
    }

    @FindBy(xpath = "//*[@class='list-stats']//span")
    public WebElement counter;

    @FindBy(css = "#new-item")
    public WebElement newTaskInput;

    @FindBy(xpath = "//*[@class='todo-label']")
    public WebElement taskFieldInput;

    @FindBy(xpath = "//*[@class='todo']")
    public List<WebElement> listOfTasks;

    @FindBy(xpath = "//*[@class='icon-check']")
    public WebElement iconCheck;

    @FindBy(css = "#submit-new-item")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@class='icon-check task-completed']")
    public WebElement iconCheckTaskCompleted;

    @FindBy(xpath = "//*[@class='todo-label completed']")
    public WebElement taskCompleted;

//    @FindBy(xpath = "//*[@class='icon-trash']")
//    public WebElement iconTrash;

    @FindBy(xpath = "//*[@class='clear-all-btn']")
    public WebElement deleteButton;
}
