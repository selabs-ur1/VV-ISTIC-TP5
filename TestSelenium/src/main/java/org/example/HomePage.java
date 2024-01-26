package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

class HomePage {

    private final WebDriver driver;

    @FindBy(id = "titre")
    private WebElement titleInput;

    @FindBy(css ="p-button[label=Next]")
    private WebElement nextButton;

    @FindBy(css ="p-button[label=Back]")
    private WebElement backButton;

    @FindBy(css ="p-inputSwitch[id=repas]")
    private WebElement inputSwitchRepas;

    //Titre
    //Lieu
    @FindBy(css ="input[id=lieu]")
    private WebElement inputLieu;

    //Description
    @FindBy(css ="textarea[id=desc]")
    private WebElement inputDescription;

    public HomePage(WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String title() {
        return titleInput.getText();
    }

    public void setInputTextTitre(String text) {
        titleInput.sendKeys(text);
    }
    public void setInputDescription(String text) {
        inputDescription.sendKeys(text);
    }

    public void setInputLieu(String text) {
        inputLieu.sendKeys(text);
    }


    public String getInputTextTitre() {
        return titleInput.getAttribute("value");
    }

    public String getInputTextDescription() {
        return inputDescription.getAttribute("value");
    }

    public String getInputLieu() {
        return inputLieu.getAttribute("value");
    }


    public HomePage nextExpectingErrors() {
        nextButton.click();
        return this;
    }

    public HomePage testExpectingErrors() {
        backButton.click();
        return this;
    }

    public HomePage testInputSwitch() {
        inputSwitchRepas.click();
        return this;
    }

    public HomePage testInputDescription() {

        return this;
    }

}

