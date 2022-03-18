## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

Interface pseudo-Java :

```
public interface SimbaEvent {

    // Header
    void clickLogoHome()
    void clickHeaderNouveau();
    void clickHeaderPartager();
    void clickHeaderChat();
    void clickHeaderPad();

    // Title
    String getNameEvent();
    Date getDateCreationEvent();
    String getLocation();
    boolean getContientRepas();

    // user informations
    String getName();

    void setName(String name);

    String getEmail();

    void setEmail(String email);

    boolean getAgendaAccessible();

    void setAgendaAccessible(boolean accessible);

    boolean getPrefAlimentaires();

    void setPrefAlimentaires(boolean asPreferences);

    // TO DO

}
```

