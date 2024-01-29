## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

```java
public class AdminPage {

    public AdminPage(WebDriver driver) { }

    public InformationPage createNew() { }

    public InformationPage modify() { }

    public String getNames() { }

    public String getEmail() { }

    public Bool isAgendaAvailable() { }

    public Bool favoriteFood { }

    public OptionPanel register() { }

    public String title() { }

    public String place() { }

    public boolean hasMeal() { }

    public List<String> comments() {  }

    public String chatRoomURL() { }

    public String padURL() { }

    public String urlToShare() { }

}
```
