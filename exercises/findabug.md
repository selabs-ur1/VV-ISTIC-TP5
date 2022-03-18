## Find a bug

Clone the [Simba Organizer repository](https://github.com/barais/doodlestudent/) and follow the instructions to run the application on your machine.

Find a bug in the application. 

With the help of Selenium and the Page Object Model desing pattern write a simple test that fails for this bug.

Optionally make a pull request to the project.

Include in this document the code of the test and, if you did it, the link to the pull request.

## Answer

Voici un bug que nous avons trouvé :
- L'utilisateur arrive sur [la page de création du Doodle](http://doodle.diverse-team.fr/create).
- Il ne remplit pas les informations et clique sur l'étape 3 "Résumé".
- Il revient sur l'étape 2 "Choix de la date".
- Il ne sélectionne aucune date et clique sur "Next".
- Il n'a rempli aucune information et pourtant, la réunion a été créée comme s'il n'y avait aucune erreur.

Voici le code permettant de montrer ce bug.

Le Page Object Model :
````java
public class PageObjectModelSimba {

    private WebDriver driver;

    public PageObjectModelSimba(WebDriver driver) {
        this.driver = driver;
    }

    public void createPoll() {
        driver.findElement(By.xpath("/html/body/app-root/app-home-component/div/div/div[2]/a")).click();
    }

    public void buttonChoixDeLaDate() {
        driver.findElement(By.xpath("/html/body/app-root/app-create-poll-component/div/div[1]/p-steps/div/ul/li[2]/a/span[1]")).click();
    }

    public void buttonResume() {
        driver.findElement(By.xpath("/html/body/app-root/app-create-poll-component/div/div[1]/p-steps/div/ul/li[3]/a/span[1]")).click();
    }

    public void next() {
        driver.findElement(By.xpath("/html/body/app-root/app-create-poll-component/div/div[3]/p-card/div/div/div[2]/div/p-button[2]/button/span[2]")).click();
    }

}
````

Le test permettant de vérifier le scénario décrit :
````java
public class TestPageObjectModelSimba {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("https://doodle.diverse-team.fr");
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void testCreatePoll() throws InterruptedException {
        PageObjectModelSimba p = new PageObjectModelSimba(driver);
        p.createPoll();
        p.buttonResume();
        p.buttonChoixDeLaDate();
        p.next();
        Thread.sleep(1000);
        assertNull(driver.findElement(By.partialLinkText("https://doodle.diverse-team.fr/answer/")));
    }
}
````