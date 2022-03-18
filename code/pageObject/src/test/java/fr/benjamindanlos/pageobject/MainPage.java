package fr.benjamindanlos.pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement step2Button = $x("//span[contains(@class, 'p-steps-number') and text() = '2']");
    public SelenideElement nextButton = $x("//span[contains(@class, 'p-button-label') and text()='Next']").parent();
}
