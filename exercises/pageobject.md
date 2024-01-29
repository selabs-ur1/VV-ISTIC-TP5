## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

Authors: Dufeil Jaufret & Gentile Brian

```java
public interface pageObject {

    public String setName(String name);
        
    public String setEmail(String email);

    public Boolean icsAccessible(boolean icsAccessible);

    public Boolean foodPreferences(boolean foodPreferences);

    public void setWish(int choice, String name);

    public void setCommentary(String authorName, String com);

}
```