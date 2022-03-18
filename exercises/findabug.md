## Find a bug

Clone the [Simba Organizer repository](https://github.com/barais/doodlestudent/) and follow the instructions to run the application on your machine.

Find a bug in the application. 

With the help of Selenium and the Page Object Model desing pattern write a simple test that fails for this bug.

Optionally make a pull request to the project.

Include in this document the code of the test and, if you did it, the link to the pull request.

## Answer

The code is located in the folder : [TpSelenium](https://github.com/GuillaumeLEDOURNER/VV-ISTIC-TP5/tree/main/tpSelenium)

Add chromedriver at the root of the project depending on your OS to try it out


The bug we found in the Simba Organizer Application, is located at the end page obtained after creating a poll. 
![](https://i.imgur.com/GXp3Yiq.png)

The links generated are not working and redirecting to a 404 error page.

![](https://i.imgur.com/U0Zhz6u.png)

We then proceded to create a simple class to test this page, the first class recreate the behaviour of a user by creating a poll and navigating to the end page

```java=
public class ResumePage {

    WebDriver driver;

    public ResumePage(WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Participation link
    // Admin link
    // discussion link
    // pad link
    public String getParticipationLink(){
        return driver.findElements(By.xpath("//a[@class='ng-star-inserted']")).get(0).getText();
    }
    public String getAdminLink(){
        return driver.findElements(By.xpath("//a[@class='ng-star-inserted']")).get(1).getText();
    }
    public String getDiscussionLink(){
        return driver.findElements(By.xpath("//a[@class='ng-star-inserted']")).get(2).getText();
    }
    public String getPadLink(){
        return driver.findElement(By.xpath("//span[@class='ng-star-inserted']/a")).getText();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","tpSelenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:80");
        driver.findElement(By.className("Home_CreateLink")).click();

        InformationPage infoPage = new InformationPage(driver);
        ResumePage resumePage = new ResumePage(driver);

        infoPage.setTitle("Titre");
        infoPage.setPlace("Ici");
        infoPage.setDescription("ici");

        synchronized (driver){
            driver.wait(1000);
        }

        driver.findElement(By.cssSelector("p-button[label=Next]")).click();


        synchronized (driver){
            driver.wait(1000);
        }
        synchronized (driver){
            driver.wait(1000);
        }

        // Because "driver.findElement(By.cssSelector("p-button[label=Next]")).click();" not working for date choice page :)
        driver.findElement(By.cssSelector(".p-card-footer:nth-child(2) .float-right > .p-button")).click();

        synchronized (driver){
            driver.wait(1000);
        }
        synchronized (driver){
            driver.wait(1000);
        }
        driver.quit();
    }

}
```

Then we wrote a simple test that fails for the bug we found to conirm its existence.

```java=
class ResumePageTest {
    WebDriver driver;

    @BeforeEach
    void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:80");
        driver.findElement(By.className("Home_CreateLink")).click();
        InformationPage infoPage = new InformationPage(driver);

        infoPage.setTitle("Titre");
        infoPage.setPlace("Ici");
        infoPage.setDescription("ici");

        synchronized (driver){
            driver.wait(1000);
        }

        driver.findElement(By.cssSelector("p-button[label=Next]")).click();


        synchronized (driver){
            driver.wait(1000);
        }
        // Because "driver.findElement(By.cssSelector("p-button[label=Next]")).click();" not working for date choice page :)
        driver.findElement(By.cssSelector(".p-card-footer:nth-child(2) .float-right > .p-button")).click();
        synchronized (driver){
            driver.wait(1000);
        }
    }

    @Test
    void testParticipationLink() throws InterruptedException {
        ResumePage page = new ResumePage(driver);
        System.out.println(page.getParticipationLink());
        driver.get(page.getParticipationLink());
        assertNotEquals("404 Not Found",driver.getTitle());
    }
    @Test
    void testAdminLink() {
        ResumePage page = new ResumePage(driver);
        driver.get(page.getAdminLink());
        assertNotEquals("404 Not Found",driver.getTitle());
    }
    @Test
    void testPadLink() {
        ResumePage page = new ResumePage(driver);
        driver.get(page.getPadLink());
        assertNotEquals("404 Not Found",driver.getTitle());
    }
    @Test
    void testDiscussionLink() {
        ResumePage page = new ResumePage(driver);
        driver.get(page.getDiscussionLink());
        assertNotEquals("404 Not Found",driver.getTitle());
    }

    @AfterEach
    void quitDriver(){
        driver.quit();
    }
}

```

And the test result we obtain are in accordance with our interrogations. The mecanism responsible for the generation of the links produce incorrect result for the participation link,administration link, and pad link. 
This mechanism should work in the app, we didn't get a chance to solve the issue in the UE timeframe by going to Olivier Barais for guidance.



