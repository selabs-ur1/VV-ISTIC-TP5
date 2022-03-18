## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer
Quel rapport a cette question avec la matière VV? Nous n'avons jamais parlé de cette application en cours.

Anyway...

```java
import java.util.Date;
import java.util.Map;

public interface ProjectQuickstartSession {
    // Top menu
    Session createnew();
    String getShareUrl();
    void openChat();
    void pad();

    // Page content
    String getTitle();
    Date getCreationTimeStamp();
    Room getLocation();
    boolean hasMeal();
    List<Comment> getComments();

    // User form
    String getName();
    void setName();
    String getMail();
    void setMail();
    boolean hasICS();
    void setICS();
    boolean hasPreferredAliments();
    void setPreferredAliments();
    boolean switchView();
    void setWhishlist(Map<String,Boolean> whislist);
    void addComment(Comment comment);
}
```