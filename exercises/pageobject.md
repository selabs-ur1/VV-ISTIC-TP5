## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

```java
public interface SimbaProjectQuickstartSessionPageObject {

    // blue header
    void clickNouveau();
    void clickPartager();
    void clickChat();
    void clickPad();

    // user informations
    String getName();
    void setName(String name);
    String getEmail();
    void setEmail(String email);
    boolean getIcsAccessible();
    void setIcsAccessible(boolean accessible);
    boolean getMealPreferences();
    void setMealPreferences(boolean hasPreferences);

    // time
    void clickVueCalendrier();
    void clickVueTableau();
    List<String> getDates();
    int getParticipantsNumber();
    void clickForDate(String date);
    boolean getDateChecked(String date);
    void clickSoumettreVoeux();

    // comments
    int getCommentsNumber();
    void setCommentAuthorName(String name);
    void setCommentBody(String body);
    void clickAjouterCommentaire();
}
```