## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

Here the interface in java for this document : 

``` java
public interface PageObjectSimba {

    public void fillName(String name);

    public void fillEmail(String email);

    public void tickAgenda();

    public void tickFoodPreferences();

    public void fillParticipant(String participant);

    public void tickPresence(LocalDateTime date);

    public void submitWishes();

    public void fillAuthorNameComment(String authorName);

    public void fillComment(String comment);

    public void submitComment();
    
}
```
