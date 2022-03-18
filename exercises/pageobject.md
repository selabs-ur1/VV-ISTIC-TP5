## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

```Java
public class PrjQStartPage{
    public PrjQStartPage(WebDriver driver);

    public InformationPage createNew();

    public String title();
    
    public String place();

    public String meal();

    //imput fields
    public String getNomPrenom();

    public InformationPage setNomPrenom(String value);

    public String getEmail();

    public InformationPage setEmail(String value);
    
    //Checkbox 1
    public boolean hasICS();
    
    public InformationPage setHasICS(boolean value);

    //Checkbox 2
    public boolean hasPrefAlim();
    
    public InformationPage setHasPrefAlim(boolean value);
    
    //calendar
    public int nbParticipants();
    
    public List<String> participants();

    public List<String> creneaux();
    
    public InformationPage addVoeux();
    
    //Commentaires
    public String getAuteurComm();

    public InformationPage setAuteurComm(String value);

    public List<String> getComm();

    public InformationPage setComm(String value);

    public InformationPage addComm();
    
}
```