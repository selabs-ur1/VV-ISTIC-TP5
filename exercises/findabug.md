## Find a bug

Clone the [Simba Organizer repository](https://github.com/barais/doodlestudent/) and follow the instructions to run the application on your machine.

Find a bug in the application. 

With the help of Selenium and the Page Object Model desing pattern write a simple test that fails for this bug.

Optionally make a pull request to the project.

Include in this document the code of the test and, if you did it, the link to the pull request.

## Answer
Beaucoup de bugs dans ce truc, mais voici un test simple.  
Quand on essaye de créer un profil on tombe sur un formulaire a remplir avec des champs requis a remplis pour accéder a la suite du formulaire. Cette vérification est faire quand on clique sur le bouton next, mais pas quand on clique sur les boutons d'onglets du formulaire juste au dessus.  
Cet oublis de condition est testable pour l'onglet 2 par le code suivant:

```java
package fr.istic.findabug;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MainPageTest {

    private WebDriver webDriver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "E:\\Bibliothèques\\Documents\\Cours\\V&V\\eckodriver-v0.30.0-win64\\geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        // Define browser resolution
        webDriver.manage().window().setSize(new Dimension(1024, 768));
    }

    @Test
    public void testClickButton() {
        // Navigate to page
        webDriver.navigate().to("http://localhost:4200/create");
        try {
            // Try to click on the button 2 without filling any required fields
            WebElement button = webDriver.findElement(By.xpath("//span[contains(text(), '2')]"));
            button.click();
            SummaryPage page = new SummaryPage(webDriver);
            assertTrue(page.title().trim().isEmpty());
            assertTrue(page.place().trim().isEmpty());
            assertTrue(page.description().trim().isEmpty());
            assertNotEquals("rgba(0, 123, 255, 1)", button.getCssValue("background-color"));
        } catch (ElementNotInteractableException e) {
            fail("Click on button 2 failed");
        }
        webDriver.quit();
    }
}

```