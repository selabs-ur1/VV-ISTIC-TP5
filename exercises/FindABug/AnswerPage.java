package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class AnswerPage {
    private final WebDriver driver;
    @FindBy(xpath = "/html/body/app-root/app-answer-poll/div/p-card/div/div/div[1]/h1")
    private WebElement titleLabel;
    @FindBy(xpath = "/html/body/app-root/app-answer-poll/div/p-card/div/div/div[3]/div[2]/div[4]/p-selectbutton/div/div[1]")
    private WebElement buttonVueCalendrier;
    @FindBy(xpath = "/html/body/app-root/app-answer-poll/div/p-card/div/div/div[3]/div[2]/div[4]/p-selectbutton/div/div[2]")
    private WebElement buttonVueTableau;


    public boolean isCalendarVisible() {
        return !this.driver.findElements(By.xpath("/html/body/app-root/app-answer-poll/div/p-card/div/div/div[3]/div[2]/div[5]/full-calendar")).isEmpty();
    }
    public boolean isTableVisible() {
        return !this.driver.findElements(By.xpath("/html/body/app-root/app-answer-poll/div/p-card/div/div/div[3]/div[2]/div[5]/div/div/table")).isEmpty();
    }
    public String getButtonVueCalendrierText() {
        return buttonVueCalendrier.getAttribute("aria-labelledby");
    }
    public String getButtonVueTableauText() {
        return buttonVueTableau.getText();
    }
    public void clickButtonVueCalendrier() {
        buttonVueCalendrier.click();
    }
    public void clickButtonVueTableau() {
        buttonVueTableau.click();
    }

    public String name() {
        return titleLabel.getText();
    }


    public AnswerPage(WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
