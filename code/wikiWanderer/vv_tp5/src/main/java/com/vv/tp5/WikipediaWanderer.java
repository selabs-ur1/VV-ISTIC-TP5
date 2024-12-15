package com.vv.tp5;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class WikipediaWanderer {

    private WebDriver driver;

    public WikipediaWanderer() {
        // Configuration de Selenium pour contourner le problème lié à l'installation de Firefox en snap, et le problème avec le geckodriver
        System.setProperty("webdriver.gecko.driver", "/home/etudiant/VV/geckoDriver/geckodriver-v0.35.0-linux64/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/home/etudiant/firefox/firefox-133.0.3/firefox/firefox");
        
        this.driver = new FirefoxDriver(options);
    }

    public void navigatePages() {
        try {
            // Navigation vers Wikipedia
            driver.get("https://www.wikipedia.org/");

            // Boucle de navigation sur 10 pages aléatoires
            for (int nbIter = 0; nbIter < 10; nbIter++) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

                List<WebElement> links = driver.findElements(By.tagName("a"));
                if (links.isEmpty()) {
                    System.out.println("Aucun lien trouvé !");
                    break;
                }

                int randomIndex = new Random().nextInt(links.size());
                String href = links.get(randomIndex).getAttribute("href");

                if (href != null && isValidUrl(href)) {
                    driver.get(href);
                    System.out.println("Navigué vers : " + driver.getTitle());
                }
            }

            //Capture d'écran pour la 10è page
            takeScreenshot("last_page.png");

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    private void takeScreenshot(String fileName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(fileName));
            System.out.println("Capture d'écran sauvegardée : " + fileName);
        } catch (IOException e) {
            System.out.println("Erreur lors de la capture : " + e.getMessage());
        }
    }

    private boolean isValidUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        WikipediaWanderer wanderer = new WikipediaWanderer();
        wanderer.navigatePages();
    }
}
