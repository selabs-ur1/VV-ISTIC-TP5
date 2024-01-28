package org.example.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProjectQuickstartSession {

    private final WebDriver driver;
    @FindBy(id = "name")
    private WebElement nameInput;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "hasAgenda")
    private WebElement hasAgenda;
    @FindBy(id = "hasFoodPreferences")
    private WebElement hasFoodPreferences;
    @FindBy(id = "calendarContainer")
    private WebElement calendarContainer;
    @FindBy(id = "calendarDay")
    private WebElement calendarDay;
    @FindBy(id = "authorComment")
    private WebElement authorCommentInput;
    @FindBy(id = "comment")
    private WebElement commentInput;
    @FindBy(id = "addCommentButton")
    private WebElement addCommentButton;


    public ProjectQuickstartSession(WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Nom prénom participant
    public String name() {
        return nameInput.getText();
    }
    public ProjectQuickstartSession typeName(String value) {
        nameInput.sendKeys(value);
        return this;
    }

    // Email participant
    public String email() {
        return emailInput.getText();
    }
    public ProjectQuickstartSession typeEmail(String value) {
        emailInput.sendKeys(value);
        return this;
    }

    // check box Avez vous un agenda avec un flux ics accessible
    public boolean hasAgenda() {
        return hasAgenda.isSelected();
    }
    public void setHasAgenda(boolean value) {
        if (value) {
            hasAgenda.click();
        }
    }

    // check box Avez vous des préférences alimentaires
    public boolean hasFoodPreferences() {
        return hasFoodPreferences.isSelected();
    }
    public void setHasFoodPreferences(boolean value) {
        if (value) {
            hasFoodPreferences.click();
        }
    }

    // liste des options du calendrier
    public List<OptionCalendar> getOptionsCalendar() {
        List<OptionCalendar> options = new ArrayList<>();

        List<WebElement> days = this.calendarContainer.findElements(By.id("optionPannelContainer"));

        for (WebElement day : days) {
            options.add(new OptionCalendar(day));
        }

        return options;
    }

    // Commentaire auteur
    public String authorComment() {
        return authorCommentInput.getText();
    }
    public ProjectQuickstartSession typeAuthorComment(String value) {
        authorCommentInput.sendKeys(value);
        return this;
    }

    // Commentaire
    public String comment() {
        return commentInput.getText();
    }
    public ProjectQuickstartSession typeComment(String value) {
        commentInput.sendKeys(value);
        return this;
    }

    // Bouton ajouter commentaire
    public ProjectQuickstartSession clickAddCommentButton() {
        addCommentButton.click();
        return this;
    }
}

