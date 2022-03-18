import java.util.List;

public interface ProjetQuickstartPage {

    // Button line at top
    void clickNewButton();

    void clickShareButton();

    void clickChatButton();

    void clickPadButton();

    // Participant Information
    String getName();

    void setName(String newName);

    String getEmail();

    void setEmail(String newName);

    String getAgenda();

    void setAgenda(boolean value);

    String getMealPreference();

    void setMealPreference(boolean value);

    //Time Selector
    void clickCalendarView();

    void clickTableView();

    void checkTimeByDate(List<String> l );

    void uncheckTimeByDate(List<String> l );

    void getParticpantNameInview();

    void clickSubmitButton();

    // Comment section
    String getCommentAuthor();

    void setCommentAuthor(String newName);

    String getComment();

    void getComment(String newComment);

    void clickAddComment();

}
