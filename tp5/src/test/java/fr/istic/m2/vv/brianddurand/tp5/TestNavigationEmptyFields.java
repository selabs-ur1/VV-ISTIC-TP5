package fr.istic.m2.vv.brianddurand.tp5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

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
