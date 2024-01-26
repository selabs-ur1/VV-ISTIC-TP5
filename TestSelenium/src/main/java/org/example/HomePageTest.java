package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class HomePageTest {

    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setUp() {
        // Assurez-vous que le chemin vers le pilote Chrome est correct
        System.setProperty("webdriver.chrome.driver", "chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Ouvrez l'URL de votre application
        driver.get("http://localhost:4200");

        // Initialisez la page d'accueil
        homePage = new HomePage(driver);
    }

    @Test
    public void testHomePageTitle() {
        // Vérifiez que le titre de la page correspond à ce que vous attendez
        String expectedTitle = "";
        String temp =  homePage.title();
        assertEquals(expectedTitle, homePage.title());
    }

    @Test
    public void testNextButton() {
        // Testez le bouton suivant en vous attendant à des erreurs (ajustez selon vos besoins)
        homePage.nextExpectingErrors();

        // Ajoutez des assertions en fonction du comportement attendu après avoir cliqué sur le bouton suivant
        // Par exemple, vérifiez l'affichage d'un message d'erreur, d'un champ obligatoire, etc.
    }


    @Test
    public void testBackButton() {
        // Testez le bouton suivant en vous attendant à des erreurs (ajustez selon vos besoins)
        homePage.testExpectingErrors();

        // Ajoutez des assertions en fonction du comportement attendu après avoir cliqué sur le bouton suivant
        // Par exemple, vérifiez l'affichage d'un message d'erreur, d'un champ obligatoire, etc.
    }

    @Test
    public void testInputSwitch() {
        // Testez le bouton suivant en vous attendant à des erreurs (ajustez selon vos besoins)
        homePage.testInputSwitch();

        // Ajoutez des assertions en fonction du comportement attendu après avoir cliqué sur le bouton suivant
        // Par exemple, vérifiez l'affichage d'un message d'erreur, d'un champ obligatoire, etc.
    }

    @Test
    public void testInputTextTitre() {
        // Saisissez du texte dans le champ "titre"
        String inputText = "Texte de test";
          homePage.setInputTextTitre(inputText);
        // Vérifiez que la valeur du champ "titre" correspond à ce que vous avez saisi
        assertEquals(inputText, homePage.getInputTextTitre());
    }

    @Test
    public void testInputDescription() {
        // Saisissez du texte dans le champ "titre"
        String inputText = "Texte de description";
        homePage.setInputDescription(inputText);
        // Vérifiez que la valeur du champ "titre" correspond à ce que vous avez saisi
        assertEquals(inputText, homePage.getInputTextDescription());
    }

    @Test
    public void testInputLieu() {
        // Saisissez du texte dans le champ "titre"
        String inputText = "Rennes salle A";
        homePage.setInputLieu(inputText);
        // Vérifiez que la valeur du champ "titre" correspond à ce que vous avez saisi
        assertEquals(inputText, homePage.getInputLieu());
    }

    @After
    public void tearDown() {
        // Fermez le navigateur après chaque test
        if (driver != null) {
            driver.quit();
        }
    }
}
