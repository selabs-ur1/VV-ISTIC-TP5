## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

Voici l'interface de la page :

```java
public interface PollPage {

    // form
    WebElement getParticipantNameField(); 
    WebElement getParticipantEmailField(); 

    // check box
    WebElement getIcsAccessibleCheckbox(); 
    WebElement getFoodPreferencesCheckbox();

    // get date options
    List<WebElement> getTimeSlotCheckboxes();

    // get buttons
    WebElement getSubmitButton(); 
    WebElement getAddCommentButton();

    // add comments
    WebElement getCommentAuthorField();
    WebElement getCommentField(); 

    // Actions disponibles
    void enterParticipantName(String name);
    void enterParticipantEmail(String email); 
    void toggleIcsAccessibleCheckbox(boolean isChecked); 
    void toggleFoodPreferencesCheckbox(boolean isChecked); 
    void selectTimeSlot(int index);
    void submitChoices(); 
    void addComment(String author, String comment);
}
```