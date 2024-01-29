# Page Object Model

Yoann DEWILDE\
Enora DANILO\
M2 ILa - Groupe 1

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

### PollPage

Divisé en 2 composants :

- ChoicesComponent : tableau permettant de choisir un créneau ;
- CommentSectionComponent : commentaires.

```java
class PollPage {
    // Boutons en haut de la page
    public void newPoll() {}
    public void sharePoll() {}
    public void openChat() {}
    public void openPad() {}

    public String getTitle();
    public String getCreationDate();
    public String getLocation();
    public boolean getHaveMeal();
    

    /**
     * @param icsPath use only if useIcs is true
     * @param foodPreferences use only if haveFoodPreferences is true
     */
    public PollPage submitWish(String username, String email, boolean useIcs, String icsPath, boolean haveFoodPreferences, String foodPreferences, ChoicesComponent choices) {}

    public CommentComponent postComment(String username, String comment) {}
}
```

### ChoicesComponent

Sous-composants :

- EventTimeComponent : colonne d'entête du tableau, correspondant à un fuseau horaire.

```java
class ChoicesComponent {
    public List<EventTimeComponent> getEvents() {}
    public List<EventTimeComponent> getEventsSelectedByUser(String username) {}

    // Map username => events sélectionnés
    public Map<String, List<EventTimeComponent>> getSelectedEvents() {}

    public int getParticipantsCount() {}
    public int getParticipantsCountOnEvent(EventTimeComponent event) {}

    public EventTimeComponent selectEvent(String username, EventTimeComponent event) {}
    public List<EventTimeComponent> selectEvents(String username, EventTimeComponent... selection) {}
}
```

#### EventTimeComponent

```java
class EventTimeComponent {
    public Date getDate() {}

    public Time getStartTime() {}
    public Time getEndTime() {}
}
```

### CommentsSectionComponent

Sous-composants :

- CommentComponent : un commentaire posté.

```java
class CommentsSectionComponent {
    public int getCommentsCount() {}

    public List<CommentComponent> getComments() {}

    public CommentComponent post(String username, String content) {}
}
```

#### CommentComponent

Contient les informations suivantes :

- nom d'utilisateur de l'auteur ;
- contenu du commentaire.

```java
class CommentComponent {
    public String getAuthor() {}
    public String getContent() {}

    public String setAuthor() {}
    public String setContent() {}
}
```