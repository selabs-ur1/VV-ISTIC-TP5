package fr.istic.m2.vv.brianddurand.tp5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WikipediaWalker {

    @Test
    /**
     * Ce 'test' parcourt jusqu'a 10 pages en partant d'une page wikipédia aléatoire
     * A la fin du parcours une capture d'écran sera prise et stockée dans le dossier 'images'.
     */
    void walkOnWikipedia() throws IOException {

        // Création du webdriver et ouverture de wikipedia
        WebDriverManager.chromedriver().setup();
        WebDriver chrome = new ChromeDriver();
        chrome.get("https://fr.wikipedia.org/wiki/Sp%C3%A9cial:Page_au_hasard");

        List<WebElement> listLiens = chrome.findElements(By.xpath("//main//a[@href]"));
        int clickedLinks = 0;
        Random random = new Random();
        int chosenValue;
        String url;

        // itère sur les 10 pages voulues ou stop si aucun lien trouvé
        while (clickedLinks < 10 && !listLiens.isEmpty()) {
            chosenValue = random.nextInt(listLiens.size());
            url = listLiens.get(chosenValue).getAttribute("href");
            System.out.println(url);
            chrome.get(url);
            clickedLinks++;
            listLiens = chrome.findElements(By.xpath("//main//a[@href]"));
        }

        // prise de la capture
        Calendar calendar = Calendar.getInstance(Locale.FRANCE);
        File screenshot = ((TakesScreenshot) chrome).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(String.format("./images/wikipedia-%d-%d-%d-%d-%d-%d.png",
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND))));

        chrome.quit();
    }

}
