## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

```java
public interface Page {
    void enterNameAndSurname(String name, String surname);

    void enterEmail(String email);

    void selectIcsAgenda(boolean hasIcsAgenda);

    void selectFoodPreferences(boolean hasFoodPreferences);

    void selectTimeSlot(String timeSlot);

    void addParticipantName(String participantName);

    void submitEventRequest();

    void addComment(String comment);
}
```
