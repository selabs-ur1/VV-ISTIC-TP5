## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

````java
import javax.swing.text.TabableView;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PollPage {

    //Barre menu
    public Button buttonCreateNew();

    public Button buttonShare();

    public Button buttonChat();

    public Button buttonPad();

    //info
    public String title();

    public String createdAt();

    public String place();

    public String hasMeal();

    //form
    public TextArea nameSurname();

    public TextArea email();

    public boolean hasAgendaICS();

    public boolean hasMealPref();

    public Button calendarView();

    public Button tabView();

    //tableau 
    public ArrayList<T> wishCalendar();

    public Button submit(String name, String mail, ArrayList wishCalendar);

    public String nbComments();

    public TextArea author();

    public TextArea comment();

    public Button addComment(String author, String comment);

}
````