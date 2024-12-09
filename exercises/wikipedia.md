# Random Wikipedia walker

Using Selenium, create a small program that, starting from the main page https://www.wikipedia.org/, walks trough a sequence of random links and takes a snapshot of the last page.
The process is as follows:

 1. Navigate to the main page https://www.wikipedia.org/
 2. Select a random link in the page
 3. Navigate to the link
 4. Repeat steps 2 to 3 until you have visited 10 different pages
 5. Take a snapshot of the current page and save it

Include the code of the walker and the snapshot in this document.

## Answer

Voici le code du wikipedia walker : 

```java
package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WikipediaWalker {

    public static void main(String[] args) {
        // Chemin vers votre ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // Initialisation du WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            // Étape 1 : Naviguer vers la page principale
            driver.get("https://www.wikipedia.org/");
            System.out.println("Navigated to Wikipedia main page.");

            // Liste pour stocker les URLs visitées
            List<String> visitedUrls = new ArrayList<>();
            Random random = new Random();

            // Étapes 2 à 4 : Naviguer à travers 10 pages aléatoires
            for (int i = 0; i < 10; i++) {
                System.out.println("Visiting page " + (i + 1) + "...");

                // Récupérer tous les liens sur la page actuelle
                List<WebElement> links = driver.findElements(By.tagName("a"));
                List<String> hrefs = new ArrayList<>();

                // Filtrer les liens valides (non nulls et non vides)
                for (WebElement link : links) {
                    String href = link.getAttribute("href");
                    if (href != null && !href.isEmpty() && !visitedUrls.contains(href)) {
                        hrefs.add(href);
                    }
                }

                if (hrefs.isEmpty()) {
                    System.out.println("No valid links found. Exiting...");
                    break;
                }

                // Sélectionner un lien aléatoire
                String randomLink = hrefs.get(random.nextInt(hrefs.size()));
                visitedUrls.add(randomLink);

                // Naviguer vers le lien sélectionné
                driver.get(randomLink);
                Thread.sleep(2000); // Attendre que la page charge
            }

            // Étape 5 : Prendre une capture d'écran
            File screenshot = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
            File destination = new File("wikipedia_snapshot.png");
            org.apache.commons.io.FileUtils.copyFile(screenshot, destination);
            System.out.println("Snapshot saved as " + destination.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer le navigateur
            driver.quit();
        }
    }
}
```

Le screen pris par sélénium peut-être trouver dans le dossier "exercices" sous le nom de "wikipedia_snapshot.png"
