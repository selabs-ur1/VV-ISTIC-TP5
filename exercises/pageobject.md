## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

```java
public interface PageObject {

    public void enterName(String name);

    public void enterEmail(String email);

    public void tickAgenda();

    public void tickFoodPreferences();

    public void enterParticipant(String participant);

    public void tickMeeting(LocalDateTime date);

    public void submitWishes();

    public void enterAuhtorName(String authorName);

    public void enterComment(String comment);

    public void submitComment();
    
}
```