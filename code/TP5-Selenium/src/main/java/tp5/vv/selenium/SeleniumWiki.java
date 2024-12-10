package tp5.vv.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SeleniumWiki {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);


        try {
            driver.get("https://fr.wikipedia.org/wiki/Wikip%C3%A9dia:Accueil_principal");

            int visitedPages = 0;

            while (visitedPages < 10) {
                List<WebElement> links = driver.findElements(By.tagName("a"));

                WebElement randomLink = null;

                int randomInt;
                Random rand = new Random();

                randomInt = rand.nextInt(links.size()-1);
                randomLink = links.get(randomInt);
                System.out.println(randomLink.getAttribute("href"));

                //attendre que ça sois cliquable
                /*
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                wait.until(ExpectedConditions.elementToBeClickable(randomLink));
                */

                // Cliquer sur le lien
                //randomLink.click(); //cliquable créer trop de contrainte, pour enchainer les pages
                driver.get(randomLink.getAttribute("href"));

                visitedPages++;

                //attendre l'ouverture de la nouvelle page
                Thread.sleep(3000);

                System.out.println("Page visitée : " + driver.getCurrentUrl());

                if(visitedPages==10){
                    Snapshot(driver, "snapshot_WikiPage10.png");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void Snapshot(WebDriver driver, String fileName) {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileHandler.copy(screenshotFile, new File(fileName));
            System.out.println("Capture d'écran sauvegardée sous: " + fileName);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde de la capture d'écran.");
            e.printStackTrace();
        }
    }
}

