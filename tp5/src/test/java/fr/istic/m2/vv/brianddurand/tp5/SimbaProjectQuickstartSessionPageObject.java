package fr.istic.m2.vv.brianddurand.tp5;

import java.util.List;

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