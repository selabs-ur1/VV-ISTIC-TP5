package tp5.vv.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimbaPoolPage {

    private WebDriver driver;

    //éléments de la page
    //menu (top bar) https://github.com/barais/doodlestudent/blob/main/front/src/app/top-bar/top-bar.component.html

    //xpath ne va pas considerer le svg (normalement)
    public By nouveauPoll = By.xpath("//a[text()='Nouveau']");
    public By partager = By.xpath("//a[text()='Partager']");
    public By chat = By.xpath("//a[text()='Chat']");
    public By pad = By.xpath("//a[text()='Pad']");

    //formulaire
    // https://github.com/barais/doodlestudent/blob/main/front/src/app/answer-poll/answer-poll.component.html
    public By nom = By.id("nom");
    public By mail = By.id("mail");

    public By icsSwitch = By.xpath("//label[text()='Avez vous un agenda avec un flux ics accessible ?']/following-sibling::p-inputSwitch");
    public By icsInput = By.id("ics");

    public By preferencesSwitch = By.xpath("//label[text()='Avez vous des préférences alimentaires ?']/following-sibling::p-inputSwitch");
    public By preferenceInput = By.id("desc");

    //vue
    public By selectViewButton = By.xpath("//p-selectButton");

    //Tableau voeux
    public By eventCheckbox = By.xpath("//tr/td/input[@type='checkbox']");

    public By submitButton = By.xpath("//p-button[@label='Soumettre voeux']");


    //Commentaire
    public By Auteur = By.id("comment");
    public By commentDescription = By.id("commentdesc");
    public By submitCommentaire = By.xpath("//p-button[@label='Ajouter commentaire']");


    public SimbaPoolPage(WebDriver driver) {
        this.driver = driver;
    }
}