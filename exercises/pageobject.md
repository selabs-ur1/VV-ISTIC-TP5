## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

```java
public interface  pageObjet {

	public pageObjet(WebDriver driver)

	public InformationPage createNew()
	public InformationPage modify()
	public String chatRoomURL()
	public String padURL()

	public String title()
	public String location()
	
	public String name() 
	public String email()
	public Boolean hasICS()
	public Boolean foodPreferences()

	public boolean hasMeal() 
	public List<String> comments()
}
```
