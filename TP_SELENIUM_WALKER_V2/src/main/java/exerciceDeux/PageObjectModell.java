package exerciceDeux;

import java.util.List;

public interface PageObjectModell {

    // Access menu
        InformationPage createNew();

        String urlToShare();

        String chatRoomURL();

        String padURL();

        // non modifiable element
        String title();

        String place();

        boolean hasMeal();

        List<OptionPanel> options();

        List<List<String>> comments();

        Map<String,List<Boolean>> wichList();

        // Editables
        String nameAndForname();

        PageObjectModell typeNomPrenom(String value);

        String eMail();

    PageObjectModell typeMail(String value);

        boolean hasICS();

    PageObjectModell setHasICS(boolean value);

        boolean hasFavoriteFood();

    PageObjectModell setHasFavoriteFood(boolean value);

        boolean tableauView();

    PageObjectModell setTableauView(boolean value);

        boolean calendarView();

    PageObjectModell setCalendarView(boolean value);

        List<Boolean> wichs();

    PageObjectModell setWichs(List<Boolean> values);

        String authorComments();

    PageObjectModell typeAuthorComments(String value);

        String comment();

    PageObjectModell typeComments(String value);

        // errors
        List<String> errors();

        // buttons
    PageObjectModell submitWichs();
    PageObjectModell submitComments();
    PageObjectModell submitCommentsExpectingErrors();

}
