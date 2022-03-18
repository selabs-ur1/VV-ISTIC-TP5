## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

```java
class SimbaPage{
    public SelenideElement buttonNouveau = $x("//div[text() = 'Nouveau']");
    public SelenideElement buttonPartager = $x("//div[text() = 'Partager']");
    public SelenideElement buttonChat = $x("//div[text() = 'Chat']");
    public SelenideElement buttonPad = $x("//div[text() = 'Pad']");
    
    public SelenideElement inputNomPrenom = $x("//label[contains(text(), 'Nom prénom participant')]//input");
    public SelenideElement inputEmail = $x("//label[contains(text(), 'Email participant')]//input");
    public SelenideElement inputICS = $x("//label[contains(text(), 'Avez vous un agenda avec un flux ics accessible ?')]//input");
    public SelenideElement inputFoodPreferences = $x("//label[contains(text(), 'Avez vous des préférences alimentaires ?')]//input");
    public SelenideElement submitWishes = $x("//div[text() = 'Soumettre voeux']");
    
    public SelenideElement inputCommentAuthor = $x("//label[contains(text(), 'Auteur du commentaire associé à ce sondage')]//input");
    public SelenideElement inputComment = $x("//label[contains(text(), 'Commentaire')]//input");
    public SelenideElement submitComment = $x("//div[text() = 'Ajouter commentaire']");
}
```
