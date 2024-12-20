## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer


```Java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class SimbaPollPage {

    private WebDriver driver;

    //éléments de la page
    //menu (top bar) https://github.com/barais/doodlestudent/blob/main/front/src/app/top-bar/top-bar.component.html

    //xpath ne va pas considerer le svg (normalement)
    private By nouveauPoll = By.xpath("//a[text()='Nouveau']");
    private By partager = By.xpath("//a[text()='Partager']");
    private By chat = By.xpath("//a[text()='Chat']");
    private By pad = By.xpath("//a[text()='Pad']");

    //formulaire
    // https://github.com/barais/doodlestudent/blob/main/front/src/app/answer-poll/answer-poll.component.html
    private By nom = By.id("nom");
    private By mail = By.id("mail");
    
    private By icsSwitch = By.xpath("//label[text()='Avez vous un agenda avec un flux ics accessible ?']/following-sibling::p-inputSwitch");
    private By icsInput = By.id("ics");
    
    private By preferencesSwitch = By.xpath("//label[text()='Avez vous des préférences alimentaires ?']/following-sibling::p-inputSwitch");
    private By preferenceInput = By.id("desc");

        //vue
    private By selectViewButton = By.xpath("//p-selectButton");

        //Tableau voeux
    private By eventCheckbox = By.xpath("//tr/td/input[@type='checkbox']"); 

    private By submitButton = By.xpath("//p-button[@label='Soumettre voeux']");


    //Commentaire
    private By Auteur = By.id("comment");
    private By commentDescription = By.id("commentdesc");
    private By submitCommentaire = By.xpath("//p-button[@label='Ajouter commentaire']");


```