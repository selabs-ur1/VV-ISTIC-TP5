## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

```java
public interface PollPage {

    // Method to get the title of the event
    String getEventName();

    // Method to get the location of the event
    String getEventLocation();

    // Method to check if the event includes a meal
    boolean hasMeal();

    // Method to input participant's full name
    void setParticipantName(String name);

    // Method to get the participant's full name
    String getParticipantName();

    // Method to input participant's email
    void setParticipantEmail(String email);

    // Method to get the participant's email
    String getParticipantEmail();

    Participant[] getParticipantName();

    // Method to check the "accessible agenda" option
    void setAccessibleAgenda(boolean value);

    // Method to verify if "accessible agenda" is selected
    boolean isAccessibleAgendaSelected();

    // Method to check the "dietary preferences" option
    void setDietPreferences(boolean value);

    // Method to verify if "dietary preferences" is selected
    boolean isDietPreferencesSelected();

    // Method to select a time slot for a specific date
    void selectTimeSlot(String date, String time);

    // Method to check if a time slot is selected for a specific date
    boolean isTimeSlotSelected(String date, String time);

    // Method to submit the votes
    void submitVotes();

    // Method to add a comment
    void addComment(String author, String comment);

    // Method to get all comments
    List<String> getComments();

    // Method to get the view selected (calendar or array)
    boolean isCalendarView();
}

`````