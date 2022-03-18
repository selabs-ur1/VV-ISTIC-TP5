## Find a bug

Clone the [Simba Organizer repository](https://github.com/barais/doodlestudent/) and follow the instructions to run the application on your machine.

Find a bug in the application. 

With the help of Selenium and the Page Object Model desing pattern write a simple test that fails for this bug.

Optionally make a pull request to the project.

Include in this document the code of the test and, if you did it, the link to the pull request.

## Answer
L'application présente un formulaire lors de la création du poll. Pour passer à la page suivante (click sur le bouton next), une vérification est effectuée pour que les champs du formulaire soient renseignés. Cette vérification n'est pas menée si nous cliquons directement sur le point 3: Résumé.

Pour tester ce bug le [code](../tp5/src/test/java/fr/istic/m2/vv/brianddurand/tp5/TestNavigationEmptyFields.java) est le suivant:
```java

public class TestNavigationEmptyFields {

    private WebDriver webDriver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() throws IOException {
        // prise de la capture
        Calendar calendar = Calendar.getInstance(Locale.FRANCE);
        File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(String.format("./images/simba-%d-%d-%d-%d-%d-%d.png",
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND))));

        webDriver.quit();
    }

    @Test
    /**
     * Ce test vise à vérifier qu'on ne peut pas accéder aux onglets suivants si les champs
     * du formulaire sont vides.
     * En pratique, ce cas de test sera en échec car il s'agit d'un bug connu de l'application
     */
    void testNavigationWithEmptyFields() throws InterruptedException {
        SimbaPollCreationPage page = new SimbaPollCreationPage(webDriver);
        webDriver.get("http://localhost:4200/create");
        Thread.sleep(1000);
        page.clickResumeBouton();

        // En theorie l'action devrait etre bloquée et nous devrions être sur la même page.
        assertTrue(page.getChampTitre().isDisplayed());
    }

}
```
Aussi, à la fin de l'execution d'un test, une snapshot est prise. Cela peut servir à mieux comprendre ce qu'il s'est passé. ([exemple](../tp5/images/simba-2022-3-18-23-5-28.png))

